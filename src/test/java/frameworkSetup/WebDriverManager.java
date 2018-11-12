package frameworkSetup;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverManager {

	public WebDriver driver;

	public WebDriverManager(){ }

	public WebDriver getDriver(){
		return (driver==null)? driver = openBrowser(): driver;
	}


	public WebDriver openBrowser(){
		String path = System.getProperty("user.dir");
		String url = ConfigFileManager.getInstance().getConfiguration().getApplicationURL();
		String browser = ConfigFileManager.getInstance().getConfiguration().getApplicationBrowser();
		String chromeDriverWindows = path+ConfigFileManager.getInstance().getConfiguration().getChromeDriverPathWindows();
		String chromeDriverLinux = path+ConfigFileManager.getInstance().getConfiguration().getChromeDriverPathLinux();
		Long implicitWait = Long.parseLong(ConfigFileManager.getInstance().getConfiguration().getimplicitWait());
		String operatingSystem=ConfigFileManager.getInstance().getConfiguration().getOS();

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
		TestLogging.info("Setting Implicit Wait = " + implicitWait);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		return driver;
	}

	public void closeBrowser(){
		TestLogging.info("Closing Browser");
		driver.close();
	}

	public void closeAllBrowsers(){
		TestLogging.info("Closing All Browsers");
		driver.quit();
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
