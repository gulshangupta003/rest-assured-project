import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser() {
        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali R\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenalir21@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        createUser(body)
                .then()
                    .log().body()

        // 3. Assert
                    .statusCode(201)
                    .body("id", Matchers.notNullValue())
                    .body("email", Matchers.equalTo("tenalir21@gmail.com"))
                    .body("name", Matchers.equalTo("Tenali R"));
    }

    @Test
    public void shouldCreateFemaleUser() {
        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Rishi K\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"rishik1@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        createUser(body)
                .then()
                    .log().body()

        // 3. Assert
                    .statusCode(201)
                    .body("id", Matchers.notNullValue())
                    .body("email", Matchers.equalTo("rishik1@gmail.com"));
    }

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 457a143dbd57bef631313eb0e02b0777a8d268c3ae52c43ea34aa4581d7e0ed5")
                .body(body)
                    .when()
                        .post("https://gorest.co.in/public/v2/users");
    }
}
