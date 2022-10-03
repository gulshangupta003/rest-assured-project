package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 457a143dbd57bef631313eb0e02b0777a8d268c3ae52c43ea34aa4581d7e0ed5")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }
}
