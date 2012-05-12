package awesome.platform.adb.tagkit;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.BCException;
import org.aspectj.weaver.bcel.LazyMethodGen;

import awesome.platform.adb.util.SigBuilder;

/**
 * The shadow attribute is added to each method (or shadow method if one is created)
 * 
 * Contains:
 * Method name + signature
 * Lists of shadows: shadow id + start and end positions
 *
 */

public class ShadowAttribute extends AjAttribute
{
	public static final String NAME = "adb.tagkit.ASHADOW";
	private List <JoinPointDescriptor> jpds = new LinkedList<JoinPointDescriptor>();
	
	public static String getFullMethodSection(LazyMethodGen method) {
		StringBuffer buf = new StringBuffer();
		buf.append(method.getClassName());
		buf.append(" ");
		buf.append(method.getName());
		buf.append(" ");
		buf.append(SigBuilder.makeMethodSig2(method));
		return buf.toString();
	}
	
	public static void getShadowSection(DataOutputStream buf, JoinPointDescriptor jp) throws IOException 
	{
		buf.writeShort(jp.shadowUid);
			
		buf.writeShort(jp.shadowFirst);
		buf.writeShort(jp.shadowLast);
		
	}
	
	@Override
	protected void write(DataOutputStream buf) throws IOException 
	{
		buf.writeShort(0);
		
		LazyMethodGen meth = ((JoinPointDescriptor)jpds.get(0)).rangeMethod;
		
		buf.writeUTF(getFullMethodSection(meth));
		
		buf.writeShort(jpds.size());

		for (JoinPointDescriptor element : jpds) 
		{
			getShadowSection(buf, element);
			if(!meth.equals(element.rangeMethod))
				throw new BCException("target for multiple methods:" + meth + element.rangeMethod);
		}		
	}

	public void add(JoinPointDescriptor joinPoint) {
		if(jpds.contains(joinPoint))
			throw new BCException("joinpoint added twice");
		jpds.add(joinPoint);
	}

	@Override
	public String getNameString() 
	{
		return NAME;
	}

}
