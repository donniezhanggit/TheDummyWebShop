package Steps;


import FrameworkSetup.RestApi;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import FrameworkSetup.TestContext;


public class SetupTeardown {

    private String separator = System.getProperty("file.separator");

    private final String SCRENSHOOT_PATH = System.getProperty("user.dir")
            + separator + "target" + separator + "screnshoots" + separator;

    private RestApi restApi;
    private TestContext testContext;

    public SetupTeardown(TestContext testContext) {
        this.testContext = testContext;
        restApi = new RestApi();
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
            testContext.getDriver().takeScrenshoot(SCRENSHOOT_PATH + fileName);
            testContext.quitDriver();
        }
        testContext.quitDriver();
    }
}
