package BaseURL;

import BaseURL.URL;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseHttpClient {

    private RequestSpecification baseRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(URL.HOST)
                .addHeader("Content-type", "application/json")
                .setRelaxedHTTPSValidation()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }

    protected Response doGetRequest(String path) {
        return given()
                .spec(baseRequestSpec())
                .get(path)
                .thenReturn();
    }

    protected Response doGetRequest(String path, Integer id) {
        return given()
                .spec(baseRequestSpec())
                .queryParam("courierId", id)
                .get(path)
                .thenReturn();
    }

    protected Response doGetRequest(String path, Integer id, Object param) {
        return given()
                .spec(baseRequestSpec())
                .queryParam("courierId", id)
                .queryParam("nearestStation", param)
                .get(path)
                .thenReturn();
    }

    protected Response doGetRequest(String path,Integer param1, Integer param2) {
        return given()
                .spec(baseRequestSpec())
                .queryParam("limit", param1)
                .queryParam("page", param2)
                .get(path)
                .thenReturn();
    }

    protected Response doGetRequest(String path, Integer param1, Integer param2, Object param3) {
        return given()
                .spec(baseRequestSpec())
                .queryParam("limit", param1)
                .queryParam("page", param2)
                .queryParam("nearestStation", param3)
                .get(path)
                .thenReturn();
    }

    protected Response doGetRequest(String path, Object body) {
        return given()
                .spec(baseRequestSpec())
                .body(body)
                .get(path)
                .thenReturn();
    }

    protected Response doPostRequest(String path, Object body) {
        return given()
                .spec(baseRequestSpec())
                .body(body)
                .post(path)
                .thenReturn();
    }

    protected Response doDeleteRequest(String path, Integer id) {
        return given()
                .spec(baseRequestSpec())
                .delete(path + "/" + id)
                .thenReturn();
    }

    protected Response doDeleteRequest(String path) {
        return given()
                .spec(baseRequestSpec())
                .delete(path + "/")
                .thenReturn();
    }
}
