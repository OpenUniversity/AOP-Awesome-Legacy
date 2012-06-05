package awesome.tracing.weaving;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WeavingTraceWriter {
	// it is assumed that a the 'awtrace' folder already exists in the project
	public static final String WEAVING_TRACE_FOLDER = "awtrace";
	private static final String TEST_APP = System.getenv().get("TEST_APP");
	private static final String TRACE_SUFFIX = ".trace";
	private static final String CLASS_KEY = "class: ";
	private static final String NL = "\n";
	private static final String NUM_OF_REFIED_SHADOWS_KEY = "num_of_reified_shadows: ";
	private StringBuffer buffer;
	private BufferedWriter writer;
	
	public WeavingTraceWriter() {
		buffer = new StringBuffer();
		// delete the output file if it exists
		File file = new File(WEAVING_TRACE_FOLDER + "/" + getNameOfTraceFile(TEST_APP));
		if(file.exists())
			file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException("Creation of file " + file.getName() + "failed");
		}
	}
	
	/**
	 * Should be called at the beginning of the weaving process of a particular class.
	 */
	public void beginWeaving(String className) {
		// clear the buffer
		buffer.delete(0, buffer.length());
		buffer.append(CLASS_KEY + className + NL);
	}

	/**
	 * Should be called at the end of the weaving process of a particular class.
	 */
	public void endWeaving() {
		// out file is open for appending, buffer is flushed, and file is closed.
		try {
			writer = new BufferedWriter(new FileWriter(WEAVING_TRACE_FOLDER + "/" + getNameOfTraceFile(TEST_APP), true));
			writer.write(buffer.toString());
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void numOfReifiedShadows(int size) {
		buffer.append(NUM_OF_REFIED_SHADOWS_KEY + size + NL);
	}
	public static String getNameOfTraceFile(String testapp) {
		return testapp + TRACE_SUFFIX;
	}

}
