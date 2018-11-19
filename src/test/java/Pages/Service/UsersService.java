package Pages.Service;

import Pages.AbstractPageObjects;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class UsersService extends AbstractPageObjects {

    private WebDriver wb;
    private final String API = "/api/users";

    public UsersService(WebDriver wb) {
        this.wb = wb;
    }

    public boolean verifyUserExists(String user) {
         return (given().contentType(ContentType.JSON).when().get(baseURI
                 + API).then().body("user", hasItem(user)) != null) ? true : false;
    }

}
