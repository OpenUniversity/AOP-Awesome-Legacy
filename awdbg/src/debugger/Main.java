package debugger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import commands.Attach;
import commands.BreakAt;
import commands.Commands;
import commands.Continue;
import commands.Detach;
import commands.Help;
import commands.IDebuggerCommand;
import commands.Quit;
import commands.SetBreakpoint;
import commands.SetClassPath;
import commands.SetThread;
import commands.Show;
import commands.Threads;
import commands.Where;

public class Main 
{
	final String prompt = "(awdb) ";
	
	private boolean quit = false; 
	private boolean waitForCommand = false;
	private Commands commandsMgr = null;
	private RemoteVMController remoteCtrl = null;
	
	public void signalQuit()
	{
		quit = true;
	}
	
	public void waitForMe()
	{
		waitForCommand = true;
	}
	
	public Commands getCommands()
	{
		return commandsMgr;
	}
	
	private void registerCommands()
	{
		IDebuggerCommand command = new Quit();
		commandsMgr.register(command);	
		
		command = new Attach();
		commandsMgr.register(command);
		
		command = new Detach();
		commandsMgr.register(command);
		
		command = new Continue();
		commandsMgr.register(command);
		
		command = new SetBreakpoint();
		commandsMgr.register(command);
		
		command = new Show();
		commandsMgr.register(command);
		
		command = new SetClassPath();
		commandsMgr.register(command);
		
		command = new Where();
		commandsMgr.register(command);
		
		command = new BreakAt();
		commandsMgr.register(command);
		
		command = new Threads();
		commandsMgr.register(command);
		
		command = new SetThread();
		commandsMgr.register(command);
		
		command = new Help();
		commandsMgr.register(command);
	}
	
	private void run()
	{
		registerCommands();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		String commandLine = null;
		String prevCommand;
		
		while(!quit)
		{
			try
			{
				waitForCommand = false;
				
				System.out.print(prompt);
				
				prevCommand = commandLine;
				commandLine = bufferedReader.readLine();
				
				if(commandLine.isEmpty())
				{
					if(null != prevCommand)
						commandLine = prevCommand;
					else
						continue;
				}
					
				commandsMgr.execute(commandLine);
				
				synchronized (this)
				{
					if(waitForCommand)
						wait();
				}
				
			}
			catch(DebuggerException e)
			{
				System.out.println("Error: " + e.getMessage());
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public Main()
	{		
		remoteCtrl = new RemoteVMController(this);
		commandsMgr = new Commands(this, remoteCtrl);
	}
		
	public static void main(String[] args) 
	{
		Main m = new Main();
		m.run();
	}

}
