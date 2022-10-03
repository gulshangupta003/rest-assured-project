import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail() {
        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenalir22@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

                // 3. Assert
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("", Matchers.hasItem(Matchers.hasEntry("message", "has already been taken")));
    }
}
