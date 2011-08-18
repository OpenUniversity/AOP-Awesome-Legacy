package debugger;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import adb.ShadowMaster;
import adb.backend.bcel.BCELBackend;
import adb.backend.bcel.spi.AspectInfoProvider;
import adb.backend.bcel.spi.AspectInstanceProvider;
import adb.backend.bcel.spi.CrossCuttingInfoProvider;
import adb.backend.bcel.spi.FieldLineNumberProvider;
import adb.backend.bcel.spi.FilterManager;
import ajdi.ClassType;
import ajdi.Location;
import ajdi.event.BreakpointEvent;
import ajdi.event.ClassPrepareEvent;
import ajdi.event.Event;
import ajdi.event.EventQueue;
import ajdi.event.EventSet;
import ajdi.event.MethodEntryEvent;
import ajdi.event.ThreadDeathEvent;
import ajdi.event.ThreadStartEvent;
import ajdi.event.VMDeathEvent;
import ajdi.event.VMDisconnectEvent;
import ajdi.request.BreakpointRequest;
import ajdi.request.ClassPrepareRequest;
import ajdi.request.EventRequest;
import ajdi.request.EventRequestManager;
import ajdi.request.MethodEntryRequest;
import ajdi.request.ThreadDeathRequest;
import ajdi.request.ThreadStartRequest;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Bootstrap;
import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.Connector.Argument;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.tools.jdi.SocketAttachingConnector;


public class RemoteVMController implements Runnable
{
	private VirtualMachine vm = null;
	private ShadowMaster sm = null;
	private Main m = null;
	private Thread controlThread = null;
	private EventRequestManager requestManager = null;
	
	private Map<String, BreakPoint> breakAtMethods;
	
	private Set<String> breakAtClasses;
	
	private Set<String> unpreparedClasses;
	private Map<String, List<LineBreakPoint>> pendingLineBreakPoints;
	
	private String classPath = "";
	
	private BreakPointContext bpContext = null; 

	public ShadowMaster shadowMaster()
	{
		return sm;
	}
	
	public EventRequestManager requestManager()
	{
		return requestManager;
	}
	
	public void setClasspath(String path)
	{
		classPath = path;
	}
	
	public BreakPointContext breakPointContext()
	{
		return bpContext;
	}
	
	public void setBreakPointContext(BreakPointContext ctx)
	{
		bpContext = ctx;
	}
	
	void setClassPath(String classPath)
	{
		this.classPath = classPath;
	}
	
	public RemoteVMController(Main m)
	{
		this.m = m;		
		breakAtMethods = new HashMap<String, BreakPoint>();
	}

	private void createShadowMaster() 
	{
		
		BCELBackend back = new BCELBackend(classPath);
			
		FieldLineNumberProvider flp = new FieldLineNumberProvider(back);
		AspectInfoProvider aip = new AspectInfoProvider(back);
		CrossCuttingInfoProvider ccip = new CrossCuttingInfoProvider(back,vm);
		
		FilterManager fm = new FilterManager(back,aip);
		sm = new ShadowMaster(vm,flp,aip,ccip,new AspectInstanceProvider(),fm,fm,null,true);
		
		requestManager = sm.getEventRequestManager();
	}
/*
	private ajdi.ThreadReference getThreadRef(String name)
	{
		ThreadReference ref = null;
		
		List<ThreadReference> threadRefs = sm.allThreads();
		for(ThreadReference tr : threadRefs)
		{			
			if(tr.name().equals(name))
			{
				ref = tr;		
				break;
			}						
		}
		
		return ref;		
	}
	*/
	
	static private Connector getConnector(String connectorName)
	{
		Connector foundConnector = null;
		
		java.util.List<Connector> connectors = Bootstrap.virtualMachineManager().allConnectors();
		for (Connector c : connectors)
		{	
			if(c.name().equals(connectorName))
			{
				foundConnector = c;
				break;
			}
				
		}				
		
		return foundConnector;		
	}
	
	public boolean isAttached()
	{
		return (vm != null);
	}
	
	public void detach() throws DebuggerException
	{
		if(null == vm)
		{
			throw new DebuggerException("Not attached to a VM");				
		}
	
		controlThread.interrupt();
		vm.dispose();
		
		vm = null;
		sm = null;
		controlThread = null;
		requestManager = null;
		bpContext = null;
		
	}

	private void registerForThreadEvents()
	{
		ThreadStartRequest threadStart = requestManager.createThreadStartRequest();		
		threadStart.enable();
		
		ThreadDeathRequest threadEnd = requestManager.createThreadDeathRequest();
		threadEnd.enable();
	}
	
	public void attach(String host, String port) throws IOException, IllegalConnectorArgumentsException, DebuggerException
	{
		if(null != vm)
		{
			throw new DebuggerException("Already attached to a VM");
		}
		
		unpreparedClasses = new HashSet<String>();
		breakAtClasses = new HashSet<String>();
		pendingLineBreakPoints = new HashMap<String, List<LineBreakPoint>>();
		
		Connector myConnector = getConnector("com.sun.jdi.SocketAttach");
		java.util.Map<String, Argument> connectorArgs = myConnector.defaultArguments();	
		connectorArgs.get("hostname").setValue(host);
		connectorArgs.get("port").setValue(port);
		
		SocketAttachingConnector procAttach = (SocketAttachingConnector) myConnector;
		
		vm = procAttach.attach(connectorArgs);	
		createShadowMaster();
			
		registerForThreadEvents();
		
		controlThread = new Thread(this, "VMRemotecontrol");
		controlThread.start();
		
	}

	/*
	private void reEnableBreakPoints() throws DebuggerException
	{
		Set<String> methods = breakAtMethods.keySet();
		for(String method : methods)
		{
			BreakPoint bp = breakAtMethods.get(method);
			bp.resetHitCount();
			
			//createBreakPointRequest(method);
			bp.set();
		}	
	}
	*/
	
	public void resume() throws DebuggerException
	{
		if(null == vm)
		{
			throw new DebuggerException("Not attached to a VM");				
		}
		
		bpContext = null;
		vm.resume();	
	}
	
	/*
	void createLineBreakPointRequest(String className, int lineNumber) throws DebuggerException
	{		
		List<Location> locations;
		try 
		{
			ClassType classType = sm.getClassForName(className);
			locations = classType.allLineLocations();
			
			for(Location location : locations)
			{
				if(location.lineNumber() == lineNumber)
				{
					BreakpointRequest req = requestManager.createBreakpointRequest(location);
					req.setSuspendPolicy(EventRequest.SUSPEND_ALL);
					req.enable();
				}
			}
		} 
		catch (AbsentInformationException e) 
		{
			throw new DebuggerException("Missing source information for class " + className);
		}		
		
	}
	*/
	public void createBreakPointRequest(String fullName)
	{
		int lastDot = fullName.lastIndexOf(".");
		String className = fullName.substring(0, lastDot);
		
		try
		{		
			if(!breakAtClasses.contains(className))
			{
				// only 1 request is needed per class
				ClassType classType = sm.getClassForName(className);
				
				MethodEntryRequest request = null;
				request = requestManager.createMethodEntryRequest();
				request.addClassFilter(classType);
				
				request.setSuspendPolicy(EventRequest.SUSPEND_ALL);
				request.enable();		
				
				breakAtClasses.add(className);
			}
		}
		catch(ClassNotPreparedException e)
		{
			if(!unpreparedClasses.contains(className))
			{
				// process the breakpoint once the class was prepared
				ClassPrepareRequest cpr = 
					sm.getEventRequestManager().createClassPrepareRequest();
				cpr.setSuspendPolicy(EventRequest.SUSPEND_ALL);
				
				unpreparedClasses.add(className);
				cpr.enable();
			}
		}
		
	}
	
	public void setBreakpointAtLine(String fullName, String className, int lineNumber) throws DebuggerException
	{
		BreakPoint bp = null;
		
		try
		{
			if(null == vm)
			{
				throw new DebuggerException("Not attached to a VM");				
			}
			
			bp = breakAtMethods.get(fullName);
			if(null != bp)
			{
				throw new DebuggerException("Breakpoint already set at " + fullName);
			}
			
			bp = new LineBreakPoint(this, className, lineNumber);
			
			ClassType classType = sm.getClassForName(className);
			
			BreakpointRequest req = null;
			
			List<Location> locations;
			try 
			{
				locations = classType.allLineLocations();
				
				for(Location location : locations)
				{
					if(location.lineNumber() == lineNumber)
					{
						req =  requestManager.createBreakpointRequest(location);
						req.putProperty("className", className);
						req.setSuspendPolicy(EventRequest.SUSPEND_ALL);
						req.enable();					
					}
				}
				
				if(req == null)
				{
					throw new DebuggerException("Location " + fullName + " not found");
				}
				
				
				breakAtMethods.put(fullName, bp);
			} 
			catch (AbsentInformationException e) 
			{
				System.out.println("Cannot set breakpoint at " + fullName + ". Missing source information for class " + className);
			}					
		}
		catch(ClassNotPreparedException e)
		{
			List<LineBreakPoint> breaks = pendingLineBreakPoints.get(className);
			if(breaks == null)
			{
				breaks = new LinkedList<LineBreakPoint>();		
				pendingLineBreakPoints.put(className, breaks);
			}
			
			breaks.add((LineBreakPoint) bp);
			
			if(!unpreparedClasses.contains(className))
			{
				// process the breakpoint once the class was prepared
				ClassPrepareRequest cpr = 
					sm.getEventRequestManager().createClassPrepareRequest();
				cpr.setSuspendPolicy(EventRequest.SUSPEND_ALL);
				
				unpreparedClasses.add(className);
				cpr.enable();
			}
		}
	}
	
	public void setMethodBreakpoint(String fullName) throws DebuggerException
	{
		if(null == vm)
		{
			throw new DebuggerException("Not attached to a VM");				
		}
	
		BreakPoint bp = breakAtMethods.get(fullName);
		if(null != bp)
		{
			throw new DebuggerException("Breakpoint already set at " + fullName);
		}
			
		bp = new MethodBreakPoint(this, fullName);
		breakAtMethods.put(fullName, bp);

		//createBreakPointRequest(fullName);
		bp.set();
			
		System.out.println("Added breakpoint [" + bp.getId() + "] at " + fullName);
	}
	
	void handleBreakPoint(BreakpointEvent event)
	{
		int lineNumber = event.location().lineNumber();
		String className;
		String fullName = "";
		
		className = (String) event.request().getProperty("className");
		fullName = className + ":" + lineNumber;
		
		long threadId = event.thread().uniqueID();
		
		BreakPoint bp = breakAtMethods.get(fullName);
		bp.hit();
		
		System.out.println("[" + threadId + "]" + " Hit breakpoint [" + bp.getId() + "] at " + fullName + " " +
				bp.getHitCount() + " time(s) " );
		
		bpContext = new BreakPointContext(event);
		
		synchronized(m)
		{
			m.notify();
		}		
	}
	
	void handleMethodEntry(MethodEntryEvent event)
	{
		String methodName = event.method().name();
		String className = event.method().declaringType().name();
		String fullName = className + "." + methodName;
		
		// filter non relevant breakpoints
		BreakPoint bp = breakAtMethods.get(fullName);
		if(null != bp)
		{
			bp.hit();
			
			long threadId = event.thread().uniqueID();
			System.out.println("[" + threadId + "]" + " Hit breakpoint [" + bp.getId() + "] at " + fullName + " " +
					bp.getHitCount() + " time(s) " );
			
			try 
			{
				int lineNumber = event.method().location().lineNumber();
				String sourceName = event.method().location().sourcePath();
				System.out.println("\t" + sourceName + ":" + lineNumber);
				
				bpContext = new BreakPointContext(event);
			} 
			catch (AbsentInformationException e) 
			{				
				System.out.println("\tMissing source information");
			}
						
			synchronized(m)
			{
				m.notify();
			}
		}
		else
		{
			vm.resume();
		}
	
		return;		
	}
	
	void handleClassPrepare(ClassPrepareEvent event)
	{
		String className = event.referenceType().name();
		
		//System.out.println("ClassPrepareEvent name = " + className);
		
		if(unpreparedClasses.contains(className))
		{
			ClassType classType = sm.getClassForName(className);
								
			MethodEntryRequest request = null;
			request = requestManager.createMethodEntryRequest();
			request.addClassFilter(classType);
			
			request.setSuspendPolicy(EventRequest.SUSPEND_ALL);
			request.enable();
			
			breakAtClasses.add(className);
			unpreparedClasses.remove(className);
		}
		
		List<LineBreakPoint> breaks = pendingLineBreakPoints.get(className);
		if(breaks != null)
		{
			for(LineBreakPoint bp : breaks)
			{
				try 
				{
					bp.set();
				} 
				catch (DebuggerException e) 
				{
					System.out.println("Error setting pending breakpoint at " + bp.className() + 
							":" + bp.lineNumber());
				}
			}				
		}
	}

	@Override
	public void run() 
	{
		EventQueue queue = sm.getEventQueue();	
		boolean runLoop = true;
		
		EventSet events = null;
		
		try 
		{			
			while(runLoop)
			{								
				events = queue.remove();
				
				for(Event e: events)
				{
					/*
					if (e instanceof VMStartEvent)
					{
						ClassPrepareRequest cpr = 
							sm.getEventRequestManager().createClassPrepareRequest();
						cpr.setSuspendPolicy(EventRequest.SUSPEND_ALL);
						cpr.enable();											
					}
					*/
					
					if (e instanceof VMDeathEvent)
					{
						System.out.println("Remote VM has ended");	
						runLoop = false;
						break;						
					}
					
					if (e instanceof ThreadStartEvent)
					{
						ThreadStartEvent startEvent = (ThreadStartEvent) e;
						System.out.println("[Thread " + startEvent.thread().uniqueID() + " " + 
								startEvent.thread().name() + " start]");
						vm.resume();
						break;						
					}
					
					if (e instanceof ThreadDeathEvent)
					{
						ThreadDeathEvent deathEvent = (ThreadDeathEvent) e;
						System.out.println("[Thread " + deathEvent.thread().uniqueID() + " " + 
								deathEvent.thread().name() + " end]");	
						vm.resume();
						break;						
					}
					
					if (e instanceof VMDisconnectEvent)
					{
						System.out.println("Remote VM has disconnected");
						runLoop = false;
						
						break;						
					}
					
					if(e instanceof MethodEntryEvent)						
					{						
						handleMethodEntry((MethodEntryEvent) e);					
					}
					
					if(e instanceof ClassPrepareEvent)
					{
						handleClassPrepare((ClassPrepareEvent) e);
						vm.resume();
					}
					
					if(e instanceof BreakpointEvent)
					{
						handleBreakPoint((BreakpointEvent) e);						
					}
					
				}				
			}
			
			vm = null;
			sm = null;
			breakAtClasses = null;
			breakAtClasses = null;
			
						
			synchronized(m)
			{				
				m.notify();
			}
		}
		catch (InterruptedException e) 
		{
			//System.out.println("[Controller thread done]");
		}
		
		synchronized(m)
		{
			m.signalQuit();
		}
		
	}

}
