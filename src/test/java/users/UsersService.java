package users;

import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.get.GetUsersResponse;
import users.getAll.GetAllUsersResponse;

public class UsersService {
    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = new UsersClient().create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());

        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body) {
        Response response = new UsersClient().create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());

        return errorResponse;
    }


    public GetUsersResponse getUser(int id) {
        Response response = new UsersClient().get(id);
        response
                .then()
                .log().body();

        int statusCode = response.statusCode();

        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        getUsersResponse.setStatusCode(statusCode);

        return getUsersResponse;
    }

    public static GetAllUsersResponse getAllUsers() {
        Response response = new UsersClient().getAll();

        int statusCode = response.statusCode();

        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatucCode(statusCode);

        return getAllUsersResponse;
    }
}
