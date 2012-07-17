package awesome.platform.adb.tagkit;

import org.aspectj.apache.bcel.classfile.Attribute;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.Utility;

import awesome.platform.MultiMechanism;

public aspect AddFieldLineNumberAttribute extends AddAttribute {
	before(LazyClassGen clazz) : 
		call(* MultiMechanism.addFieldLineNumberAttribute(LazyClassGen))
			&& args(clazz) {
		generateFieldLineNumberAttribute(clazz);
	}
	/**
	 * generates the FieldNumber Attribute
	 * @param clazz
	 */
	private void generateFieldLineNumberAttribute(LazyClassGen clazz) {		
		if(clazz.isAbstract())
			return;
		
		Attribute fieldLineNoAttribute = Utility.bcelAttribute(new FieldLineNumberAttribute(MultiMechanism.getInstance().getWorld(), clazz), 
				clazz.getConstantPool());
						
		clazz.addAttribute(fieldLineNoAttribute);
	}
}
