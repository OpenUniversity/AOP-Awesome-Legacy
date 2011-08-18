package debugger;

public abstract class BreakPoint 
{
	protected RemoteVMController remoteCtrl;
	
	static private int nextId = 1;
	
	private int myId;
	private int hitCount;
	
	public BreakPoint(RemoteVMController remoteCtrl)
	{
		this.remoteCtrl = remoteCtrl;
		
		myId = nextId;
		nextId++;
		
		hitCount = 0;
	}
	
	public void hit()
	{
		hitCount++;
	}
	
	public void resetHitCount()
	{
		hitCount = 0;
	}
	
	public int getHitCount()
	{
		return hitCount;
	}
	
	public int getId()
	{
		return myId;
	}
	
	public abstract void set() throws DebuggerException;

	
}
