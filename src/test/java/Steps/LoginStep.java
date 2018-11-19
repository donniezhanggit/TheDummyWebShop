package Steps;

import Pages.Service.UsersService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import FrameworkSetup.TestContext;
import Pages.UI.LoginPage;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.baseURI;


public class LoginStep {
    private LoginPage loginPage;
    private UsersService usersService;
    private TestContext testContext;

    public LoginStep(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getPageManager().getLoginPage();
        usersService = testContext.getPageManager().getUsersServicePage();
    }

    @Given("^I'm on the Login page$")
    public void goToLoginPage() {
        loginPage.goToLogin(baseURI + "login");
    }

    @Given("^the user (.*) exists on the database$")
    public void verifyUserExists(String user) {
        usersService.verifyUserExists(user);
    }

    @When("^I click on the \"([^\"]*)\" link$")
    public void clickOnLink(String buttonText) {
        loginPage.clickOnLinkWithText(buttonText);
    }

    @Then("^I should be on the \"([^\"]*)\" Page$")
    public void verifyPageTitle(String title) {
        loginPage.verifyPageTitleIs(title);
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterCredentials(String username, String password) {
        loginPage.loginAttempt(username, password);
    }

    @Then("^I should be logged in with the user (.*)$")
    public void verifyUserIsLogged(String user) {
        loginPage.verifyLoginSucceeded(user);
    }
}

