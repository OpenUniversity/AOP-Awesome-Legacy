package commands;

import debugger.DebuggerException;

public class Detach extends AbstractCommand
{
		
	@Override
	public String getName() {
		return "detach";
	}

	@Override
	public String getHelpShort() {
		return "detach";
	}

	@Override
	public String getHelpFull() {
		return "Detaches from the remote VM";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		remoteCtrl.detach();		
	}
	

}
