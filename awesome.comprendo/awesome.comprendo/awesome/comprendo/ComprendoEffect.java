package awesome.comprendo;

import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Range;
import org.aspectj.weaver.bcel.Utility;

import awesome.platform.IEffect;

public class ComprendoEffect implements IEffect {
	// this is the aspect type which contains the method which we want
	// to invoke in the advice.
	private LazyClassGen aspect;
	private LazyMethodGen method;
	
	public ComprendoEffect(LazyClassGen aspect, LazyMethodGen method) {
		this.aspect = aspect;
		this.method = method;
	}

	@Override
	public void transform(BcelShadow shadow) {
		//shadow.getRange().insert(getAdviceInstructions(shadow), Range.InsideBefore);
		shadow.getRange().insert(getAdviceInstructions(shadow), Range.InsideBefore);
	}

	
	private InstructionList getAdviceInstructions(BcelShadow shadow) {
		InstructionList il = new InstructionList();
		InstructionFactory fact = shadow.getFactory();
		
		il.append(fact.createConstant(shadow.getEnclosingMethod().getClassName()));
		il.append(fact.createConstant(shadow.getEnclosingMethod().getName()));
		
		il.append(Utility.createInvoke(shadow.getFactory(), method));

		return il;
	}

	@Override
	public void specializeOn(Shadow shadow) {
	}

}
