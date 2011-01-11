package ajcool;
import platform.IEffect;
import platform.MultiMechanism;
import java.util.*;
import org.aspectj.weaver.bcel.*;
import org.aspectj.weaver.Advice;
import org.aspectj.weaver.AdviceKind;

import coolplugin.*;
import ajplugin.AJWeaver;

public aspect AdviceFilter {

	   void around(MultiMechanism mm, List effects, BcelShadow shadow): 
		   execution(void MultiMechanism.mix(List, BcelShadow)) 
		   && this(mm) && args(effects, shadow) {
		   //System.out.println("Running advice filter on "+shadow);
		   if (effects!=null && effects.size()>0) {
		     COOLWeaver coolWeaver = (COOLWeaver)mm.getMechanism(COOLWeaver.class);
		     if (coolWeaver.isConditionField(shadow.getSignature())
		    		 || (shadow.getKind()==BcelShadow.AdviceExecution 
				    		 && coolWeaver.isCOOLAspect(shadow.getEnclosingType()))) {
		    	 //System.out.println(shadow.toString()+" is an access to a condition field ");
		    	 int bfSize = effects.size();
		    	 filterAdvice(effects);
		    	 int afSize = effects.size();
				   if (bfSize>afSize) {
					   int rmvd = bfSize-afSize;
					   System.out.println("Around advice does not apply at "+shadow);
				   }
		     } 
		   }
		   proceed(mm, effects, shadow);
	   }
	   
	   private void filterAdvice(List<IEffect> effects) {
		   List<IEffect> filteredAdv = new ArrayList<IEffect>();
		   for(IEffect eff:effects)
			   if (eff!=null && (eff instanceof Advice)) {
				   Advice adv = (Advice)eff;
				   if (adv.getKind()== AdviceKind.Around)  {
					   //System.out.println(" removing an around advice ");
					   filteredAdv.add(eff);
				   }
			   }
		   effects.removeAll(filteredAdv);
	   }

	
}
