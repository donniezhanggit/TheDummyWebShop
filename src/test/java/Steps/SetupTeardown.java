package Steps;

import Pages.UI.LoginPage;
import FrameworkSetup.DriverProvider;
import FrameworkSetup.RestApi;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class SetupTeardown {
    private LoginPage login;
    private String separator = System.getProperty("file.separator");
    private final String SCRENSHOOT_PATH = System.getProperty("user.dir")
            + separator + "target" + separator + "screnshoots" + separator;

    private RestApi restApi;
    private DriverProvider browserDriver;

    public SetupTeardown(DriverProvider browserDriver) {
        this.browserDriver = browserDriver;
        restApi = new RestApi();
        login = new LoginPage(browserDriver.getDriver());
    }

    @Before
    public void setup(Scenario scenario) {
        System.out.println("************** " + scenario.getName() + " ************** ");
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println(" ");
        System.out.println("************* Ending Scenario: " + scenario.getName() + " **************");
        if (scenario.isFailed()) {
            String fileName = ("screenshotOfFailedScenario-" + scenario.getName() + ".png");
            browserDriver.takeScrenshoot(SCRENSHOOT_PATH + fileName);
            browserDriver.getDriver().quit();
        }
        browserDriver.getDriver().quit();
    }
}
