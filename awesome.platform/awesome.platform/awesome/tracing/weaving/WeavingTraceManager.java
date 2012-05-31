package awesome.tracing.weaving;

import java.io.File;

public class WeavingTraceManager {
	public static final String WEAVING_TRACE_FOLDER = "weaving.trace";
	/**
	 * Returns the weaving trace of a particular type woven by Awesome.
	 * All weaving trace files are located in the folder WEAVING_TRACE_FOLDER, and
	 * are arranged in subfolders corresponding to test applications.
	 * @param testapp the name of a subfolder under WEAVING_TRACE_FOLDER
	 * @param clazz the path of the class whose weaving trace is desired, e.g., aspects/CoolAspect
	 * @return
	 */
	public static WeavingTrace getTrace(String testapp, String clazz) {
		File tracefile = new File(WEAVING_TRACE_FOLDER + "/" + testapp + ".trace");
		if(!tracefile.exists())
			throw new RuntimeException("Weaving trace file " + WEAVING_TRACE_FOLDER + "/" + testapp + ".trace " + "does not exist");
		
		return new WeavingTrace(testapp, clazz);
	}
}
