import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;


public class CreateUserTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser() {
        // 1. Arrange

        String name = "Tenali R";
        String gender = "male";
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // 2. Act
        usersClient.createUser(requestBody)
                    .then()
                        .log().body()

        // 3. Assert
                        .statusCode(201)
                        .body("data.id", Matchers.notNullValue())
                        .body("data.email", Matchers.equalTo(email))
                        .body("data.name", Matchers.equalTo("Tenali R"));
    }

    @Test
    public void shouldCreateFemaleUser() {
        // 1. Arrange
        String name = "Rishi K";
        String gender = "female";
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // 2. Act
        usersClient.createUser(requestBody)
                .then()
                    .log().body()

        // 3. Assert
                    .statusCode(201)
                    .body("data.id", Matchers.notNullValue())
                    .body("data.email", Matchers.equalTo(email));
    }
}
