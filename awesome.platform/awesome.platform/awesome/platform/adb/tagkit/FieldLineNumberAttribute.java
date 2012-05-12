package awesome.platform.adb.tagkit;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.LazyClassGen;

/**
 * This attribute is attached to each class
 * For each field its location in the source file is listed
 *
 */
public class FieldLineNumberAttribute extends SourceLineContainingTag 
{
	public static final String name = "FieldLineNumber";
	
	private LazyClassGen clazz;
	private BcelWorld world;

	public FieldLineNumberAttribute(BcelWorld world, LazyClassGen clazz)
	{
		super(true);
		this.clazz = clazz;	
		this.world = world;
	}
	
	public static String getFieldPart(SourceLineContainingTag t, String path,
			String file, String name, int lnr) 
	{
		StringBuffer buf = new StringBuffer();
		buf.append(name);
		buf.append(" ");
		buf.append(t.getLinePart(file, path, lnr));
		return buf.toString();
	}
	
	
	protected String getValue() 
	{
		String file = clazz.getFileName();
		String path = clazz.getPackageName();
		path.replace('.', '\\');
		
		StringBuffer buf = new StringBuffer();
		
		for (Iterator<Member> iter = clazz.getType().getFields(); iter.hasNext();) 
		{
			Member field = (Member) iter.next();
			String fieldName = field.getName();
			
			int lineNo = field.resolve(world).getStart();
			
			buf.append(getFieldPart(this,
					file, path, fieldName, lineNo)+"\n");			
		}
		
		return buf.toString();
		
	}

	@Override
	public String getNameString() 
	{
		return name;
	}

}
