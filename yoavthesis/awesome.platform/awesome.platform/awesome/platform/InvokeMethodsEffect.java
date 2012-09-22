package awesome.platform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.AdviceKind;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.ast.Test;
import org.aspectj.weaver.bcel.BcelObjectType;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Utility;

import awesome.platform.MethodParameter.Type;

public class InvokeMethodsEffect extends AwesomeEffect {
	private List<LazyMethodGen> methods = new ArrayList<LazyMethodGen>();
	private List<List<MethodParameter>> allParameters = new ArrayList<List<MethodParameter>>();
	private AdviceType type;
	private AspectClass ac;
	private BcelWorld world;
	
	/**
	 * @param ac the Aspect Class whose method we like to invoke.
	 */
	public InvokeMethodsEffect(BcelWorld world, AspectClass ac) {
		this.world = world;
		this.ac = ac;
		this.type = AdviceType.Before;
	}
	/**
	 * If not explicitly set, then advice type is <i>Before</i>.
	 */
	public void setAdviceType(AdviceType type) {
		this.type = type;
	}
/*	public InvokeMethodsEffect(AwesomeEffect.AdviceType kind, LazyMethodGen method, MethodParameter[] parameters) {
		this.type = kind;
		this.methods.add(method);
		this.allParameters.add(Arrays.asList(parameters));
	}*/
	public void addMethodInvocation(String methodName, MethodParameter[] parameters) {
		LazyClassGen clazz = getLazyClassGen(ac.getClassFile().getClassName());
		this.methods.add(getLazyMethodGen(clazz, methodName));
		
		if (parameters == null)
			this.allParameters.add(new ArrayList<MethodParameter>());
		else
			this.allParameters.add(Arrays.asList(parameters));
	}
	
	@Override
	public void transform(BcelShadow shadow) {
		if (type == AdviceType.Before)
			weaveBefore(shadow);
		if (type == AdviceType.After)
			weaveAfterReturning(shadow);
	}

	@Override
	public void specializeOn(Shadow shadow) {
	}

	@Override
	protected InstructionList getAdviceInstructions(BcelShadow shadow) {
		InstructionList il = new InstructionList();
		InstructionFactory fact = shadow.getFactory();
		
		for (int i=0; i < methods.size(); i++) {
			LazyMethodGen method = methods.get(i);
			// adding parameters to stack according to their type
			List<MethodParameter> parameters = allParameters.get(i);
			for (MethodParameter param : parameters) {
				if (param.getType() == Type.EnclosingClassName) {
					il.append(fact.createConstant(shadow.getEnclosingMethod().getClassName()));				
				}
				if (param.getType() == Type.EnclosingMethodName) {
					il.append(fact.createConstant(shadow.getEnclosingMethod().getName()));				
				}
				if (param.getType() == Type.Primitive) {
					il.append(fact.createConstant(param.getValue()));				
				}
				if (param.getType() == Type.ALOAD0) {
					il.append(InstructionFactory.createALOAD(0));				
				}
				if (param.getType() == Type.ALOAD1) {
					il.append(InstructionFactory.createALOAD(1));				
				}
				
			}
			il.append(Utility.createInvoke(shadow.getFactory(), method));
		}
		
		return il;
	}
	
	private LazyMethodGen getLazyMethodGen(LazyClassGen clazz, String methodName) {
		List<LazyMethodGen> methods = clazz.getMethodGens();
		for(LazyMethodGen m : methods){
			if(m.getName().equals(methodName))
				return m;
		}
		return null;
	}
	private LazyClassGen getLazyClassGen(String className) {
		BcelObjectType bcelType = BcelWorld.getBcelObjectType(world.resolve(className));
		return bcelType.getLazyClassGen();
	}
	
	@Override
	public AdviceKind getKind() {
		switch(type)
		{
		case Before:
			return AdviceKind.Before;
		case After:
			return AdviceKind.After;
		default:
			return AdviceKind.After; //TBD				
		}
	}
	
	@Override
	public Member getSignature() {

		return methods.get(0).getMemberView(); 
		// TBD - each effect should apply a single method
	}
	
	@Override
	public String getPointcutString() 
	{
		return "methodexecution";
	}
	@Override
	public ISourceLocation getSourceLocation() {
		return methods.get(0).getSourceLocation();
	}
	@Override
	public UnresolvedType getDeclaringType() {
		
		return getLazyClassGen(ac.getClassFile().getClassName()).getType();
	}
	@Override
	public Test getPointCutTest() {
		return null;
	}
	@Override
	public UnresolvedType getDeclaringAspect() {
		return getLazyClassGen(ac.getClassFile().getClassName()).getType();
	}
	
	@Override
	public String getType() {		
		return "MethodInvocation";
	}
	
	@Override
	public int[] getSourceLines() {
		int[] lines = new int[1];
		lines[0]=0;
		
		return lines;
	}

}
