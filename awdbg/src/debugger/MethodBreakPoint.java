package debugger;

public class MethodBreakPoint extends BreakPoint
{
	private String methodName;
	
	public MethodBreakPoint(RemoteVMController remoteCtrl, String methodName)
	{		
		super(remoteCtrl);
		this.methodName = methodName;	
	}
	
	public String getMethodName()
	{
		return methodName;
	}

	@Override
	public void set() 
	{
		remoteCtrl.createBreakPointRequest(methodName);
		
	}
}
