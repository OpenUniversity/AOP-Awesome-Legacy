package coolplugin;

import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.AdviceKind;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.bcel.BcelShadow;

public class COOLUnlockEffect extends COOLCoordEffect {
	public COOLUnlockEffect(String aspectClassName, String aspectMethodName, 
			Member target, String fieldName, Member adviceMethod, ISourceLocation loc,
			ResolvedType aspectType) 
	{
		super (aspectClassName, aspectMethodName, target, fieldName, adviceMethod, loc, aspectType);
	}
	
	public void transform(BcelShadow shadow) {
     // System.err.println("Weaving Unlock advice!");
      //weaveAfterThrowing(shadow, UnresolvedType.THROWABLE);
      weaveAfterReturning(shadow);
	}
	
	public AdviceKind getKind()
	{
		return AdviceKind.After;
	}
	
	public String getType()
	{
		return "COOLUnlockEffect";
	}
}
