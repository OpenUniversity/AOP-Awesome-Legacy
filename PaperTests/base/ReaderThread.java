package base;

public class ReaderThread extends BufferClientThread {

	public ReaderThread(Stack shared) {
		super(shared);
	}

	public ReaderThread(Stack shared, int ops) {
		super(shared, ops);
	}

	protected void accessBuffer() {
		shared.pop();
	}

}
