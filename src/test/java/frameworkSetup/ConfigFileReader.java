package frameworkSetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

public class ConfigFileReader {

    private static ConfigFileReader config;
	private Properties prop;
	private FileInputStream file;
	private static final String PROP_LOCATION = "/src/test/resources/data.properties";

	public static ConfigFileReader getConfiguration(){
	    return (config == null) ? new ConfigFileReader() : config;
	}
		
	public ConfigFileReader(){
		String userDirectory = System.getProperty("user.dir");
		String path = userDirectory+PROP_LOCATION;
		
		prop = new Properties();
		try {
			file = new FileInputStream(path);
			try {
				TestLogging.info("Loading Property File");
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
				TestLogging.error("Not able to load Property File");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Property file not found");
		}
		DOMConfigurator.configure(userDirectory+"/src/test/resources/log4j.xml");
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Property file not found");
		}
	}
	
	public String getApplicationURL(){
		String url = prop.getProperty("url");
		if(url != null){
		    return url;
		}  else {
		    throw new RuntimeException("URL value is set to NULL.");
		}
	}
	
	public String getApplicationBrowser(){
		String browser = prop.getProperty("browser");
		if(browser != null){
		    return browser;
		} else {
		    throw new RuntimeException("Browser value is set to NULL.");
		}
	}
	
	public String getChromeDriverPathLinux(){
		String chrome_driverpath = prop.getProperty("chrome_driverpath_linux");
		if(chrome_driverpath != null){
		    return chrome_driverpath;
		} else {
		    throw new RuntimeException("Chrome Driver Path value is set to NULL.");
		}
	}
	
	public String getChromeDriverPathWindows(){
		String chrome_driverpath = prop.getProperty("chrome_driverpath_windows");
		if(chrome_driverpath != null){
		    return chrome_driverpath;
		} else {
		    throw new RuntimeException("Chrome Driver Path value is set to NULL.");
		}
	}

	public String getimplicitWait(){
		String implicitWait = prop.getProperty("implicitWait");
		if(implicitWait != null){
		    return implicitWait;
		} else {
		    throw new RuntimeException("URL value is set to NULL.");
		}
	}
		
	public String getExtentReportPath(){
		String location = prop.getProperty("extentReportLocation");
		String path  = System.getProperty("user.dir")+location;
		System.out.println(path);
		if(path != null){
		    return path;
		} else {
		    throw new RuntimeException("extent-report location is null");
		}
	}
	
	public String getOS() {
		String operatingSystem  = prop.getProperty("operating_system");
		System.out.println(operatingSystem);
		if(operatingSystem != null){
			return operatingSystem;
		} else {
			throw new RuntimeException("Operating System type location is null");
		}
	}
}
