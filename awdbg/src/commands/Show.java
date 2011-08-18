package commands;

import java.util.Set;

import debugger.DebuggerException;
import debugger.Main;
import debugger.RemoteVMController;

public class Show extends AbstractCommand 
{
	Commands showCommands;
	
	public void setParams(Main m, RemoteVMController remoteCtrl)
	{
		super.setParams(m, remoteCtrl);
		
		showCommands = new Commands(m, remoteCtrl);
		
		IDebuggerCommand command = new ShowJoinpoints();
		showCommands.register(command);	
		
		command = new ShowAdvice();
		showCommands.register(command);	
	}
	
	@Override
	public String getName() 
	{
		return "show";
	}

	@Override
	public String getHelpShort() 
	{
		StringBuffer helpShort = new StringBuffer("\n");
		Set<String> names = showCommands.getNames();
		
		int i=0;
		for(String name : names)
		{
			helpShort.append("\t" + name);
			i++;
			if(i < names.size())
				helpShort.append("\n");
						
		}
		
		return helpShort.toString();
	}

	@Override
	public String getHelpFull() 
	{		
		StringBuffer helpShort = new StringBuffer("\n");
		Set<String> names = showCommands.getNames();
		
		int i=0;
		for(String name : names)
		{
			helpShort.append("\t" + name);
			i++;
			if(i < names.size())
				helpShort.append("\n");
						
		}
		
		return helpShort.toString();
	
	}

	@Override
	public void execute(String showCommand) throws DebuggerException 
	{
		if(showCommand.length() == 0)
		{
			System.out.println("usage: " + getHelpShort());
			return;
		}
		
		showCommands.execute(showCommand);		
	}	
}
