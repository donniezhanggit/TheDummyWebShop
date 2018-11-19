package FrameworkSetup;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestApi {

    public static RequestSpecification Request;

    public RestApi() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();
        Request = io.restassured.RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> getRequestWithParams(String url, Map<String, String> pathParams)  {
        Request.pathParams(pathParams);
        return Request.get(url);
    }

    public static ResponseOptions<Response> getUrl(String url) {
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> getRequestWithAuthToken(String url, String token) {
        try {
            Request.header(new Header("Authorization", "Bearer " + token));
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> putRequestWithBodyAndParams(String url, Map<String, String> body,
                                                                        Map<String, String> pathParams) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.put(url);
    }

    public ResponseOptions<Response> getRequestWithQueryParams(String url, String queryParams) {
        try {
            Request.queryParam(queryParams);
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> postRequestWithBodyAndParams(String url, Map<String, String> pathParams,
                                                                         Map<String, String> body)  {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> postRequestWithBody(String url,Map<String, String> body)  {
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> deleteRequestWithParams(String url,Map<String, String> pathParams)  {
        Request.pathParams(pathParams);
        return Request.delete(url);
    }
}
