package commands;

import java.util.List;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.IncompatibleThreadStateException;

import adb.InternalDebuggerException;
import ajdi.HookFrame;
import ajdi.Location;
import ajdi.PastAdvice;
import ajdi.SourceLocation;
import ajdi.StackFrame;
import ajdi.ThreadReference;
import debugger.BreakPointContext;
import debugger.DebuggerException;

public class Where extends AbstractCommand
{

	@Override
	public String getName() {
		return "where";
	}

	@Override
	public String getHelpShort() {
		return "where";
	}

	@Override
	public String getHelpFull() {
		return "where";
	}

	private void dumpStack(List<StackFrame> frames)
	{
		int index = 0;
		String sourceName, sourceLocation, methodName, className;
		
		for(StackFrame frame : frames)
		{	
			sourceName = "";
			sourceLocation = "";
			methodName = "";
			className = "";
			
			Location loc = null;
			try 
			{
				loc = frame.location();
				methodName = loc.method().name();
				className = loc.method().declaringType().name();
				sourceName = loc.sourceName();
				sourceLocation = sourceName + ":" + loc.lineNumber();
				
			} 
			catch (AbsentInformationException e) 
			{
				sourceLocation = "Source not availble";
			}
			catch (InternalDebuggerException e)
			{
				sourceLocation = "Source not availble";
			}
									
			System.out.println("[" + index + "] " + className + "." + methodName + " " + sourceLocation);
			index++;
			
			
			if(frame instanceof HookFrame)
			{
				HookFrame hookFrame = (HookFrame) frame;
				
				//dumpStack(hookFrame.frames());
				
				System.out.println("TargetExecuted: " + hookFrame.hasTargetExecuted());
				
				System.out.println("\tMechanism\tAspect\tType\tSource Location\tSkipped\tEffect Type");
				System.out.println("\t---------------------------------------------------------------------------------");
						
				List<PastAdvice> pastAdvice = hookFrame.pastAdvices();
				
				for(PastAdvice pa : pastAdvice)
				{
					String aspectName = pa.advice().declaringType().name();
					String mechName = pa.advice().declaringType().mechanismName();
					
					String advType;
					if(pa.advice().isAfter())
					{
						advType = "AFTER";
					} 
					else if (pa.advice().isAround())
					{
						advType = "AROUND";
					} 
					else
					{
						advType = "BEFORE";
					}
										
					SourceLocation location = pa.advice().location();
					
					System.out.println("\t" + mechName  + "\t" + aspectName + "\t" + advType + "\t" + location +
							"\t" + "\t" + pa.isSkipped() + "\t" + pa.advice().effectType());							
				}
				
			}
		}		
	}
	
	@Override
	public void execute(String params) throws DebuggerException 
	{
		BreakPointContext ctx = remoteCtrl.breakPointContext();
		
		if(null == ctx)
		{
			throw new DebuggerException("Not at a breakpoint");
		}
		
		ThreadReference thread = ctx.thread();
		
		try 
		{
			System.out.println("Thread " + thread.uniqueID() + " " + thread.name());
			List<StackFrame> frames = thread.frames();
			dumpStack(frames);
	
		} catch (IncompatibleThreadStateException e) {
			throw new DebuggerException(e.getMessage());
		}	
	}
}
