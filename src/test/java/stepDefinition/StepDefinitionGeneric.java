package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import general.Log;
import pages.HomePage;
import general.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class StepDefinitionGeneric {

	TestContext testContext;
	public HomePage home;
	
	public StepDefinitionGeneric(TestContext test) {
		testContext=test;
		home = testContext.getPage().getHomePage();
	}
	
	@Before
	public void before(Scenario scenario){
		Log.startTestCase(scenario.getName());
	}
	
	@After
	public void close_browser(Scenario scenario){
		testContext.getWebDriverManager().closeBrowser();
		Log.endTestCase();
	}

	@Given("^something item$")
	public void something() throws Throwable {
		something();
		throw new PendingException();
	}
	
}
