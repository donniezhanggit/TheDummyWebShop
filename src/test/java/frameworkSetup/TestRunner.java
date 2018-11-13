package frameworkSetup;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)

@CucumberOptions(
        features="src/test/resources",
        glue="stepDefinitions",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"}
)

public class TestRunner {

    @BeforeClass
    public static void setup(WebDriver driver) {
        String path = System.getProperty("user.dir") + "/cucumber-reports/report.html";
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath(path);
        TestLogging.info("Delete all Cookies");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void writeExtentReport(WebDriver driver){
        Reporter.loadXMLConfig(new File(ConfigFileReader.getConfiguration().getExtentReportPath()));
        TestLogging.info("Closing Browser");
        driver.close();
    }

}
