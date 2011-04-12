package awesome.comprendo;

import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Utility;
import awesome.platform.AwesomeEffect;

public class ComprendoEffect extends AwesomeEffect {
	// this is the the method which we want to invoke in the advice.
	private LazyMethodGen method;
	
	public ComprendoEffect(LazyMethodGen method) {
		this.method = method;
	}

	@Override
	public void transform(BcelShadow shadow) {
		weaveBefore(shadow);
	}

	
	public InstructionList getAdviceInstructions(BcelShadow shadow) {
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
