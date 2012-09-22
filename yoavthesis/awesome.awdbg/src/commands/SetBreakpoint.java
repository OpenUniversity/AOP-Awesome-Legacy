package commands;

import debugger.DebuggerException;

public class SetBreakpoint extends AbstractCommand 
{

	
	@Override
	public String getName() 
	{		
		return "break";
	}

	@Override
	public String getHelpShort() 
	{		
		return "break <method>";
	}

	@Override
	public String getHelpFull() 
	{
		return "sets a breakpoint when entering the given method";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		if(params.length() == 0)
		{
			System.out.println("usage: " + getHelpShort());
			return;
		}
		
		String[] paramsArr = params.split(" ");
		
		if(paramsArr.length != 1)
		{
			System.out.println("usage: " + getHelpShort());
			return;
		}
				
		remoteCtrl.setMethodBreakpoint(paramsArr[0]);
	}

}
