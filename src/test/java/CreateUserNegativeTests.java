import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import static org.testng.Assert.*;

public class CreateUserNegativeTests {
    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail() {
        // 1. Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().email("tenalirgmail.com").build();

        // 2. Act
        CreateUserErrorResponse errorResponse = usersService.createUserExpectingError(requestBody);

        // 3. Assert
        assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("email", "is invalid");
    }

    @Test
    public void shouldNotAllowToCreateUserWithBlankGenderAndStatus() {
        // 1. Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("").status("").build();

        // 2. Act
        CreateUserErrorResponse errorResponse = usersService.createUserExpectingError(requestBody);

        // 3. Assert
        assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("gender", "can't be blank, can be male of female");
        errorResponse.assertHasError("status", "can't be blank");
    }
}
