package awesome.comprendo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Utility;

import awesome.comprendo.MethodParameter.Type;
import awesome.platform.AwesomeEffect;
import awesome.platform.AwesomeEffect.Kind;

public class InvokeMethodsEffect extends AwesomeEffect {
	private List<LazyMethodGen> methods = new ArrayList<LazyMethodGen>();
	private List<List<MethodParameter>> allParameters = new ArrayList<List<MethodParameter>>();
	private Kind kind;
	
	
	public InvokeMethodsEffect(AwesomeEffect.Kind kind) {
		this.kind = kind;
	}
	public InvokeMethodsEffect(AwesomeEffect.Kind kind, LazyMethodGen method, MethodParameter[] parameters) {
		this.kind = kind;
		this.methods.add(method);
		this.allParameters.add(Arrays.asList(parameters));
	}
	public void addMethodInvocation(LazyMethodGen method, MethodParameter[] parameters) {
		this.methods.add(method);
		
		if (parameters == null)
			this.allParameters.add(new ArrayList<MethodParameter>());
		else
			this.allParameters.add(Arrays.asList(parameters));
	}
	
	@Override
	public void transform(BcelShadow shadow) {
		if (kind == Kind.Before)
			weaveBefore(shadow);
		if (kind == Kind.After)
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
				
			}
			il.append(Utility.createInvoke(shadow.getFactory(), method));
		}
		
		return il;
	}

}
