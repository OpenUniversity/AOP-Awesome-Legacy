package commands;

import java.io.IOException;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;

import debugger.DebuggerException;
import debugger.Main;
import debugger.RemoteVMController;

public class Attach extends AbstractCommand 
{
	@Override
	public String getName() 
	{
		return "attach";
	}

	@Override
	public String getHelpShort() 
	{
		return "attach <address>:<port>";
	}

	@Override
	public String getHelpFull() 
	{
		return "Attaches the debuger to the virtual machine that is listening " +
		       "on the given address and port";
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
		
		String[] connectTo = null;
		
		connectTo = paramsArr[0].split(":");
		if(connectTo.length != 2)			
		{
			System.out.println("usage: " + getHelpShort());
			return;
		}
		
		try 
		{
			remoteCtrl.attach(connectTo[0], connectTo[1]);		
			System.out.println("Attached successfuly. Use 'cont' to resume");
		} 
		catch (IOException e) 
		{		
			System.out.println("failed to attach: " + e.getMessage());			
		} 
		catch (IllegalConnectorArgumentsException e) 
		{
			System.out.println("failed to attach: " + e.getMessage());
		}		
		
				
	}

}
