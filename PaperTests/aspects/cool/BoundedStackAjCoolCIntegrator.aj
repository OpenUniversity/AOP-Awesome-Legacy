package aspects.cool;
import java.util.*;
import base.BoundedStackAdvisedWithAjCoolC;

public aspect BoundedStackAjCoolCIntegrator {
   private Map<BoundedStackAdvisedWithAjCoolC, BoundedStackAjCoolCCoord> obj2coord 
     = new HashMap<BoundedStackAdvisedWithAjCoolC, BoundedStackAjCoolCCoord>();
   
   after(BoundedStackAdvisedWithAjCoolC obj): 
	   initialization(BoundedStackAdvisedWithAjCoolC.new(..)) &&
	   this(obj) {
	   obj2coord.put(obj, new BoundedStackAjCoolCCoord());
   }
   
	before(BoundedStackAdvisedWithAjCoolC thiz):
		execution(void BoundedStackAdvisedWithAjCoolC.push(Object)) && 
		this(thiz) {
		obj2coord.get(thiz).lock_push(thiz);
	}
	
	after(BoundedStackAdvisedWithAjCoolC thiz):
		execution(void BoundedStackAdvisedWithAjCoolC.push(Object)) && 
		this(thiz) {
		obj2coord.get(thiz).unlock_push(thiz);
	}

	before(BoundedStackAdvisedWithAjCoolC thiz):
		execution(Object BoundedStackAdvisedWithAjCoolC.pop()) && 
		this(thiz) {
		obj2coord.get(thiz).lock_pop(thiz);
	}
	
	after(BoundedStackAdvisedWithAjCoolC thiz):
		execution(Object BoundedStackAdvisedWithAjCoolC.pop()) && 
		this(thiz) {
		obj2coord.get(thiz).unlock_pop(thiz);
	}
}
