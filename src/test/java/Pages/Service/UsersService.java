package Pages.Service;

import Pages.AbstractObjectsPage;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class UsersService extends AbstractObjectsPage {

    private final String API = "/api/users";


    public boolean verifyUserExists(String user) {
         return (given().contentType(ContentType.JSON).when().get(baseURI
                 + API).then().body("user", hasItem(user)) != null) ? true : false;

    }

}
