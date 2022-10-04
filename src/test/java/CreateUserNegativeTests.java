import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

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
                .email("tenalir@gmail.com")
                .status("active")
                .build();

        // 2. Act
        usersClient.createUser(requestBody)
                .then()
                    .log().body()

        // 3. Assert
                    .statusCode(422)
                    .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                    .body("data", Matchers.hasItem(Matchers.hasEntry("message", "has already been taken")));
    }
}
