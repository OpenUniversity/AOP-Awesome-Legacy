package commands;

import java.util.List;

import ajdi.ThreadReference;
import debugger.BreakPointContext;
import debugger.DebuggerException;

public class SetThread extends AbstractCommand {

	@Override
	public String getName() {
		return "thread";
	}

	@Override
	public String getHelpShort() {
		return "thread <id>";
	}

	@Override
	public String getHelpFull() 
	{
		return "switches the context to the given thread";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		try
		{
			if(params.isEmpty())
			{
				System.out.println("usage:" + getHelpShort());
				return;
			}
			
			if(null == remoteCtrl.shadowMaster())
			{
				throw new DebuggerException("Not attached to a VM");				
			}
			
			int threadId = Integer.parseInt(params);
			ThreadReference foundThread = null;
			
			List<ThreadReference> threads = remoteCtrl.shadowMaster().allThreads();
			for(ThreadReference thread : threads)
			{
				if(thread.uniqueID() == threadId)
				{
					foundThread = thread;		
					break;
				}
			}
			
			if(null == foundThread)
			{
				throw new DebuggerException("Thread " + threadId + " not found");
			}
			
			remoteCtrl.setBreakPointContext(new BreakPointContext(foundThread));			
		}
		catch(NumberFormatException e)
		{
			System.out.println("usage:" + getHelpShort());
		}
	}
	

}
