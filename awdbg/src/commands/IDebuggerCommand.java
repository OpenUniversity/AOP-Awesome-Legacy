package commands;

import debugger.DebuggerException;
import debugger.Main;
import debugger.RemoteVMController;

public interface IDebuggerCommand 
{
	String getName();
	String getHelpShort();
	String getHelpFull();
	void execute(String params) throws DebuggerException;
	
	void setParams(Main m, RemoteVMController remoteCtrl);
}
