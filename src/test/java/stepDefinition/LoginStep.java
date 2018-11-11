package stepDefinition;

import org.openqa.selenium.By;
import pages.HomePage;
import pages.LoginPage;
import general.TestContext;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginStep {

  public WebDriver driver;
  TestContext testContext;
  public HomePage home;
	public LoginPage login;

	public LoginStep(TestContext context) {
	  testContext = context;
		home = testContext.getPage().getHomePage();
		login = testContext.getPage().getLoginPage();
	}

	@Given("^I navigate to facebook page$")
  public void goToFacebook() {
    login.goToFacebook();
  }

  @When("^user logs in using Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
  public void I_enter_Username_as_and_Password_as(String arg1, String arg2) {
    driver.findElement(By.id("email")).sendKeys(arg1);
    driver.findElement(By.id("pass")).sendKeys(arg2);
    driver.findElement(By.id("u_0_v")).click();
  }

  @Then("^login should be unsuccessful$")
  public void validateRelogin() {
    if(driver.getCurrentUrl().equalsIgnoreCase(
        "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
      System.out.println("Test Pass");
    } else {
      System.out.println("Test Failed");
    }
    driver.close();
  }

}
