package commands;

import debugger.DebuggerException;

public class Help extends AbstractCommand 
{

	@Override
	public String getName() {		
		return "help";
	}

	@Override
	public String getHelpShort() {
		return "help [command name]";
	}

	@Override
	public String getHelpFull() {
		return "explains the given command. If no command is given, displays a list of commands.";
	}

	@Override
	public void execute(String params) throws DebuggerException
	{
		if(params.isEmpty())
		{
			m.getCommands().printHelp();
		}
		else
		{
			m.getCommands().printHelpForCommand(params);
		}
	}

}
