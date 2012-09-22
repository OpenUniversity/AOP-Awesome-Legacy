package awesome.platform.adb.util;


import org.aspectj.weaver.AdviceKind;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.bcel.BcelAdvice;

import awesome.platform.IEffect;

public class DataFormatter 
{
	public static final int TYPE_AFTER = 1;
	public static final int TYPE_AROUND = 2;
	public static final int TYPE_BEFORE = 4;

	public static int getAdviceType(IEffect adv) {
		
		if (adv.getKind() == AdviceKind.After)
			return TYPE_AFTER;
		if (adv.getKind() == AdviceKind.Around)
			return TYPE_AROUND;
		if (adv.getKind() == AdviceKind.Before)
			return TYPE_BEFORE;
		throw new RuntimeException("unknown type");
	}
	
	
	public static String getPath(UnresolvedType type, String fileName) {
		StringBuilder out = new StringBuilder(fileName);
		out.indexOf(type.getPackageName());
		
		return out.toString();
	}



}
