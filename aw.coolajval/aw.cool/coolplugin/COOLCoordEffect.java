package coolplugin;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.AnnotationAJ;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.MemberImpl;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.Utility;


public abstract class COOLCoordEffect extends COOLEffect 
{
	protected String aspectClassName, adviceMethodName;
	protected Member targetMember;
	protected String fieldName;
	
	private Member adviceMethod;
	private ISourceLocation sourceLocation;
	private ResolvedType aspectType;
	
	
	private ArrayList<Integer> sourceLines;
	
	public int[] getSourceLines()
	{
		int []arr = new int[sourceLines.size()];
		
		
		for(int i=0; i<sourceLines.size(); i++)
		{
			arr[i] = sourceLines.get(i);
		}
		
		return arr;
	}
	
	public Member getSignature()
	{
		return adviceMethod;
	}
	
	public String getPointcutString()
	{
		return "methodexecution(" + targetMember.getName() + ")";		
	}
	
	public ISourceLocation getSourceLocation()
	{
		return sourceLocation;
	}
	
	public ResolvedType getDeclaringType() 
	{
		return aspectType;
	}
	
	public UnresolvedType getDeclaringAspect()
	{
		return aspectType;
	}
	
	// read the source line annotation
	void buildSourceLines()
	{
		sourceLines = new ArrayList<Integer>();
		
		AnnotationAJ ans[] = adviceMethod.getAnnotations();
		AnnotationAJ linesAnn = null;
		for(AnnotationAJ a : ans)
		{
			if(a.getTypeName().equals("awesome.platform.annotations.AwSourceLines"))
			{
				linesAnn = a;
				break;
			}
		}
		
		if(null == linesAnn)
			return;
		
		String lines = linesAnn.getStringFormOfValue("sourceLines");
	
		int start = 1;
		int i = 0;
		while (start != lines.length())
		{
			StringBuffer val = new StringBuffer();
			char c = lines.charAt(start);
			while (c!=',' && c!=']')
			{
				val.append(c);
				start++;
				c = lines.charAt(start);
			}
			
			sourceLines.add(Integer.parseInt(val.toString()));
			
			if(c==']')
				break;
			
			start++;
		}
	}
	
	public COOLCoordEffect(String aspectClassName, 
			               String adviceMethodName, 
			               Member targetMember, 
			               String fieldName,
			               Member adviceMethod,
			               ISourceLocation loc,
			               ResolvedType aspectType) 
	{	
		this.aspectClassName = aspectClassName;
		this.adviceMethodName = adviceMethodName;
		this.targetMember = targetMember;
		this.fieldName = (fieldName!=null) ? fieldName : "_coord";
		this.adviceMethod = adviceMethod;
		this.sourceLocation = loc;
		this.aspectType = aspectType;
		
		buildSourceLines();
	}
			
	protected InstructionList getAdviceInstructions(BcelShadow shadow) {
		//invokeCOOLAdvice(Object coordinated, String aspectClassName, String mName)
		InstructionFactory fact = shadow.getFactory();
		BcelWorld world = shadow.getWorld();
		InstructionList il = new InstructionList();
		//loading the coordinated object:
		/*
		shadow.getThisVar().appendLoadAndConvert(il, fact, world.resolve(ResolvedType.OBJECT));
		il.append(fact.createConstant(aspectClassName));
		il.append(fact.createConstant(adviceMethodName));
		il.append(Utility.createInvoke(fact, shadow.getWorld(), adviceMethod));
		*/
		
		
		//For testing purposes: assuming that an advised class 
		//has a field _coord that holds the coordinator's object
		UnresolvedType aspectType = UnresolvedType.forName(aspectClassName);
		UnresolvedType targetType = targetMember.getDeclaringType();
		//Member coordField = MemberImpl.field(targetType,Modifier.PRIVATE,"_coord", aspectType);
		Member coordField =  new MemberImpl(MemberImpl.FIELD, 
				targetType,  Modifier.PRIVATE, aspectType, "_coord", UnresolvedType.NONE);
		//System.err.println("Pushing the object in the "+coordField+" field");
		//pushing the _coord field object on the stack
		shadow.getThisVarField().appendLoad(il, fact);
		il.append(Utility.createGet(fact, coordField));
		//pushing this (argument of an advice method)
		//System.err.println("Pushing This Var: ");
		shadow.getThisVarField().appendLoad(il, fact);
		//shadow.getThisVar().appendLoadAndConvert(il, fact, world.resolve(targetType));
		Member adviceMethodMember = MemberImpl.method(aspectType, Modifier.PUBLIC, ResolvedType.VOID, 
				adviceMethodName, new UnresolvedType[] {targetType});
		//System.err.println("Invoking the advice method "+adviceMethodMember);
		//invoking the advice method: _coord.<adviceMethodName(this);
		il.append(Utility.createInvoke(fact, shadow.getWorld(), adviceMethodMember));
		return il;
	}

	public void specializeOn(Shadow shadow) {
		shadow.getThisVar();
	}
	

}
