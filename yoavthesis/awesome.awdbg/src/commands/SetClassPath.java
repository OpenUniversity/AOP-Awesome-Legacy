package commands;

import debugger.DebuggerException;

public class SetClassPath extends AbstractCommand
{
	@Override
	public String getName() 
	{
		return "classpath";
	}

	@Override
	public String getHelpShort() 
	{
		return "classpath <path>";		
	}

	@Override
	public String getHelpFull() 
	{
		return "sets the classpath";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		if(params.isEmpty())
		{
			System.out.println(getHelpShort());
			return;
		}
		
		remoteCtrl.setClasspath(params);
	}

}
