package Pages.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Pages.AbstractPageObjects;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends AbstractPageObjects {

    private WebDriver wb;

    public LoginPage(WebDriver wb) {
        this.wb = wb;
    }

    public void goTo(String url) {
        wb.get(url);
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

    public void verifyPageTitleIs(String title) {
        Assert.assertTrue(wb.getTitle().contains(title));
    }

}
