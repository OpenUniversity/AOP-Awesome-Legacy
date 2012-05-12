package awesome.platform.adb.tagkit;

import java.util.LinkedList;
import java.util.List;

import org.aspectj.apache.bcel.generic.InstructionHandle;
import org.aspectj.weaver.bcel.BcelMethod;
import org.aspectj.weaver.bcel.LazyMethodGen;

import awesome.platform.IEffect;

public class JoinPointDescriptor 
{
	public static final int TYPE_METHOD_EXECUTION = 0x001;
	public static final int TYPE_STATEMENT = 0x002;
	public static final int TYPE_SINIT = 0x004;
	public static final int TYPE_INIT = 0x008;
	public static final int TYPE_PINIT = 0x0010;

	
	private List<IEffect> effects = new LinkedList<IEffect>();
	
	public int beginLineNumber, endLineNumber;
	
	
	public LazyMethodGen rangeMethod;
	public int rangeFirst;
	public int rangeLast;
	
	
	public int type;
	
	
	public int shadowUid;
	public LazyMethodGen shadowMethod;
	public int shadowFirst;
	public int shadowLast;
	
	
	public JoinPointDescriptor(int shadowUid, 
			                   int type, 
			                   int slnr, 
			                   int elnr,
			                   int shadowFirst,
							   int shadowLast,
							   LazyMethodGen shadowMethod,
			                   int rangeFirst,
							   int rangeLast,
							   LazyMethodGen rangeMethod)							  
	{
		this.shadowUid = shadowUid;
		this.type = type;
		this.beginLineNumber = slnr;
		this.endLineNumber = elnr;
		
		this.rangeFirst = rangeFirst;
		this.rangeLast = rangeLast;
		this.rangeMethod = rangeMethod;
		
		this.shadowFirst = shadowFirst;
		this.shadowLast = shadowLast;
		this.shadowMethod = shadowMethod;
	}

	/*
	public void addAdvice(AdviceApplicationDescriptor adviceApplicationDescriptor) 
	{
		advice.add(adviceApplicationDescriptor);
		adviceApplicationDescriptor.setJoinpoint(this);
	}
*/
	public List<IEffect> getEffects() 
	{
		return effects;
	}

	public void addAdvice(AdviceApplicationDescriptor adviceApplicationDescriptor) 
	{
		effects.add(adviceApplicationDescriptor.getEffect());
		adviceApplicationDescriptor.setJoinpoint(this);
		
		
	}

}
