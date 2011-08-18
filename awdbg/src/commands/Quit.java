package commands;

import debugger.DebuggerException;
import debugger.Main;
import debugger.RemoteVMController;

public class Quit extends AbstractCommand 
{
	@Override
	public String getName() 
	{
		return "quit";		
	}

	@Override
	public String getHelpShort() {		
		return "quit";
	}

	@Override
	public String getHelpFull() 
	{
		return "Quits the debugger";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		if(remoteCtrl.isAttached())
			remoteCtrl.detach();
		
		m.signalQuit();
	}

}
