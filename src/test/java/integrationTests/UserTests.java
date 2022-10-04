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
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali R")
                .gender("male")
                .email(email)
                .status("active")
                .build();

        // 2. Act
        int id = usersClient.createUser(requestBody).getData().getId();

        // 3. Assert
        usersClient.getUser(id).assertUser(requestBody);
    }
}
