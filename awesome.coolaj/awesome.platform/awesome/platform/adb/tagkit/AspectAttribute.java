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

public class AspectAttribute extends SourceLineContainingTag {

	private PerClause.Kind per;

	//private List<BcelAdvice> advices = new ArrayList<BcelAdvice>();
	private List<awesome.platform.IEffect> advices;

	private String fileName;

	private String filePath;

	private int startLine, endLine = 0;
	
	private BcelWorld world;
	
	public int getPer()
	{
		if (per == PerClause.SINGLETON)
			return 1;
		
		if (per == PerClause.PERCFLOW)
			return 2;
		
		if (per == PerClause.PEROBJECT)
			return 3;
		
		if (per == PerClause.FROMSUPER)
			return 4;
		
		if (per == PerClause.PERTYPEWITHIN)
			return 5;
		
		return 0;
	}
	
	private IMechanism mech;
	
	public AspectAttribute(BcelWorld world, IMechanism mech, LazyClassGen aspectClazz)
	{
		super(true);
		
		this.world = world;
		
		//per = aspectClazz.getType().getPerClause();
		per = mech.getPerClause(aspectClazz);
		
		ISourceLocation l = aspectClazz.getType().getSourceLocation();
		startLine = l.getLine();
		
		EclipseSourceLocation esLocation = (EclipseSourceLocation) l;
		endLine = esLocation.getCompilationResult().lineSeparatorPositions.length;
		fileName = aspectClazz.getFileName();					
		filePath = aspectClazz.getName().replace(".", "\\");
		
		advices = mech.getEffects(aspectClazz);
		
		/*
		List<ShadowMunger> shadowMungers = 
			aspectClazz.getWorld().getCrosscuttingMembersSet().getShadowMungers();
		
		for(ShadowMunger m : shadowMungers)
		{
			if((m instanceof BcelAdvice) && 
					(m.getDeclaringType() == aspectClazz.getType()))
			{
				advices.add((BcelAdvice) m);				
			}
		}		
		*/
	}
	
	protected String getValue()  
	{
		StringBuffer out = new StringBuffer();

		out.append(getPer());
		out.append(" ");
		out.append(getLinePart(fileName, filePath,startLine));
		out.append(" ");
		out.append(getLinePart(fileName, filePath,endLine));
		out.append("\n");
		for (Iterator<IEffect> it = advices.iterator(); it.hasNext();) {
			IEffect adv = it.next();
			out.append(getAdviceFormatString(adv) + "\n");
		}
		
		return out.toString();
	}
	
	
	public String getAdviceFormatString(IEffect adv) 
	{
		int type = DataFormatter.getAdviceType(adv);
			
		String sig;
		sig = SigBuilder.makeMethodSig(adv.getSignature());
		
		String name = adv.getSignature().getName();
		//String pc = adv.getPointcut().toString();
		ISourceLocation pos = adv.getSourceLocation();
		String fileName = pos.getSourceFileName();
		filePath = adv.getDeclaringType().getName().replace(".", "\\");
		
		
		
		//EclipseSourceLocation esLocation = (EclipseSourceLocation) pos;
		//int elnr = esLocation.getCompilationResult().lineSeparatorPositions.length;
		//int elnr = pos.getEndLine();
		
		BcelMethod method = (BcelMethod) adv.getSignature();
		
		LineNumberTable lnTable = method.getMethod().getLineNumberTable();
		int length = lnTable.getLineNumberTable().length;
		//int slnr = pos.getLine();
		int slnr = lnTable.getLineNumberTable()[0].getLineNumber();
		int elnr = lnTable.getLineNumberTable()[length-1].getLineNumber();
		
		
					
		int nargs = adv.getSignature().getParameterTypes().length;
		UnresolvedType[] formals = adv.getSignature().getParameterTypes();
//		List/*<Formal>*/ formals = msig.getFormals();
		
		String pcString = adv.getPointcutString().replace(" ", "");
		StringBuffer out = new StringBuffer(type + " " + 
				getLinePart(fileName,filePath,slnr) +" " + 
				getLinePart(fileName,filePath,elnr) + " "+ name + " " + sig +" " + 
				pcString);
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
