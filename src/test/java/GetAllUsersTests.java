import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.getAll.GetAllUsersResponse;

import static org.testng.Assert.*;


public class GetAllUsersTests {
    // 1. Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldGetAllUsers() {
        // 2. Act
        GetAllUsersResponse getAllUsersResponse = usersClient.getAllUsers();

        // 3. Assert
        assertEquals(getAllUsersResponse.getStatucCode(), 200);
        assertEquals(getAllUsersResponse.getDataList().size(), 10);
        assertTrue(getAllUsersResponse.hasMaleUser());
    }
}
