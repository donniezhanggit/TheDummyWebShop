package stepDefinitions;

import cucumber.api.java.en.When;
import general.TestContext;
import org.openqa.selenium.By;
import pages.LoginPage;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class LoginStep {

    public LoginPage login;
    public WebDriver driver;
    TestContext testContext;

    public LoginStep (TestContext context) {
        testContext = context;
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
}
