package FrameworkSetup;

import Pages.Service.UsersService;
import Pages.UI.LoginPage;

public class PageManager {

    private DriverProvider browserDriver;
    private LoginPage loginPage;
    private UsersService usersService;

    public PageManager(DriverProvider browserDriver) {
        this.browserDriver = browserDriver;
    }

    public PageManager getPageManager(DriverProvider browserDriver) {
        return  new PageManager(this.browserDriver);
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(browserDriver.getDriver()) : loginPage;
    }

    public UsersService getUsersServicePage() {
        return (usersService == null) ? usersService = new UsersService(browserDriver.getDriver()) : usersService;
    }
}
