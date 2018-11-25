package Pages;


import org.openqa.selenium.By;

public abstract class AbstractObjectsPage extends WebdriverPage {

    public void sendTextToField(String placeholder, String text) {
        By fieldLocator = By.xpath("//input[@placeholder ='" + placeholder + "']");
        waitForElement(fieldLocator).click();
        findElement(fieldLocator).clear();
        findElement(fieldLocator).sendKeys(text);
    }


}




