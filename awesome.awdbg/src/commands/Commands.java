package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import debugger.DebuggerException;
import debugger.Main;
import debugger.RemoteVMController;

public class Commands 
{
	Main m;
	RemoteVMController remoteCtrl;
	
	private Map<String, IDebuggerCommand> commandsMap;
	
	public Commands(Main m, RemoteVMController remoteCtrl)
	{
		commandsMap = new HashMap<String, IDebuggerCommand>();	
		this.m = m;
		this.remoteCtrl = remoteCtrl;
	}
	
	public void register(IDebuggerCommand command)
	{
		command.setParams(m, remoteCtrl);
		commandsMap.put(command.getName(), command);
	}
	
	public void execute(String commandLine) throws DebuggerException
	{
		String name;
		
		int endIndex = commandLine.indexOf(' ');
		if(endIndex == -1)
		{
			name = commandLine;			
		}
		else
		{
			name = commandLine.substring(0, endIndex);
		}

		IDebuggerCommand command = commandsMap.get(name);
		if(null == command)
		{
			throw new DebuggerException("Unknown command " + name);			
		}
		
		String params = "";
		
		if(endIndex != -1)
		{
			params = commandLine.substring(endIndex+1);
		}
		
		command.execute(params);		
	}
	
	Set<String> getNames()
	{
		Set<String> commandNames = commandsMap.keySet();
		return commandNames;
	}
	
	public void printHelp()
	{
		Set<String> commandNames = commandsMap.keySet();
		for(String name : commandNames)
		{
			IDebuggerCommand command = commandsMap.get(name);
			System.out.println(name + "\t" + command.getHelpShort());			
		}		
	}
	
	public void printHelpForCommand(String params)
	{
		String[] splitParams = params.split(" ");
		IDebuggerCommand command = commandsMap.get(splitParams[0]);
		if(null == command)
		{
			printHelp();	
			return;
		}
		
		System.out.println(splitParams[0] + "\t" + command.getHelpFull());
		
	}

}
