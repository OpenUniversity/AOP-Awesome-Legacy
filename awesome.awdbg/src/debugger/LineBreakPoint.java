package debugger;

import java.util.List;

import com.sun.jdi.AbsentInformationException;

import ajdi.ClassType;
import ajdi.Location;
import ajdi.request.BreakpointRequest;
import ajdi.request.EventRequest;

public class LineBreakPoint extends BreakPoint 
{
	private String className;
	private int lineNumber;
	
	public LineBreakPoint(RemoteVMController remoteCtrl, String className, int lineNumber)
	{
		super(remoteCtrl);
		
		this.className = className;
		this.lineNumber = lineNumber;
	}

	public int lineNumber()
	{
		return lineNumber;
	}
	
	public String className()
	{
		return className;
	}
	
	@Override
	public void set() throws DebuggerException 
	{
		String fullName = className + ":" + lineNumber;
		
		remoteCtrl.setBreakpointAtLine(fullName, className, lineNumber);
	}
}
