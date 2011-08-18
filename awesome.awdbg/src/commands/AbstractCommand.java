package commands;

import debugger.Main;
import debugger.RemoteVMController;

public abstract class AbstractCommand implements IDebuggerCommand {

	protected RemoteVMController remoteCtrl;
	protected Main m;
	
	public void setParams(Main m, RemoteVMController remoteCtrl)
	{
		this.m = m;
		this.remoteCtrl = remoteCtrl;
	}
	
}
