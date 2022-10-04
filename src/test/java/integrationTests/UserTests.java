package integrationTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;


public class UserTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateAndGetUser() {
        // 1. Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();

        // 2. Act
        int id = usersClient.createUser(requestBody).getData().getId();

        // 3. Assert
        usersClient.getUser(id).assertUser(requestBody);
    }
}
