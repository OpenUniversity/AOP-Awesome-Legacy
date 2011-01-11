package aspects.cool;
import cool.runtime.*;
import base.BoundedStackAdvisedWithAjCoolC;

public class BoundedStackAjCoolCCoord {
	private @COOLConditionField boolean empty = true;
	private @COOLConditionField boolean full = false;

	private @COOLCoordinatorField int top = 0;

	private MethodState pop = new MethodState();

	private MethodState push = new MethodState();

	public synchronized void lock_pop(BoundedStackAdvisedWithAjCoolC thiz) {
		while (pop.isBusyByOtherThread() || push.isBusyByOtherThread()
				|| !(!empty))
			try {
				wait();
			} catch (InterruptedException e) {
			}
		top = top - 1;
		pop.in();
	}

	public synchronized void unlock_pop(BoundedStackAdvisedWithAjCoolC thiz) {
		pop.out();
		full = false;
		if (top == 0)
			empty = true;
		notifyAll();
	}

	public synchronized void lock_push(BoundedStackAdvisedWithAjCoolC thiz) {
		while (push.isBusyByOtherThread() || pop.isBusyByOtherThread()
				|| !(!full))
			try {
				wait();
			} catch (InterruptedException e) {
			}
		top = top + 1;
		push.in();
	}

	public synchronized void unlock_push(BoundedStackAdvisedWithAjCoolC thiz) {
		push.out();
		empty = false;
		if (top == thiz.buffer.length)
			full = true;
		notifyAll();
	}

	protected Object clone() throws CloneNotSupportedException {
		return null;
	}
}
