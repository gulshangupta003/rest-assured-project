import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static org.testng.Assert.*;


public class CreateUserTests {
    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateMaleUser() {
        // 1. Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("male").build();

        // 2. Act
        CreateUserResponse createUserResponse = usersService.createUser(requestBody);

        // 3. Assert
        createUserResponse.assertUser(requestBody);
    }

    @Test
    public void shouldCreateFemaleUser() {
        // 1. Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("female").build();

        // 2. Act
        CreateUserResponse createUserResponse = usersService.createUser(requestBody);

        // 3. Assert
        createUserResponse.assertUser(requestBody);
    }
}
