package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public abstract class AbstractObjectsPage extends WebDriverPage {

    public FluentWait<WebDriver> wait;

    public AbstractObjectsPage(WebDriver driver) {
        super(driver);
    }


    public void sendTextToField(String placeholder, String text) {
        By fieldLocator = By.xpath("//input[@placeholder ='" + placeholder + "']");
        waitForElement(fieldLocator).click();
        findElement(fieldLocator).clear();
        findElement(fieldLocator).sendKeys(text);
    }

    public WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.visibilityOf(findElement(by)));
    }

    public WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitUntilElementAppears(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }


}




