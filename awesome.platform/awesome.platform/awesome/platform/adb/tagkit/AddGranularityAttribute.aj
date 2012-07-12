package awesome.platform.adb.tagkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.classfile.Attribute;
import org.aspectj.apache.bcel.classfile.Code;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Utility;

import awesome.config.spec.FeatureInteractions;
import awesome.platform.MultiMechanism;

public aspect AddGranularityAttribute extends AddAttribute {
	private Map<String, List<BcelShadow>> allShadows;
	
	// maintaining allShadows
	before(LazyClassGen clazz) : transformClass(clazz) {
		allShadows =  new HashMap<String, List<BcelShadow>>();
	}
	before(BcelShadow shadow) : transformShadow(shadow) {
		// check if the shadow is in the emergent granularity
		if(FeatureInteractions.instance().isInEMJPG(shadow.getKind().getName()))
    	{
			List<BcelShadow> shadowList = allShadows.get(shadow.getEnclosingMethod().getName());
			if(null == shadowList)
			{
				shadowList = new ArrayList<BcelShadow>();
				allShadows.put(shadow.getEnclosingMethod().getName(), shadowList);
			}
			
			shadowList.add(shadow);
    	}
	}
	before(LazyClassGen clazz) : 
		execution(* MultiMechanism.addGranularityAttribute(LazyClassGen))
			&& args(clazz) {
		genereteGranularityAttribute(clazz);
	}
	
	/**
	 * generate the "all joinpoints" attribute
	 * @param clazz
	 */
	private void genereteGranularityAttribute(LazyClassGen clazz)
	{
		awesome.platform.adb.util.Logger.logLn("generating AllJPsTag for " + 
				clazz.getName());
		
		List<LazyMethodGen> methods = clazz.getMethodGens();
		
		for(LazyMethodGen m : methods)
		{
			if(m.isAbstract() )
				continue;
			
			List<BcelShadow> shadowList = allShadows.get(m.getName());
			if(null == shadowList)
				continue;
			
			JoinPointGranularityAttribute ajpa = new JoinPointGranularityAttribute(MultiMechanism.getInstance(), shadowList);
			
			Attribute ccAttribute;
			ccAttribute = Utility.bcelAttribute(ajpa, 
							clazz.getConstantPool());
					
			Attribute[] ats = m.getMethod().getAttributes();
			for(Attribute a : ats)
			{
				if(a instanceof Code)
				{
					Code c = (Code) a;
					Attribute[] attrs = c.getAttributes();
					Attribute[] extAttrs = new Attribute[attrs.length+1];
					System.arraycopy(attrs, 0, extAttrs, 0, attrs.length);
					extAttrs[attrs.length] = ccAttribute;	
					c.setAttributes(extAttrs);
				}				
			}
		}
		
	}
	
}
