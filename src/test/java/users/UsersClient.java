package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());

        return createUserResponse;
    }

    public static Response create(CreateUserRequestBody body) {
        Response response =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer 457a143dbd57bef631313eb0e02b0777a8d268c3ae52c43ea34aa4581d7e0ed5")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v1/users");

        response.then()
                    .log().body();

        return response;
    }

    public static Response getAllUsers() {
        return
                given()
                    .when()
                        .get("https://gorest.co.in/public/v1/users");
    }
}
