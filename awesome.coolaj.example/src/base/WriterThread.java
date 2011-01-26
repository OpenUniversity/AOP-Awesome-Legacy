package base;

public class WriterThread extends BufferClientThread {

	public WriterThread(Stack shared) {
		super(shared);
	}

	public WriterThread(Stack shared, int ops) {
		super(shared, ops);
	}

	protected void accessBuffer() {
		try {
			shared.push(new Object());
		} catch (Exception e) {
			System.out.println("Exception while writing to the buffer:"
					+ e.getMessage());
		}
	}

}
