package FrameworkSetup;


public class TestContext {
    public DriverProvider browserDriver;
    public PageManager pageManager;

    public TestContext() {
        browserDriver = new DriverProvider();
        pageManager = new PageManager(browserDriver);
    }

    public DriverProvider getDriver() {
        return browserDriver;
    }

    public void quitDriver() {
        browserDriver.getDriver().quit();
    }

    public PageManager getPageManager() {
        return pageManager;
    }

    //NAVIGATION MENU method or generic objects of the application

}