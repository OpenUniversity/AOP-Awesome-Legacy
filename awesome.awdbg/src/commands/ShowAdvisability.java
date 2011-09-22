package commands;

import java.util.List;

import adb.backend.JoinPointComputation;
import ajdi.JoinPoint;
import debugger.DebuggerException;

public class ShowAdvisability extends AbstractCommand 
{

	@Override
	public String getName() {
		return "advisability";
	}

	@Override
	public String getHelpShort() {
		return "advisability <joinpoint id> <mechinsm name>";
	}

	@Override
	public String getHelpFull() {
		return "advisability <joinpoint id> <mechinsm name>";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		String[] paramsArr = params.split(" ");
		if(paramsArr.length != 2)
		{
			System.out.println(getHelpShort());
			return;
		}
		
		try
		{
			int jpId = Integer.parseInt(paramsArr[0]);
			String mechName = paramsArr[1];
			
			JoinPointComputation[] jps = remoteCtrl.breakPointContext().getEmergingGranularity();
			if( (jpId > jps.length-1) || (jpId < 0))
			{
				throw new DebuggerException("Invalid joinpoint ID " + jpId);
			}
			
			List<String> kinds = jps[jpId].getAdviceKinds(mechName);
			for(String kind : kinds)
			{
				System.out.println(kind);
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println(getHelpShort());
		}
		
	}
	

}
