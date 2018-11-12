package frameworkSetup;

import org.apache.log4j.Logger;

public class TestLogging {
	private static Logger Log = Logger.getLogger(TestLogging.class.getName());

	public static void startTestCase(String TestCaseName){
	    Log.info("## Test case name: " + TestCaseName + "execution ready to START ##");
	}

	public static void endTestCase(String TestCaseName){
	    Log.info("## Test case name: " + TestCaseName + "execution FINISHED ##");
	}

	public static void info(String message) {
        Log.info(message);
    }

    public static void warn (String message){
	    Log.warn(message);
	}

	public static void error(String message) {
	    Log.error(message);
	}

	public static void fatal(String message) {
	    Log.fatal(message);
	}

	public static void debug(String message) {
	    Log.debug(message);
	}
}