import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static org.testng.Assert.*;


public class CreateUserTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser() {
        // 1. Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali R")
                .gender("male")
                .email(email)
                .status("active")
                .build();

        // 2. Act
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);


        // 3. Assert

        assertEquals(createUserResponse.getStatusCode(), 201);
        assertNotNull(createUserResponse.getData().getId());
        assertEquals(createUserResponse.getData().getEmail(), requestBody.getEmail());
    }

    @Test
    public void shouldCreateFemaleUser() {
        // 1. Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Rishi K")
                .gender("female")
                .email(email)
                .status("active")
                .build();

        // 2. Act
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);

        // 3. Assert
        assertEquals(createUserResponse.getStatusCode(), 201);
        assertNotNull(createUserResponse.getData().getId());
        assertEquals(createUserResponse.getData().getEmail(), requestBody.getEmail());
    }
}
