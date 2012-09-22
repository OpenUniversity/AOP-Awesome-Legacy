package commands;

import debugger.DebuggerException;

public class BreakAt extends AbstractCommand 
{

	@Override
	public String getName() {
		return "breakat";
	}

	@Override
	public String getHelpShort() {
		return "breakat <class id>:<line number>";
	}

	@Override
	public String getHelpFull() 
	{
		return "add a breakpoint at the specified line";
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
				
		String breakParams[] = paramsArr[0].split(":");
		
		if(breakParams.length != 2)
		{
			System.out.println("usage: " + getHelpShort());
			return;
		}
		
		String className = breakParams[0];
		int lineNumber;
		try
		{
			lineNumber = Integer.parseInt(breakParams[1]);			
		}
		catch(NumberFormatException e)
		{
			System.out.println("usage: " + getHelpShort());
			return;			
		}
		
		remoteCtrl.setBreakpointAtLine(paramsArr[0], className, lineNumber);
		
	}

}
