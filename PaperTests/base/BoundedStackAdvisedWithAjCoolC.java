package base;

public class BoundedStackAdvisedWithAjCoolC implements Stack {
	private int usedSlots = 0;

	public Object[] buffer;

	public BoundedStackAdvisedWithAjCoolC(int capacity) {
		this.buffer = new Object[capacity];
	}

	public Object pop() {
		Object result = buffer[usedSlots - 1];
		usedSlots--;
		buffer[usedSlots] = null;
		return result;
	}

	public void push(Object obj) {
		buffer[usedSlots] = obj;
		usedSlots++;
	}
}
