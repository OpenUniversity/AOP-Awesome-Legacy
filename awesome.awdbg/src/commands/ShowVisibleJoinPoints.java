package commands;

import java.util.List;

import adb.backend.JoinPointComputation;
import ajdi.Method;

import com.sun.jdi.IncompatibleThreadStateException;

import debugger.DebuggerException;

public class ShowVisibleJoinPoints extends AbstractCommand   
{

	@Override
	public String getName() {
		return "visiblejoinpoints";
	}

	@Override
	public String getHelpShort() {
		return "visiblejoinpoints <mechanism name>";
	}

	@Override
	public String getHelpFull() {
		return "visiblejoinpoints  <mechanism name>";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		if(params.isEmpty())
		{
			System.out.println(getHelpShort());
			return;
		}
		
		String mechName = params;
		Method method;
		try {
			method = remoteCtrl.breakPointContext().thread().frame(0).location().method();
		} catch (IncompatibleThreadStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		List<JoinPointComputation> jpcs = method.visibleJoinPoints(mechName);
		
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
