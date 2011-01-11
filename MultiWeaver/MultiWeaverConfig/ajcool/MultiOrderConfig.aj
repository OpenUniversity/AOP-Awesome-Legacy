package ajcool;
import platform.IEffect;
import platform.MultiMechanism;
import java.util.*;
import org.aspectj.weaver.bcel.*;
import coolplugin.*;
import ajplugin.AJWeaver;
import org.aspectj.weaver.AdviceKind;


public aspect MultiOrderConfig {
	private static Class COOLWeaverClass = COOLWeaver.class; 
	private static Class AJWeaverClass = AJWeaver.class; 

	   List around(MultiMechanism mm, List multiEffects, BcelShadow shadow): 
		   execution(List MultiMechanism.multiOrder(List, BcelShadow)) 
		   && this(mm) && args(multiEffects, shadow) {
		   int coolPos = mm.getMechanismPos(COOLWeaverClass);
		   int ajPos = mm.getMechanismPos(AJWeaverClass);
		   //System.out.println("Running multi-order config on "+shadow+" ajmech num:"+ajPos+" , coolmech num:"+coolPos);
		   List<IEffect> result = new ArrayList<IEffect>();
		   if (coolPos>=0 && ajPos>=0) {
			   List<IEffect> coolEffects = (List<IEffect>)multiEffects.get(coolPos);
			   List<IEffect> ajEffects = (List<IEffect>)multiEffects.get(ajPos);
			   if (coolEffects!=null && ajEffects!=null) {
				   result.addAll(ajEffects);
				   int cflowPos = -1;
				   for(int i=0;i<ajEffects.size();i++) {
					   IEffect ajEff = ajEffects.get(i);
					   if (!(ajEff instanceof BcelAdvice)) 
						   continue;
					   AdviceKind kind = ((BcelAdvice)ajEff).getKind();
					   if (kind!=null && 
							   kind.isCflow() &&
							   (kind == AdviceKind.CflowEntry ||
									   kind == AdviceKind.PerCflowEntry)) {
						   cflowPos = i;
						   break;
					   }
				   }
				   if (cflowPos>=0) {
					  // System.out.println("Ordering COOL advice to be run after AspectJ's cflow advice (pos = "+cflowPos+" out of "+ajEffects.size()+") at "+shadow);
					   //this way COOL effects are weaved
					   //right before the CFlow =>
					   //CFlow wraps around the COOL effects,
					   //and they wrap around all other AJ advice
					   result.addAll(cflowPos, coolEffects);
				   } else
					   result.addAll(coolEffects);
				   return result;
			   }
		   }		   
		   return proceed(mm, multiEffects, shadow);
	   }
}
