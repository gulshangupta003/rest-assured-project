import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import static org.testng.Assert.*;

public class CreateUserNegativeTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail() {
        // 1. Arrange

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali Ramakrishna")
                .gender("male")
                .email("tenalirgmail.com")
                .status("active")
                .build();

        // 2. Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

        // 3. Assert
        assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("email", "is invalid");
    }

    @Test
    public void shouldNotAllowToCreateUserWithBlankGenderAndStatus() {
        // 1. Arrange
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali Ramakrishna")
                .gender("")
                .email("tenalir3@gmail.com")
                .status("")
                .build();

        // 2. Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

        // 3. Assert
        assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("gender", "can't be blank, can be male of female");
        errorResponse.assertHasError("status", "can't be blank");
    }
}
