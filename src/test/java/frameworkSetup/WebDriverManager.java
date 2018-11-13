package frameworkSetup;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverManager {

	public WebDriver driver;

	public WebDriverManager(){ }

	public WebDriver getDriver(){
		return (driver == null) ? driver = openBrowser(): driver;
	}


	public WebDriver openBrowser(){
		String path = System.getProperty("user.dir");
		String url = ConfigFileReader.getConfiguration().getApplicationURL();
		String browser = ConfigFileReader.getConfiguration().getApplicationBrowser();
		String chromeDriverWindows = path + ConfigFileReader.getConfiguration().getChromeDriverPathWindows();
		String chromeDriverLinux = path + ConfigFileReader.getConfiguration().getChromeDriverPathLinux();
		String operatingSystem=ConfigFileReader.getConfiguration().getOS();

		if(browser.equals("chrome")){
			if(operatingSystem.equals("Linux")){
				System.setProperty("webdriver.chrome.driver", chromeDriverLinux);
				TestLogging.info("Opening Browser");
				driver = new ChromeDriver();
			}

			if(operatingSystem.equals("Windows")){
				System.setProperty("webdriver.chrome.driver", chromeDriverWindows);
				TestLogging.info("Opening Browser");
				driver = new ChromeDriver();
			}
		}
		driver.get(url);
		return driver;
	}

	public void closeBrowser(){
		TestLogging.info("Closing Browser");
		driver.close();
	}

	public void getScreenShot(String testcase){
		TestLogging.info("Taking Screen Shot for testcase = " + testcase);
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(src,new File(path + "/screenshots/screenshot" + testcase + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Screenshot location not found");
		}
	}
}
