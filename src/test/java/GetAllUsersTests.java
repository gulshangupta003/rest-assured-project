import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersTests {
    @Test
    public void shouldGetAllUsers() {
        // Arrange
        // Act
        // Assert

        given()
                .when()
                    .get("https://gorest.co.in/public/v2/users")
                .then()
                    .statusCode(200)
                    .body("", Matchers.hasSize(10))
                    .body("", Matchers.hasItem(Matchers.hasEntry("gender", "male")))
                    .log().body();
    }
}
