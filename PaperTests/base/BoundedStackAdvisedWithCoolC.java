package base;

/**
 * This class represents a result of weaving a BoundedStack.cool coordinator
 * into the original BoundedStack.java by a standard COOL compiler. We refer to
 * the standard COOL compiler as "coolc". coolc implements a weaving algorithm
 * described in Crista Lopes's thesis.
 * 
 * @author Sergei
 * 
 */
public class BoundedStackAdvisedWithCoolC implements Stack {
	private int usedSlots = 0;

	private Object[] buffer;

	// introduced by coolc
	private aspects.cool.BoundedStackCoolCCoord _coord;

	public BoundedStackAdvisedWithCoolC(int capacity) {
		this.buffer = new Object[capacity];
		// introduced by coolc:
		_coord = new aspects.cool.BoundedStackCoolCCoord();
	}

	public Object pop() {
		_coord.lock_pop(this);
		try {
			Object result = buffer[usedSlots - 1];
			usedSlots--;
			buffer[usedSlots] = null;
			return result;
		} finally {
			_coord.unlock_pop(this);
		}
	}

	public void push(Object obj) {
		_coord.lock_push(this);
		try {
			buffer[usedSlots] = obj;
			usedSlots++;
		} finally {
			_coord.unlock_push(this);
		}
	}

	//introduced by coolc:
	public Object[] _getBuffer() {
		return buffer;
	}

}
