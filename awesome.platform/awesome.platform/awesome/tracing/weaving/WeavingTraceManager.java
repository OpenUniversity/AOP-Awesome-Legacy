package awesome.tracing.weaving;

import java.io.File;

/**
 * This class is the entry point for the weaving trace service. In order to use
 * these services, a launch configuration should be defined with the following 
 * environment variables:<br/>
 * <ul>
 * <li>ENABLE_WEAVING_TRACE whether the tracing should be enabled, e.g., "1"</li>
 * <li>TEST_APP the name of the woven test application.</li>
 * <li>WEAVING_TRACE_FOLDER the folder to which the trace files should be written</li>
 * </ul>
 * @author Oren
 *
 */
public class WeavingTraceManager {
	/**
	 * Returns the weaving trace of a particular type woven by Awesome.
	 * All weaving trace files are located in the folder WEAVING_TRACE_FOLDER, and
	 * are arranged in subfolders corresponding to test applications.
	 * @param testapp the name of a test application to which clazz belongs, e.g., testapp1
	 * @param clazz the path of the class whose weaving trace is desired, e.g., aspects/CoolAspect
	 * @return
	 */
	public static WeavingTrace getTrace(String testapp, String clazz) {
		File tracefile = WeavingTraceWriter.getTraceFile(testapp, clazz);
		if(!tracefile.exists())
			throw new RuntimeException("Weaving trace file " + WeavingTraceWriter.getTraceFile(testapp, clazz) + " does not exist");
		
		return new WeavingTrace(testapp, clazz);
	}
}
