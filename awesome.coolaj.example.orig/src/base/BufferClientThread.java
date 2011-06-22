package base;

public abstract class BufferClientThread extends Thread {

	public static int numOfOps = 0;

	public int ops = 0;

	public int opLimit = -1;

	public long runningTime = -1;

	public boolean caughtException = false;

	protected Stack shared;

	protected boolean shutdown = false;

	protected BufferClientThread(Stack shared) {
		this.shared = shared;
	}

	protected BufferClientThread(Stack shared, int opLimit) {
		this.shared = shared;
		this.opLimit = opLimit;
	}

	public synchronized void shutdown() {
		shutdown = true;
	}

	private boolean started = false;

	private boolean finished = false;

	/**
	 * 
	 * @return
	 */
	public boolean hasStarted() {
		return started;
	}

	/**
	 * indicates if the thread should wait on the shared buffer object before
	 * running.
	 */
	private boolean waitBeforeRun = false;

	/**
	 * Should be invoked before starting the thread. Instructs the thread to
	 * wait on the shared buffer object after it starts, but before it executes
	 * its task. The thread proceeds when <code>notifyAll</code> method is
	 * called on the buffer object.
	 */
	public void setWaitBeforeRun() {
		waitBeforeRun = true;
	}

	protected abstract void accessBuffer();

	public void run() {
		started = false;
		finished = false;
		// this allows multiple threads to wait for each other
		if (waitBeforeRun) {
			synchronized (shared) {
				started = true;
				try {
					shared.wait();
				} catch (Exception e) {
				}
			}
		} else {
			started = true;
		}
		runningTime = System.currentTimeMillis();
		ops = 0;
		caughtException = false;
		try {
			while (!shutdown && (opLimit < 0 || opLimit > ops)) {
				accessBuffer();
				numOfOps++;
				ops++;
				// shared.noSync();
			}
		} catch (Exception e) {
			caughtException = true;
		}
		runningTime = System.currentTimeMillis() - runningTime;
			//System.out.println("Thread " + Thread.currentThread()
				//	+ " is stopped, the buffer accessed " + ops
					//+ " times, runningTime = " + runningTime);
		//else
		if (caughtException)
			System.out.println("Exception is caught in thread "
					+ Thread.currentThread() + "; the buffer accessed " + ops
					+ " times, runningTime = " + runningTime);
		waitBeforeRun = false;
		// started = false;
		finished = true;
	}

	public long getRunningTime() {
		return runningTime;
	}

	/**
	 * Starts multiple threads on the same buffer. Throws an exception if the
	 * threads do not share the same buffer object.
	 * 
	 * @param threads
	 *            an array of threads that ALL share the same buffer object!
	 */
	static void startThreads(BufferClientThread[] threads) throws Exception {
		if (threads.length == 0)
			return;
		// obtaining the shared buffer object
		Object buffer = threads[0].shared;
		// verifying the pre-condition
		for (int i = 1; i < threads.length; i++)
			if (threads[i].shared != buffer)
				throw new Exception("Threads must share the same buffer!");
		// starting the threads, and instructing them to wait on the buffer
		for (int i = 0; i < threads.length; i++) {
			threads[i].setWaitBeforeRun();
			threads[i].start();
		}
		// ensuring each thread has entered its run method
		while (!allRunning(threads))
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		// System.out.println("All threads are ready to start...");
		// synchronized block ensures that all threads are waiting on the buffer
		synchronized (buffer) {
			// starting all the threads!
			try {
				buffer.notifyAll();
			} catch (Exception e) {
			}
		}
		// System.out.println("All threads started!");
	}

	/**
	 * Instructs the threads to stop by invoking <code>shutdown</code> method
	 * on the thread objects. Threads will execute for a while after that.
	 */
	static void stopThreads(BufferClientThread[] threads) {
		for (int i = 0; i < threads.length; i++)
			threads[i].shutdown();
	}

	/**
	 * Returns true if at least one thread in the <code>threads</code> array
	 * is alive.
	 * 
	 * @param threads
	 * @return
	 */
	static boolean isAlive(BufferClientThread[] threads) {
		for (int i = 0; i < threads.length; i++)
			if (!threads[i].finished) // threads[i].isAlive())
				return true;
		return false;
	}

	/**
	 * The <code>BufferClientThread.hasStarted()</code> returns true if the
	 * thread has already started, and it hasn't yet completed. This method
	 * returns <code>true</code>, if the <code>hasStarted</code> method of
	 * ALL thread objects in the <code>threads</code> array returns
	 * <code>true</code>
	 * 
	 * @param threads
	 * @return <code>true</code> if ALL <code>threads</code> already
	 *         started, and not yet completed (if threads[i].hasStarted()==true
	 *         for all threads).
	 * 
	 */
	static boolean allRunning(BufferClientThread[] threads) {
		for (int i = 0; i < threads.length; i++)
			if (!threads[i].hasStarted())
				return false;
		return true;
	}
}
