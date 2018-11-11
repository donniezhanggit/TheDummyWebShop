package general;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;


public class WebDriverManager {

  public WebDriver driver;
  public ConfigFileManager fileReadManager;
  public ConfigFileReader config;
  public HomePage home;
  public PageManager page;
  public WebDriverWait wait;

  public WebDriverManager(){ }

  public WebDriver getDriver(){
    return (driver==null)? driver = openBrowser(): driver;
  }

	public org.openqa.selenium.WebDriver openBrowser(){
		String path = System.getProperty("user.dir");
		String url = ConfigFileManager.getInstance().getConfiguration().getApplicationURL();
		String browser = ConfigFileManager.getInstance().getConfiguration().getApplicationBrowser();
		String chromeDriverWindows = path+ConfigFileManager.getInstance().getConfiguration().getChromeDriverPathWindows();
		String chromeDriverLinux = path+ConfigFileManager.getInstance().getConfiguration().getChromeDriverPathLinux();
		Long implicitWait = Long.parseLong(ConfigFileManager.getInstance().getConfiguration().getimplicitWait());
		String operatingSystem=ConfigFileManager.getInstance().getConfiguration().getOS();
		
		if(browser.equals("chrome")){
			if(operatingSystem.equals("Linux")) {
				System.setProperty("webdriver.chrome.driver", chromeDriverLinux);
				Log.info("Opening Browser");
			driver = new ChromeDriver();
			}
			if(operatingSystem.equals("Windows")) {
				System.setProperty("webdriver.chrome.driver", chromeDriverWindows);
				Log.info("Opening Browser");
				driver = new ChromeDriver();
			}
		}
		driver.manage().deleteAllCookies();
		driver.get(url);
		Log.info("Setting Implicit Wait="+implicitWait);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		return driver;
	}

	public void closeBrowser() {
		Log.info("Closing Browser");
		driver.close();
	}

	public void closeAllBrowsers() {
		Log.info("Closing All Browsers");
		driver.quit();
	}

	public WebDriverWait getExplicitWaitForElement(WebElement element,String waitType) {
		Long explicitWait = ConfigFileManager.getInstance().getConfiguration().getExplicitWait();
		Log.info("Setting Explicit Wait Type = "+waitType);
		wait = new WebDriverWait(getDriver(), explicitWait);

		if(waitType.equals("visibility")) {
			wait.until(ExpectedConditions.visibilityOf(element));
			return wait;
		} else if(waitType.equals("invisibility")){
		    wait.until(ExpectedConditions.invisibilityOf(element));
			return wait;
		} else if(waitType.equals("clickable")){
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return wait;
		} else {
		    throw new RuntimeException("Wait "+waitType+" Type is not Supported");
		}
	}

	public void getScreenShot(String testcase){
		Log.info("Taking Screen Shot for testcase="+testcase);
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(src,new File(path+"/screenshots/screenshot"+testcase+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Screenshot location not found");
		}
	}
}
