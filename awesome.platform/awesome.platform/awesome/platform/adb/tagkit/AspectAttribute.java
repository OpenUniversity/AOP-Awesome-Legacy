package awesome.platform.adb.tagkit;

import java.util.Iterator;
import java.util.List;

import org.aspectj.ajdt.internal.compiler.lookup.EclipseSourceLocation;
import org.aspectj.apache.bcel.classfile.LineNumberTable;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.bcel.BcelMethod;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.patterns.PerClause;

import awesome.platform.IEffect;
import awesome.platform.IMechanism;
import awesome.platform.adb.util.DataFormatter;
import awesome.platform.adb.util.SigBuilder;

/**
 * 
 * The aspect attribute is attached to each aspect class
 * The attribute lists:
 * 1. The name of the source file
 * 2. The start and end of the class declaration in the source file
 * 3. The list of advice
 *    For each advice: it's type, signature, starting and end position 
 *    in the source file
 *
 */
public class AspectAttribute extends SourceLineContainingTag {

	private PerClause.Kind per;

	private List<awesome.platform.IEffect> advices;

	private String fileName;

	private String filePath;

	private int startLine, endLine = 0;
	
	private String mechName = null;
	
	public int getPer()
	{
		if (per == PerClause.SINGLETON)
			return 1;
		
		if (per == PerClause.PEROBJECT)
			return 2;
			
		return 0;
	}
	
	public String instanceFieldName = "";
	
	public AspectAttribute(BcelWorld world, IMechanism mech, LazyClassGen aspectClazz)
	{
		super(true);
		
		per = mech.getPerClause(aspectClazz);
		
		ISourceLocation l = aspectClazz.getType().getSourceLocation();
		startLine = l.getLine();
		
		EclipseSourceLocation esLocation = (EclipseSourceLocation) l;
		endLine = esLocation.getCompilationResult().lineSeparatorPositions.length;
		fileName = aspectClazz.getFileName();					
		filePath = aspectClazz.getName().replace(".", "\\");
		
		mechName = mech.getId();
		
		advices = mech.getEffects(aspectClazz);
	}
	
	protected String getValue()  
	{
		StringBuffer out = new StringBuffer();

		out.append(getPer());
		out.append(" ");
		out.append(getLinePart(fileName, filePath,startLine));
		out.append(" ");
		out.append(getLinePart(fileName, filePath,endLine));
		out.append(" ");
		
		out.append(mechName);
		
		out.append("\n");
		
		for (Iterator<IEffect> it = advices.iterator(); it.hasNext();) {
			IEffect adv = it.next();
			out.append(getAdviceFormatString(adv) + "\n");
		}
		
		return out.toString();
	}
	
	
	private String getLinesString(IEffect adv)
	{
		StringBuffer result = new StringBuffer();
				
		int []lines = adv.getSourceLines();
		
		for(int i = 0; i<lines.length; i++)
		{
			result.append(lines[i]);
			
			if(i<lines.length-1)
				result.append(",");
		}
		
		
		
		return result.toString();
	}

	public String getAdviceFormatString(IEffect adv) 
	{
		int type = DataFormatter.getAdviceType(adv);
			
		String sig;
		sig = SigBuilder.makeMethodSig(adv.getSignature());
		
		String name = adv.getSignature().getName();
		
		ISourceLocation pos = adv.getSourceLocation();
		String fileName = pos.getSourceFileName();
		filePath = adv.getDeclaringType().getName().replace(".", "\\");
			
		BcelMethod method = (BcelMethod) adv.getSignature();
		
		LineNumberTable lnTable = method.getMethod().getLineNumberTable();
		int length = lnTable.getLineNumberTable().length;
		
		int slnr = lnTable.getLineNumberTable()[0].getLineNumber();
		int elnr = lnTable.getLineNumberTable()[length-1].getLineNumber();
					
		int nargs = adv.getSignature().getParameterTypes().length;
		UnresolvedType[] formals = adv.getSignature().getParameterTypes();
		
		String pcString = adv.getPointcutString().replace(" ", "");
		
		StringBuffer out = new StringBuffer(type + " " + 
				getLinePart(fileName,filePath,slnr) +" " + 
				getLinePart(fileName,filePath,elnr) + " "+ name + " " + sig +" " + 
				pcString + " " + adv.getType());
		
		out.append(" ");
		out.append(getLinesString(adv));
		
		for(int i = 0;i<nargs;i++){
			out.append(" ");
			out.append(formals[i].getName());
			out.append(" ");
			out.append(i);
		}
		
		
		
		return out.toString();
	}

	
	@Override
	public String getNameString() {
		return "Aspect";
	}

}
