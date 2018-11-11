package general;

import pages.*;
import org.openqa.selenium.WebDriver;

public class PageManager {

	public WebDriver driver;
	public HomePage home;
	public LoginPage login;

	public PageManager(WebDriver driver){
	    this.driver=driver;
	}
	
	public HomePage getHomePage(){
	    return (home==null)?home = new HomePage(driver):home;
	}

	public LoginPage getLoginPage(){
	    return (login==null)?login = new LoginPage(driver):login;
	}

}
