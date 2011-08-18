package debugger;

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
	
	/*
	public Method getMethod()
	{
		return method;
	}
	*/
	
	public ThreadReference thread()
	{
		return thread;
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
