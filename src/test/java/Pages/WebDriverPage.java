package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.Set;

public abstract class WebDriverPage implements WebDriver, JavascriptExecutor, HasCapabilities {
    private WebDriver driverProvider;

    public WebDriverPage(WebDriver driverProvider) {
        this.driverProvider = driverProvider;
    }

    protected WebDriver getDriverProvider() {
        return this.driverProvider;
    }

    protected Actions getActions() {
        return new Actions(this.driverProvider);
    }

    public void get(String url) {
        this.driverProvider.get(url);
    }

    public String getCurrentUrl() {
        return this.driverProvider.getCurrentUrl();
    }

    public String getTitle() {
        return this.driverProvider.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return this.driverProvider.findElements(by);
    }

    public WebElement findElement(By by) {
        return this.driverProvider.findElement(by);
    }

    public String getPageSource() {
        return this.driverProvider.getPageSource();
    }

    public void close() {
        this.driverProvider.close();
    }

    public void quit() {
        this.driverProvider.quit();
    }

    public Set<String> getWindowHandles() {
        return this.driverProvider.getWindowHandles();
    }

    public String getWindowHandle() {
        return this.driverProvider.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return this.driverProvider.switchTo();
    }

    public Navigation navigate() {
        return this.driverProvider.navigate();
    }

    public WebDriver.Options manage() {
        return this.driverProvider.manage();
    }

    public Object executeScript(String s, Object... args) {
        return ((JavascriptExecutor)this.driverProvider).executeScript(s, args);
    }

    public Object executeAsyncScript(String s, Object... args) {
        return ((JavascriptExecutor)this.driverProvider).executeAsyncScript(s, args);
    }

    public Capabilities getCapabilities() {
        return ((HasCapabilities)this.driverProvider).getCapabilities();
    }
}
