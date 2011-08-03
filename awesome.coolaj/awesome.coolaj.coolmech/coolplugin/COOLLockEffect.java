package coolplugin;

import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.AdviceKind;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.Range;

public class COOLLockEffect extends COOLCoordEffect {

	public COOLLockEffect(String aspectClassName, String aspectMethodName, Member target, 
			String fieldName, Member adviceMethod, ISourceLocation loc, ResolvedType aspectType)
	{
		super (aspectClassName, aspectMethodName, target, fieldName, adviceMethod, loc, aspectType);
	}
	
	public void transform(BcelShadow shadow) {
		//System.err.println("Weaving Lock advice!");
		shadow.getRange().insert(
	    		getAdviceInstructions(shadow),
		        Range.InsideBefore);
	}
	
	public AdviceKind getKind()
	{
		return AdviceKind.Before;
	}

}
