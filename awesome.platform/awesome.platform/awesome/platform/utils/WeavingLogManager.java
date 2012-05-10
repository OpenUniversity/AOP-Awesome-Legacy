package awesome.platform.utils;

import java.io.File;

public class WeavingLogManager {
	public static final String WEAVING_LOG_FOLDER = "weavinglogs";
	/**
	 * Returns the weaving log of a particular type woven by Awesome.
	 * All weaving log files are located in the folder WEAVING_LOG_FOLDER, and
	 * are arranged in subfolders corresponding to test applications.
	 * @param testapp the name of a subfolder under WEAVING_LOG_FOLDER
	 * @param clazz the path of the class whose weaving log is desired, e.g., aspects/CoolAspect
	 * @return
	 */
	public static WeavingLog getLog(String testapp, String clazz) {
		File logfile = new File(WEAVING_LOG_FOLDER + "/" + testapp + ".log");
		if(!logfile.exists())
			throw new RuntimeException("Weaving log file " + WEAVING_LOG_FOLDER + "/" + testapp + ".log " + "does not exist");
		
		return new WeavingLog(testapp, clazz);
	}
}
