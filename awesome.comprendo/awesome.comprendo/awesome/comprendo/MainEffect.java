package awesome.comprendo;

import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Utility;

import awesome.platform.AwesomeEffect;

public class MainEffect extends AwesomeEffect {

	private LazyMethodGen printPrivateMethod, printPublicMethod;
	private boolean printPrivateSummary, printPublicSummary;

	public MainEffect(LazyMethodGen printPrivateMethod, boolean printPrivateSummary, LazyMethodGen printPublicMethod, boolean printPublicSummary) {
		this.printPrivateMethod = printPrivateMethod;
		this.printPublicMethod = printPublicMethod;
		this.printPrivateSummary = printPrivateSummary;
		this.printPublicSummary = printPublicSummary;
	}
	
	@Override
	public void transform(BcelShadow shadow) {
		weaveAfterReturning(shadow);
	}

	@Override
	public void specializeOn(Shadow shadow) {
	}

	@Override
	protected InstructionList getAdviceInstructions(BcelShadow shadow) {
		InstructionList il = new InstructionList();
		InstructionFactory factory = shadow.getFactory();
		
		if (printPrivateMethod != null) {
			il.append(factory.createConstant(printPrivateSummary));
			il.append(Utility.createInvoke(factory, printPrivateMethod));
		}
		
		if (printPublicMethod != null) {
			il.append(factory.createConstant(printPublicSummary));
			il.append(Utility.createInvoke(factory, printPublicMethod));
		}
		
		return il;
	}

}
