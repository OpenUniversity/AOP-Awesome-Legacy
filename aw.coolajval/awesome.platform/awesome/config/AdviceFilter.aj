package awesome.config;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.Advice;
import org.aspectj.weaver.AdviceKind;
import org.aspectj.weaver.bcel.BcelShadow;

import awesome.platform.IEffect;
import awesome.platform.MultiMechanism;
import coolplugin.COOLWeaver;

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
					   System.out.println("Around advice cannot apply at "+shadow + " (" + rmvd + " advice removed)");
				   }
		     } 
		   }
		   proceed(mm, effects, shadow);
	   }
	   
	   private void filterAdvice(List<IEffect> effects) {
		   List<IEffect> filteredAdvice = new ArrayList<IEffect>();
		   for(IEffect eff:effects)
			   if (eff!=null && (eff instanceof Advice)) {
				   Advice adv = (Advice)eff;
				   if (adv.getKind()== AdviceKind.Around)  {
					   //System.out.println(" removing an around advice ");
					   filteredAdvice.add(eff);
				   }
			   }
		   effects.removeAll(filteredAdvice);
	   }

	
}
