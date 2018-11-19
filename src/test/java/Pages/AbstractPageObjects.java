package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public abstract class AbstractPageObjects {

    public WebDriver wb;
    private FluentWait<WebDriver> wait;

    public String testAbstractMethod() {
        return "A B S T R A C T";
    }

    public void sendTextToField(String placeholder, String text) {
        By fieldLocator = By.xpath("//input[@placeholder ='" + placeholder + "']");
        waitForElement(fieldLocator).click();
        findElementBy(fieldLocator).clear();
        findElementBy(fieldLocator).sendKeys(text);
    }

    public WebElement findElementBy(By by) {
        return wb.findElement(by);
    }

    public WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.visibilityOf(findElementBy(by)));
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
