package general;

public class TestContext {

  private WebDriverManager webDriverManager;
  private PageManager page;

  public TestContext(){
    webDriverManager = new WebDriverManager();
    page = new PageManager(webDriverManager.getDriver());
  }

  public WebDriverManager getWebDriverManager(){
    return webDriverManager;
  }

  public PageManager getPage(){
    return page;
  }

}
