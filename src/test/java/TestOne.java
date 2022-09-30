import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestOne {
    @Test
    public void shouldGetAllUsers() {
        // Arrange
        // Act
        // Assert

        given()
                .when()
                    .get("https://reqres.in/api/users")
                .then()
                    .statusCode(200)
                    .log().body();

        Assert.assertEquals(1, 1);
    }
}
