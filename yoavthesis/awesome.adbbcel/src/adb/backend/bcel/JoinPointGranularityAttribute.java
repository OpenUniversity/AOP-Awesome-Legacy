package adb.backend.bcel;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.bcel.classfile.AttributeReader;
import org.apache.bcel.classfile.ConstantPool;

import adb.backend.JoinPointComputation;

import com.sun.org.apache.bcel.internal.Constants;

public class JoinPointGranularityAttribute extends Attribute 
{

	private List<JoinPointComputation> jpcs;

	protected JoinPointGranularityAttribute(int name_index, int length,
			ConstantPool constant_pool, List<JoinPointComputation> jpcs) 
	{
		super(name_index, length, constant_pool);
		this.jpcs = jpcs;
	}
	
	public static final String NAME = "JoinPointGranularityAttribute";

	public List<JoinPointComputation> getJoinPointsList()
	{
		return jpcs;
	}
	
	public static class JoinPointGranularityAttributeReader implements AttributeReader 
	{
		@Override
		public org.apache.bcel.classfile.Attribute createAttribute(
				int name_index, int length, DataInputStream file,
				ConstantPool constant_pool)
		{
			String name = constant_pool.constantToString(name_index, Constants.CONSTANT_Utf8);
			if(!NAME.equals( name ))
			{
				return null;
			}
			
			List<JoinPointComputation> jpcs = new LinkedList<JoinPointComputation>();
			
			try 
			{
				int size = file.readInt();
				
				for(int i=0; i<size; i++)
				{
					byte type = file.readByte();
					int sourceLine = file.readInt();
					String sourceFile = file.readUTF();
					
					int visibleCount = file.readInt();
					//List<String> visibleIn = new LinkedList<String>();
					
					Map<String, List<String>> mechToAdviceKinds =
						new HashMap<String, List<String>>();
										
					for(int j=0 ; j<visibleCount; j++)
					{					
						List<String> adviceKinds = new LinkedList<String>();
						
						String mechName = file.readUTF();
						int kindsSize = file.readInt();
							
						for(int k=0; k<kindsSize; k++)
						{
							String kindName = file.readUTF();
							adviceKinds.add(kindName);
						}
						
						mechToAdviceKinds.put(mechName, adviceKinds);
					}
					
					
					
					JoinPointComputation jpc = 
						new JoinPointComputation(type, sourceFile.toString(), sourceLine, mechToAdviceKinds);
					jpcs.add(jpc);
				}
								
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return new JoinPointGranularityAttribute(name_index, length, constant_pool, jpcs);			
		}
		
		public String getName() {
			return NAME;
		}
	}

	@Override
	public String getName() 
	{		
		return NAME;
	}

	@Override
	public org.apache.bcel.classfile.Attribute copy(ConstantPool _constant_pool) 
	{
		return new JoinPointGranularityAttribute(name_index, length,_constant_pool, jpcs); 
	}
	
	@Override
	public org.apache.bcel.classfile.Attribute clone()
	{
		return new JoinPointGranularityAttribute(name_index, length, constant_pool, jpcs);
	}

}
