package commands;

import ajdi.JoinPoint;
import debugger.BreakPointContext;
import debugger.DebuggerException;

public class ShowJoinpoints extends AbstractCommand 
{
	@Override
	public String getName() 
	{
		return "joinpoints";
	}

	@Override
	public String getHelpShort() 
	{
		return "joinpoints";
	}

	@Override
	public String getHelpFull() 
	{
		return "joinpoints";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		BreakPointContext ctx = remoteCtrl.breakPointContext();
		if(null == ctx)
		{
			throw new DebuggerException("Not at a breakpoint");
		}
		
		JoinPoint[] jps = remoteCtrl.breakPointContext().getJoinPoints();
		
		System.out.println("[ID]\t[Joinpoint]");
		System.out.println("------------------------------------------");
		
		int i;
		for(i=0; i<jps.length; i++)
		{
			System.out.println(i + "\t" + jps[i].toString());			
		}
	}

}
