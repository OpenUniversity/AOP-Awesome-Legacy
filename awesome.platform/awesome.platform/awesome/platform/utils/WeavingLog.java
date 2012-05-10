package awesome.platform.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class WeavingLog {
	public static final String CLASS_KEY = "class:";
	private static final String NUM_OF_REIFIED_SHADOWS_KEY = "num_of_reified_shadows:";
	private String testapp;
	private String clazz;
	private int numberOfReifiedShadows;

	public int getNumberOfReifiedShadows() {
		return numberOfReifiedShadows;
	}
	WeavingLog(String testapp, String clazz) {
		this.testapp = testapp;
		this.clazz = clazz;
		initLog();
	}
	public List<Object> getReifiedShadows() {
		return null;
	}
	/**
	 * In this method we initialize the fields holding the weaving data of the
	 * clazz type. We go over thre whole weaving log, searching for the lines
	 * corresponding to clazz and then initialize the fields accordingly. 
	 */
	private void initLog() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(WeavingLogManager.WEAVING_LOG_FOLDER + "/" + testapp + ".log "));
			String line;
			boolean found = false;
			while((line = reader.readLine()) != null) {
				if(line.startsWith(CLASS_KEY)) {
					String className = line.split(" ")[1];
					if(className.equals(clazz)) {
						found = true;
						break;
					}
				}
			}
			// if clazz was not found we throw an exception
			if(!found)
				throw new RuntimeException("class " + clazz + " was not found in the weaving log");
			
			// now the lines till next CLASS_PREFIX are ours
			while((line = reader.readLine()) != null) {
				String key = line.split(" ")[0];
				if(key.equals(CLASS_KEY))
					break;
				if(key.equals(NUM_OF_REIFIED_SHADOWS_KEY))
					numberOfReifiedShadows = Integer.parseInt(line.split(" ")[1]);
				// add here treatment for more keys...
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
