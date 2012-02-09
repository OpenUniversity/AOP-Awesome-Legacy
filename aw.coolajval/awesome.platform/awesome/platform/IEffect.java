package awesome.platform;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.*;
import org.aspectj.weaver.ast.Test;
import org.aspectj.weaver.bcel.BcelShadow;

public interface IEffect {

	public void transform(BcelShadow shadow);
	
	public void specializeOn(Shadow shadow);
	
	// for AspectAttribute
	public AdviceKind getKind();
	public Member getSignature();
	public String getPointcutString();
	public ISourceLocation getSourceLocation();
	public UnresolvedType getDeclaringType();
	
	public Test getPointCutTest();
	
	public UnresolvedType getDeclaringAspect();
	
	public String getType();
	
	
}
