import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sun.rmi.runtime.NewThreadAction;
import org.openqa.selenium.ElementNotVisibleException;
import java.util.List;
import java.util.Set;

public class Abstract {
    WebDriver driver = new WebDriver() {
        public void get(String url) {

        }

        public String getCurrentUrl() {
            return null;
        }

        public String getTitle() {
            return null;
        }

        public List<WebElement> findElements(By by) {
            return null;
        }

        public WebElement findElement(By by) {
            return null;
        }

        public String getPageSource() {
            return null;
        }

        public void close() {

        }

        public void quit() {

        }

        public Set<String> getWindowHandles() {
            return null;
        }

        public String getWindowHandle() {
            return null;
        }

        public TargetLocator switchTo() {
            return null;
        }

        public Navigation navigate() {
            return null;
        }

        public Options manage() {
            return null;
        }
    };

    //@Test
    public void testGoogleSearch() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");
        //Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
         // Let the user actually see something!
        driver.quit();
    }
    public void test(){
        driver.findElements(By.xpath("//div[@class='test']"));

    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;

    }
}


