package general;

import java.io.File;
import org.apache.http.cookie.Cookie;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources"
		,glue="stepDefinition"
		,plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"}
		)

public class TestRunner {

	@BeforeClass
	public static void setup() {
		String path = System.getProperty("user.dir")+"/cucumber-reports/report.html";
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath(path);
	}
	
	@AfterClass
	public static void writeExtentReport(){
		Reporter.loadXMLConfig(new File(ConfigFileManager.getInstance().getConfiguration().getExtentReportPath()));
	}
	
}
