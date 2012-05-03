package awesome.platform;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WeavingLogger {
	private static final String OUTFILE = System.getenv().get("WEAVING_TRACE_FILE");
	private static final String CLASS_KEY = "class: ";
	private static final String NL = "\n";
	private static final String NUM_OF_REFIED_SHADOWS_KEY = "num_of_reified_shadows: ";
	private StringBuffer buffer;
	private BufferedWriter writer;
	
	public WeavingLogger() {
		buffer = new StringBuffer();
		// delete the output file if it exists
		File file = new File(OUTFILE);
		if(file.exists())
			file.delete();
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
			writer = new BufferedWriter(new FileWriter(OUTFILE, true));
			writer.write(buffer.toString());
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void numOfReifiedShadows(int size) {
		buffer.append(NUM_OF_REFIED_SHADOWS_KEY + size + NL);
	}

}
