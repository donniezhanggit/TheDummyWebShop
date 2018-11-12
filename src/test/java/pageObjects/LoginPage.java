package pageObjects;

import frameworkSetup.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebDriverManager {

	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToFacebook() {
	  driver.navigate().to("https://www.facebook.com/");
	}

}
