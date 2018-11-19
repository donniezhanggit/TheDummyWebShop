package FrameworkSetup;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static FrameworkSetup.RestApi.BASE_URL;

public class DriverProvider {

    private WebDriver browserDriver;
    private final String BROWSER = "chrome";

    public DriverProvider() {
        getDriver();
    }

    private WebDriver createDriver() {

        if (BROWSER.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            browserDriver = new ChromeDriver();
            browserDriver.manage().deleteAllCookies();

        } else if (BROWSER.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            browserDriver = new FirefoxDriver();
            browserDriver.manage().deleteAllCookies();
        }
        browserDriver.get(BASE_URL);
        browserDriver.manage().window().maximize();
        browserDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return browserDriver;
    }

    public WebDriver getDriver() {
        return (browserDriver == null) ? createDriver() : browserDriver;
    }

    public void takeScrenshoot(String path) {
        File src = ((TakesScreenshot) browserDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Screenshot location not found");
        }
    }
}

