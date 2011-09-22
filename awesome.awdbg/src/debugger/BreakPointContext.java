package debugger;

import java.util.List;

import com.sun.jdi.IncompatibleThreadStateException;

import adb.backend.JoinPointComputation;
import ajdi.JoinPoint;
import ajdi.Method;
import ajdi.ThreadReference;
import ajdi.event.BreakpointEvent;
import ajdi.event.MethodEntryEvent;

public class BreakPointContext 
{
	Method method;
	ThreadReference thread;
	JoinPoint[] joinPoints;
	JoinPointComputation[] joinPointComputations;
	                     
	public BreakPointContext(MethodEntryEvent event)
	{
		method = event.method();
		thread = event.thread();
	}
	
	public BreakPointContext(BreakpointEvent event)
	{
		method = null;
		thread = event.thread();
	}
	
	public BreakPointContext(ThreadReference thread)
	{
		this.thread = thread;
	}
	
	
	public Method getMethod()
	{
		return method;
	}
	
	
	public ThreadReference thread()
	{
		return thread;
	}
	
	public JoinPointComputation[] getEmergingGranularity()
	{
		if(null == method)
		{
			try 
			{
				method = thread().frame(0).location().method();
			} 
			catch (IncompatibleThreadStateException e) {				
				e.printStackTrace();
				return null;
			}
		}
		
		if(null == joinPointComputations)
		{
			List<JoinPointComputation> jpList = method.exposedJoinPoints();
			joinPointComputations = new JoinPointComputation[jpList.size()];
			int i = 0;
			for(JoinPointComputation jpc : jpList)
			{
				joinPointComputations[i] = jpc;
				i++;
			}
		}
		
		return joinPointComputations;		
	}
	
	public JoinPoint[] getJoinPoints() throws DebuggerException
	{
		if(null == method)
		{
			throw new DebuggerException("Not applicable for current breakpoint");			
		}
		
		if(null == joinPoints)
		{
			joinPoints = new JoinPoint[method.allJoinPoints().size()];
			int i = 0;
			for(JoinPoint jp : method.allJoinPoints())
			{
				joinPoints[i] = jp;
			}
		}
		
		return joinPoints;
	}

}
