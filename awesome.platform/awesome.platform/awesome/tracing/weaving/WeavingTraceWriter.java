package awesome.tracing.weaving;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.aspectj.weaver.bcel.BcelShadow;

public class WeavingTraceWriter {
	// it is assumed that the 'awtrace' folder already exists in the project
	public static final String WEAVING_TRACE_FOLDER = "awtrace";
	private static final String TEST_APP = System.getenv().get("TEST_APP");
	//private static String ENABLED_VAR = System.getenv().get("ENABLE_WEAVING_TRACE");
	//private boolean tracingEnabled = ENABLED_VAR.equals("1");
	private static final String TRACE_SUFFIX = ".trace";
	private static final String CLASS_KEY = "class: ";
	private static final String NEW_LINE = "\n";
	private static final String NUM_OF_REIFIED_SHADOWS_KEY = "num_of_reified_shadows: ";
	private static final String REIFIED_SHADOW = "shadow: ";
	private StringBuilder buffer;
	private BufferedWriter writer;

	private static String className;

//	private static WeavingTraceWriter instance;

	
//	public static WeavingTraceWriter getInstance() {
//		if(instance == null)
//			instance = new WeavingTraceWriter();
//		
//		return instance;
//	}
	
	public WeavingTraceWriter() {
		//System.out.println("tracing enabled: " + tracingEnabled);
		//if(tracingEnabled) {
			buffer = new StringBuilder();
			// delete the output file if it exists
//			deleteTraceFileIfExists();
			
		//}
	}
	
	private void deleteTraceFileIfExists(String className) {
		File traceFile = getTraceFile(TEST_APP, className);	
		if (traceFile.exists()) {
			traceFile.delete();
		}
    }

	/**
	 * Should be called at the beginning of the weaving process of a particular class.
	 */
	public void beginWeaving(String className) {
		deleteTraceFileIfExists(className);
		WeavingTraceWriter.className = className;
		// clear the buffer
		buffer.delete(0, buffer.length());
		buffer.append(CLASS_KEY + className + NEW_LINE);
	}

	/**
	 * Should be called at the end of the weaving process of a particular class.
	 */
	public void endWeaving() {
		// out file is open for appending, buffer is flushed, and file is closed.
		try {
			File traceFile = getTraceFile(TEST_APP, className);
			writer = new BufferedWriter(new FileWriter(traceFile , true));
			writer.write(buffer.toString());
			writer.close();
			className = null;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void numOfReifiedShadows(int size) {
		buffer.append(NUM_OF_REIFIED_SHADOWS_KEY + size + NEW_LINE);
	}
	
	public void writeReifiedShadows(List<BcelShadow> shadows) {
		for (BcelShadow bcelShadow : shadows) {
			//buffer.append(REIFIED_SHADOW + bcelShadow.getSignature()).append(NEW_LINE);
			buffer.append(REIFIED_SHADOW + bcelShadow.getKind()).append(NEW_LINE);
		}
		
	}

	public static File getTraceFile(String testApp, String clazz) {
		String traceFilePath = getTraceFilePath(testApp, clazz);
		File traceFile = new File(traceFilePath);
		if (traceFile.exists()){
			return traceFile;
		} else {
			File parentFolder = traceFile.getParentFile();
			if (!parentFolder.exists()){
				parentFolder.mkdirs();
			}
			try {
				traceFile.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException("Couldn't create trace file " + traceFile.getAbsolutePath(), e);
			}
		}
		return traceFile;
	}

	private static String getTraceFilePath(String testApp, String clazz) {
		String traceFilePath = WEAVING_TRACE_FOLDER + File.separator +
				testApp + File.separator + clazz + TRACE_SUFFIX;
		return traceFilePath;
	}

}
