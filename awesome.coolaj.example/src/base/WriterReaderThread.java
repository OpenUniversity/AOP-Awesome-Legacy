package base;

public class WriterReaderThread extends BufferClientThread {
	public WriterReaderThread(Stack shared) {
		super(shared);
	}

	public WriterReaderThread(Stack shared, int ops) {
		super(shared, ops);
	}

	protected void accessBuffer() {
		shared.push(this);
		shared.pop();
	}

}
