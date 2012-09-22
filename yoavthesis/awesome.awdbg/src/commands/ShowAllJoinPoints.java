package commands;

import java.util.List;

import com.sun.jdi.IncompatibleThreadStateException;

import adb.backend.JoinPointComputation;
import ajdi.Method;
import debugger.BreakPointContext;
import debugger.DebuggerException;

public class ShowAllJoinPoints extends AbstractCommand  
{

	@Override
	public String getName() {
		return "alljoinpoints";
	}

	@Override
	public String getHelpShort() {
		return "alljoinpoints";
	}

	@Override
	public String getHelpFull() {
		return "alljoinpoints";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		BreakPointContext ctx = remoteCtrl.breakPointContext();
		if(null == ctx)
		{
			throw new DebuggerException("Not at a breakpoint");
		}
		
		JoinPointComputation jpcs[] = ctx.getEmergingGranularity();
		
		System.out.println("[ID]\t[Joinpoint type]\t[Source location]");
		System.out.println("------------------------------------------");
		
		int i = 0;
		for(JoinPointComputation j : jpcs)
		{
			System.out.println(i + "\t" + j.getTypeName() + "\t" + j.getSourceFile() + ":" + j.getSourceLine());
			i++;
		}		
	}
	

}
