package awesome.platform.adb.tagkit;

import awesome.platform.IMechanism;
import awesome.platform.MultiMechanism;

import org.aspectj.apache.bcel.classfile.Attribute;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.Utility;

/**
 * This aspect add the debug attribute AspectAttribute to a class file
 * during the Awesome weaving process.
 * @author oren
 *
 */
public aspect AddAspectAttribute extends AddAttribute {
	
	before(LazyClassGen clazz): 
		call(* MultiMechanism.addAspectAttribute(LazyClassGen))
			&& args(clazz) {
		generateAspectAttribute(clazz);
	}
	
	/**
	 * generates the Aspect Attribute
	 * @param clazz The class to generate the attribute for 
	 */
	private void generateAspectAttribute(LazyClassGen clazz) {		
		
		if(clazz.getType().isAspect()) {
			IMechanism m = getHandlingMechanism(clazz);
						
			Attribute aspectAttribute = Utility.bcelAttribute(new AspectAttribute(MultiMechanism.getInstance().getWorld(), m, clazz), 
					clazz.getConstantPool());
							
			clazz.addAttribute(aspectAttribute);
		}		
	}
	
	/**
	 * We know that clazz is an aspect. We extract its declaring mechanism
	 * based on the @AwAspectMechanism annotation. If such an annotation does
	 * not exist then the handling mechanism is AspectJ.
	 * @param clazz
	 * @return
	 */
	private IMechanism getHandlingMechanism(LazyClassGen clazz) {
		IMechanism m =  null;
		for(IMechanism m2 : MultiMechanism.getInstance().getMechanisms())
		{
			if(m2.getClass().getName().compareTo("AJWeaver")==0)
			{
				continue;
			}
			
			if(m2.handledByMe(clazz))
			{				
				m = m2;
				break;
			}
		}
		
		if(m == null)
		{
			for(IMechanism m2 : MultiMechanism.getInstance().getMechanisms())
			{
				if(m2.getClass().getName().compareTo("AJWeaver")==0);
				{
					m = m2;
					break;
				}
			}
			
		}
			
		return m;		
	}
}
