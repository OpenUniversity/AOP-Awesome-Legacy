package aspects.cool;

import org.aspectj.lang.annotation.Aspect;
import base.BoundedStack;
import cool.runtime.*;
import awesome.platform.annotations.*;


@COOLAspect(className="base.BoundedStack")
@Aspect
public class BoundedStackCoord {
	// code added by Oren
	privileged public static aspect MyAspect {
		//private int BoundedStack.foo;
		//private BoundedStackCoord BoundedStack._mycoord;
		//@AwSuppressReify
		public Object[] BoundedStack.getBuffer() {
			return buffer;
		}
	}
	/*public void printBufferLength() {
		System.out.println(target.getBuffer().length);
	}*/
	
	// end of code added
private @COOLCoordinatorField int top = 0;
private @COOLConditionField boolean full = false;
private @COOLConditionField boolean empty = true;

  private MethodState meth_pop_0 = new MethodState();
  private MethodState meth_push_1 = new MethodState();

  @COOLLock(methodName="pop", className="", parameterTypes={})
  public synchronized void meth_pop_0_lock(base.BoundedStack thiz) {
    while(false
      || meth_pop_0.isBusyByOtherThread()
      || meth_push_1.isBusyByOtherThread()
      || !requires_pop_33109165_0())
      try { wait(); } catch (InterruptedException e) {}
    on_entry_pop_33109165_0(thiz);
    meth_pop_0.in();
  }

  @COOLUnlock(methodName="pop", className="", parameterTypes={})
  public synchronized void meth_pop_0_unlock(base.BoundedStack thiz) {
    meth_pop_0.out();
    on_exit_pop_33109165_0(thiz);
    notifyAll();
  }
  @COOLLock(methodName="push", className="", parameterTypes={"java.lang.Object"})
  public synchronized void meth_push_1_lock(base.BoundedStack thiz) {
    while(false
      || meth_push_1.isBusyByOtherThread()
      || meth_pop_0.isBusyByOtherThread()
      || !requires_push_15789782_0())
      try { wait(); } catch (InterruptedException e) {}
    on_entry_push_15789782_0(thiz);
    meth_push_1.in();
  }

  @COOLUnlock(methodName="push", className="", parameterTypes={"java.lang.Object"})
  public synchronized void meth_push_1_unlock(base.BoundedStack thiz) {
    meth_push_1.out();
    on_exit_push_15789782_0(thiz);
    notifyAll();
  }
  @COOLRequires(methodName="pop", className="", parameterTypes={})
  private boolean requires_pop_33109165_0() {
    return !empty;
  }
  @COOLRequires(methodName="push", className="", parameterTypes={"java.lang.Object"})
  private boolean requires_push_15789782_0() {
    return !full;
  }
  @COOLOnEntry(methodName="pop", className="", parameterTypes={})
  private void on_entry_pop_33109165_0(base.BoundedStack thiz) { 
    top = top - 1;
  }
    @COOLOnEntry(methodName="push", className="", parameterTypes={"java.lang.Object"})
  private void on_entry_push_15789782_0(base.BoundedStack thiz) { 
    top = top + 1;
  }
    @COOLOnExit(methodName="pop", className="", parameterTypes={})
  private void on_exit_pop_33109165_0(base.BoundedStack thiz) { 
    full = false;
    if (top == 0)
      empty = true;
  }
    //@AwSuppressReify
    @COOLOnExit(methodName="push", className="", parameterTypes={"java.lang.Object"})
  private void on_exit_push_15789782_0(base.BoundedStack thiz) { 
    empty = false;
/*    if (top ==  _ref0(thiz))
      full = true;*/
    if (top ==  thiz.getBuffer().length)
        full = true;
  }
    @COOLExternalRef(expr="buffer.length")
  private double _ref0(base.BoundedStack thiz) {
    return 0;
  }

}


