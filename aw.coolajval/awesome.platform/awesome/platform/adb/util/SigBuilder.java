package awesome.platform.adb.util;

import org.aspectj.weaver.Member;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.bcel.LazyMethodGen;

public class SigBuilder 
{
	public static String makeMethodSig(Member msig) 
	{		
		StringBuffer sb = new StringBuffer();
		
		if(null == msig)
			return sb.toString();
		
		sb.append('(');
			
		UnresolvedType params[] = msig.getGenericParameterTypes();
		for(int i = 0; i<params.length ; i++)
		{
			sb.append(params[i].getSignature());					
		}
		
		sb.append(')');
		sb.append(msig.getReturnType().getSignature());
		return sb.toString();
	}
	
	public static String makeMethodSig2(LazyMethodGen msig) 
	{
		String mySig =  msig.getParameterSignature();
		mySig += msig.getGenericReturnTypeSignature();
		
		return mySig;
	}
}



