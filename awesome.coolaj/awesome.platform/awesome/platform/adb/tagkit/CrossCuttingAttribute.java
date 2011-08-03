package awesome.platform.adb.tagkit;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.apache.bcel.classfile.LineNumberTable;
import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.ast.Test;
import org.aspectj.weaver.bcel.BcelAdvice;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyMethodGen;

import awesome.platform.adb.util.SigBuilder;

import awesome.platform.IEffect;

public class CrossCuttingAttribute extends AjAttribute
{	
	private List<JoinPointDescriptor> jpds  = new LinkedList<JoinPointDescriptor>();
	
	public CrossCuttingAttribute(List<EffectApplication> effectList)
	{
		awesome.platform.adb.util.log.logger.logLn("number of effects =  " + 
				effectList.size());
		
		for (EffectApplication effect : effectList) 
		{
			makeAapl(effect);
		}
	}
	
	public List<JoinPointDescriptor> getJoinpoints(){
		return jpds;
	}

	private JoinPointDescriptor getJPD(int type, 
			                           int slnr, int elnr, BcelShadow shadow) 
	{
		for (JoinPointDescriptor jpd : jpds) 
		{			
			if (jpd.type == type && jpd.beginLineNumber == slnr && jpd.endLineNumber == elnr)
				return jpd;
		}
		
		if(shadow.getKind() == BcelShadow.FieldGet || shadow.getKind() == BcelShadow.FieldSet)
		{
			int x = 1;
		}
		
		int startPosShadow = shadow.getRange().getStart().getPosition();
		int endPosShadow  = shadow.getRange().getEnd().getPosition();
		
		LazyMethodGen rangeMethod = shadow.getEnclosingMethod();

		int startRange = startPosShadow;
		int endRange = endPosShadow;
				
		LazyMethodGen shadowMethod = shadow.getComputationMethod();
		if(null != shadowMethod)
		{
			shadowMethod.getBody().setPositions();
			startPosShadow = shadowMethod.getBody().getStart().getPosition();
			endPosShadow  = shadowMethod.getBody().getEnd().getPosition();			
		}
		else
		{
			shadowMethod = rangeMethod;
		}
		
		JoinPointDescriptor jpd = new JoinPointDescriptor(shadow.getID(),
				type, slnr, elnr, 			
				startPosShadow, endPosShadow, shadowMethod,
				startRange, endRange, shadow.getEnclosingMethod());
		
		jpds.add(jpd);
		
		return jpd;
	}
	
	int byteCodePosToLnNo(Method m, int pos)
	{
		LineNumberTable lineNoTable = 	m.getLineNumberTable();
		
		int lineNoTableLength = lineNoTable.getLineNumberTable().length;
				
		int posLineNo = -1;
		
		for(int i = 0; i <lineNoTableLength; i++)
		{
			int lineNo = lineNoTable.getLineNumberTable()[i].getLineNumber();			
			int startPC = lineNoTable.getLineNumberTable()[i].getStartPC();
			
			if(pos >= startPC )
			{
				posLineNo = lineNo;		
				break;
			}			
		}
		
		return posLineNo;		
	}
	
	private void makeAapl(EffectApplication effect) 
	{
		BcelShadow shadow =  effect.getShadow();
		// need to use the line number table?
		//int startPos = shadow.getRange().getStart().getPosition();
		
		shadow.getRange().getBody().setPositions();
		
		int endPos  = shadow.getRange().getRealEnd().getPosition();
		
		int endLineNo, startLineNo;
		
		if(shadow.getEnclosingMethod().getName()=="<clinit>")
		{
			startLineNo = shadow.getEnclosingClass().getType().getSourceLocation().getLine();
			endLineNo = shadow.getEnclosingClass().getType().getSourceLocation().getEndLine();
			
			
		}
		else
		{
			Method m = shadow.getEnclosingMethod().getMemberView().getMethod();
			
			endLineNo = byteCodePosToLnNo(m, endPos);			
			startLineNo = shadow.getSourceLine();
		}
			
		
		int type;
		
		if(effect.getShadow().getKind() == Shadow.MethodExecution)
		{
			type = JoinPointDescriptor.TYPE_METHOD_EXECUTION;
		}
		else if(effect.getShadow().getKind() == Shadow.ConstructorExecution)
		{
			type = JoinPointDescriptor.TYPE_INIT;
		}
		else if(effect.getShadow().getKind() == Shadow.PreInitialization)
		{
			type = JoinPointDescriptor.TYPE_PINIT;
		}
		else if(effect.getShadow().getKind() == Shadow.StaticInitialization)
		{
			type = JoinPointDescriptor.TYPE_SINIT;
		}
		else
		{
			type = JoinPointDescriptor.TYPE_STATEMENT;
		}
		
		makeApplication(effect.getShadow(), type, startLineNo, endLineNo,  
				effect.getEffect());		
	}
	
	private void makeApplication(BcelShadow shadow, int type, int slnr, int elnr,
			IEffect application) 
	{
		awesome.platform.adb.util.log.logger.logLn("Making application for " + 
				application);
		
		
		
		JoinPointDescriptor jpd = getJPD(type, slnr, elnr, shadow);

		jpd.addAdvice(new AdviceApplicationDescriptor(application));
	}

	public static String getMethodSection(LazyMethodGen method) 
	{
		StringBuffer buf = new StringBuffer();
		buf.append(method.getName());
		buf.append(" ");
		buf.append(SigBuilder.makeMethodSig2(method));
		return buf.toString();
	}
	
	public static final String NAME = "CrossCutting";
	
	private static String getAdviceSectionString(IEffect advice) 
	{
		String signature = (advice.getSignature() != null) ? advice.getSignature().getName() : "";
		
		return advice.getDeclaringAspect().getName() + " " + signature
				+ " "
				+ SigBuilder.makeMethodSig(advice.getSignature());
	}
	
	private static void getAdviceApplicationSection(DataOutputStream buf,
			IEffect effect) throws IOException 
	{
		buf.writeUTF(getAdviceSectionString(effect));
		
		TestPrinter testPrint = new TestPrinter();
		Test t = effect.getPointCutTest();
		
		if(null != t)
			t.accept(testPrint);
		
		buf.writeUTF(testPrint.getPrinted().replaceAll(" ", ""));
	}
	
	public void getJoinPointSection(DataOutputStream buf, JoinPointDescriptor jp) throws IOException 
	{
		buf.writeShort(jp.shadowUid);
		buf.writeShort(jp.type);
		buf.writeShort(jp.beginLineNumber);
		buf.writeShort(jp.endLineNumber);
		//if (jp.rangeFirst == null)
		//	throw new BCException("Joinpoint has no range start: " + jp);

		//if (jp.rangeLast == null)
		//	throw new BCException("Joinpoint has no range end: " + jp);

		buf.writeShort(jp.rangeFirst);
		buf.writeShort(jp.rangeLast);
				
		buf.writeUTF(getMethodSection(jp.rangeMethod));
		
		buf.writeShort(jp.getEffects().size());

		for (IEffect e  : jp.getEffects()) 
		{		
			getAdviceApplicationSection(buf, e);
		}
	}

	@Override
	protected void write(DataOutputStream s) throws IOException 
	{
	
		s.writeShort(0);
		s.writeShort(jpds.size());
		for(JoinPointDescriptor j : jpds)
		{
			getJoinPointSection(s, j);
		}		
	}

	@Override
	public String getNameString() 
	{
		return NAME;
	}

}
