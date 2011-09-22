package adb.backend;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JoinPointComputation 
{
	private int typeId;
	private String sourceFile;
	private int sourceLine;
	Map<String, List<String>> visibleIn;
	
	public List<String> getVisibleIn()
	{
		List<String> visibleInList = new LinkedList<String>();
		
		for(String key : visibleIn.keySet())
			visibleInList.add(key);
		
		return visibleInList;
	}
	
	public List<String> getAdviceKinds(String mechName)
	{
		return visibleIn.get(mechName);		
	}
	
	public int getType()
	{
		return typeId;
	}
		
	public String getSourceFile()
	{
		return sourceFile;
	}
	
	public int getSourceLine()
	{
		return sourceLine;
	}
	
	public String getTypeName()
	{
		return JoinPointType.getTypeName(typeId);
	}
	
	public JoinPointComputation(int typeId, String sourceFile, int sourceLine, 
			Map<String, List<String>> visibleIn)
	{
		this.typeId = typeId;
		this.sourceFile = sourceFile;
		this.sourceLine = sourceLine;
		this.visibleIn = visibleIn;
	}
	

}
