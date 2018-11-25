package Pages.UI;

import org.openqa.selenium.By;;
import Pages.AbstractObjectsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends AbstractObjectsPage {

    public LoginPage(WebDriver browserDriver) {
    }

    public void goTo(String url) {
        get(url);
    }

    public void loginAttempt(String username, String password) {
        waitForElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
        waitForElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        waitForElementToBeClickable(By.xpath("//input[@value='Login']")).click();
    }

    public void verifyLoginSucceeded(String user) {
        WebElement username = waitForElement(By.xpath("//div[contains(@class, 'current-user') and text()= '" + user + "']"));
        Assert.assertTrue(username.getText().contentEquals(user));
    }

    public void clickOnLinkWithText(String text) {
        waitForElementToBeClickable(By.xpath("//a[text()='" + text + "']")).click();
    }

    public void clickOnLinkMyAccount() {
        waitForElementToBeClickable(By.xpath("//span[text()='My Account']")).click();
    }

    public void verifyPageTitleIs(String title) {
        System.out.println(getTitle());
        Assert.assertTrue(getTitle().contains(title));
    }

}
