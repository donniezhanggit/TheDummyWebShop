package Steps;

import FrameworkSetup.RestApi;
import Pages.Service.UsersService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;;
import Pages.UI.LoginPage;
import cucumber.api.java.en.When;


public class LoginStep {
    private LoginPage loginPage;
    private UsersService usersService;
    private RestApi restApi;


    @Given("^I'm on the home page$")
    public void verifyHomePage() {
        loginPage.verifyPageTitleIs("The Ninja Store");
    }

    @Given("^the user (.*) exists on the database$")
    public void verifyUserExists(String user) {
        usersService.verifyUserExists(user);
    }

    @When("^I click on admin menu link (.*)$")
    public void clickOnLink(String buttonText) {
        loginPage.clickOnLinkWithText(buttonText);
    }

    @When("^I click on My Account link$")
    public void clickOnLink() {
        loginPage.clickOnLinkMyAccount();
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

