import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser() {
        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali R\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenalir23@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        new UsersClient().createUser(body)
                .then()
                    .log().body()

        // 3. Assert
                    .statusCode(201)
                    .body("id", Matchers.notNullValue())
                    .body("email", Matchers.equalTo("tenalir23@gmail.com"))
                    .body("name", Matchers.equalTo("Tenali R"));
    }

    @Test
    public void shouldCreateFemaleUser() {
        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Rishi K\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"rishik3@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        new UsersClient().createUser(body)
                .then()
                    .log().body()

        // 3. Assert
                    .statusCode(201)
                    .body("id", Matchers.notNullValue())
                    .body("email", Matchers.equalTo("rishik3@gmail.com"));
    }
}
