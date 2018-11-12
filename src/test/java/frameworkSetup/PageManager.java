package frameworkSetup;

import pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageManager {

	public WebDriver driver;
	public LoginPage login;

	public PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		return (login == null) ? login = new LoginPage(driver) : login;
	}
}
