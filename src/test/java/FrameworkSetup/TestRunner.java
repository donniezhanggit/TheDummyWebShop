package FrameworkSetup;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        format = {"pretty", "json:target/cucumber-report.json", "html:target/report-data"},
        features = {"src/test/resources/Features"},
        glue={"Steps"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
