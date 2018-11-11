package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import io.cucumber.datatable.*;
import org.openqa.selenium.By;

import java.util.*;
import java.lang.*;
import static java.lang.String.*;

public class stepDefinitions {

    @Given("I have a cucumber step")
    public void i_have_a_cucumber_step() throws Throwable {
        System.out.println("Step definition exact match");
    }

    @Given("^I have (\\d+) (.*) in my basket$")
    public void i_have_in_my_basket(int number, String veg) throws Throwable {
        System.out.println(format("I have {0} {1} in my basket", number, veg));
    }

    @Given("^I have a (?:tasty|nasty|rusty) cucumber step$")
    public void i_have_a_X_cucumber_step() throws Throwable {
        System.out.println("Step definition with a non-capturing group");
    }

    @Given("^There (?:is|are) (\\d+) (?:cats?|ox|oxen) fed by (\\d+) (?:persons?|people)$")
    public void animals_fed_by_people(int animals, int persons) throws Throwable {
        System.out.println(
                format("{0} animal(s) fed by {1} person(s)", animals, persons));
    }

    @Given ("^I have the following order$")
    public void i_have_the_following_order (DataTable table) throws Throwable {
        for (Map<Object, Object> map : table.asMaps(String.class, String.class)) {
            Object vegetable = map.get("vegetable");
            Object amount = map.get("amount");
            Object cost = map.get("cost");
            System.out.println(
                    format("Order of {0} {1}s at the cost of {2}",
                            amount, vegetable, cost));
        }
    }

    @When("I click on the button with the label")
    public void clickOnButtonLabelled() {
        By locator = By.xpath("//*[@class='test']//text()='Go'");

    }

    @Given("^there are (\\d+) coffees left in the machine$")
    public void thereAreCoffeesLeftInTheMachine(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I have deposited (\\d+)/$$")
    public void iHaveDeposited$(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should be served a coffee$")
    public void iShouldBeServedACoffee() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I press the coffee button$")
    public void iPressTheCoffeeButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}


