package base;

public class BoundedStack implements Stack {

	protected Object[] buffer;
	int x;

	private int usedSlots = 0;

	public BoundedStack(int capacity) {
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
	public int div() {
		return x/5;
	}

}
