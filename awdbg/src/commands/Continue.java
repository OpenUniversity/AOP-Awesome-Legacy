package commands;

import debugger.DebuggerException;

public class Continue extends AbstractCommand
{	
	@Override
	public String getName() {
		return "cont";
	}

	@Override
	public String getHelpShort() {
		return "cont";
	}

	@Override
	public String getHelpFull() {
		return "resumes the suspended VM";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		remoteCtrl.resume();
		
		synchronized(m)
		{
			m.waitForMe();
		}		
	}
}
