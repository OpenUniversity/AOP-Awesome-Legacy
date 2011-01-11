package aspects.cool;

import cool.runtime.*;
import base.BoundedStackAdvisedWithCoolC;

public class BoundedStackCoolCCoord {
	private boolean empty = true, full = false;

	private int top = 0;

	private MethodState pop = new MethodState();

	private MethodState push = new MethodState();

	public synchronized void lock_pop(BoundedStackAdvisedWithCoolC thiz) {
		while (pop.isBusyByOtherThread() || push.isBusyByOtherThread()
				|| !(!empty))
			try {
				wait();
			} catch (InterruptedException e) {
			}
		top = top - 1;
		pop.in();
	}

	public synchronized void unlock_pop(BoundedStackAdvisedWithCoolC thiz) {
		pop.out();
		full = false;
		if (top == 0)
			empty = true;
		notifyAll();
	}

	public synchronized void lock_push(BoundedStackAdvisedWithCoolC thiz) {
		while (push.isBusyByOtherThread() || pop.isBusyByOtherThread()
				|| !(!full))
			try {
				wait();
			} catch (InterruptedException e) {
			}
		top = top + 1;
		push.in();
	}

	public synchronized void unlock_push(BoundedStackAdvisedWithCoolC thiz) {
		push.out();
		empty = false;
		if (top == thiz._getBuffer().length)
			full = true;
		notifyAll();
	}

}
