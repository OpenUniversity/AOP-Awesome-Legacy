package commands;

import java.util.List;

import ajdi.ThreadReference;
import debugger.DebuggerException;

public class Threads extends AbstractCommand {

	@Override
	public String getName() {
		return "threads";
	}

	@Override
	public String getHelpShort() {
		return "threads";
	}

	@Override
	public String getHelpFull() {
		return "lists running threads";	}

	@Override
	public void execute(String params) throws DebuggerException 
	{		
		if(null == remoteCtrl.shadowMaster())
		{
			throw new DebuggerException("Not attached to a VM");				
		}
		
		List<ThreadReference> threads = remoteCtrl.shadowMaster().allThreads();
		
		System.out.println("ID\tName");
		System.out.println("----------------------------------------------------------------------");
		
		for(ThreadReference thread : threads)
		{
			System.out.println(thread.uniqueID() + "\t" + thread.name());			
		}
	}

}
