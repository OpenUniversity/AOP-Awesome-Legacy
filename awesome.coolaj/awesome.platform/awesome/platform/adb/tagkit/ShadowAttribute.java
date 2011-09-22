package awesome.platform.adb.tagkit;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.BCException;
import org.aspectj.weaver.bcel.LazyMethodGen;

import awesome.platform.adb.util.SigBuilder;

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
		
		/*
		if (jp.shadowFirst == null)
			throw new InternalCompilerError("Shadow has no range start: " + jp);

		if (jp.shadowLast == null)
			throw new InternalCompilerError("Shadow has no range end: " + jp);
		*/
		
		buf.writeShort(jp.shadowFirst);
		buf.writeShort(jp.shadowLast);
		
	}
	
	@Override
	protected void write(DataOutputStream buf) throws IOException 
	{
		//LabelString buf = new LabelString();

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

		//String s = buf.toString();
		//System.out.println(getName() + " jasmin value end");
		
	}
	/*
	protected List getUsedUnits() {
		List out = new ArrayList(jpds.size()*2);
		for (Iterator iterator = jpds.iterator(); iterator.hasNext();) {
			JoinPointDescriptor jp = (JoinPointDescriptor) iterator.next();
			out.add(jp.shadowFirst);
			out.add(jp.shadowLast);
		}
		return out;
	}
	*/
	
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
