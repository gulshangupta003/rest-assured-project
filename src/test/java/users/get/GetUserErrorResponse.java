package users.get;

import lombok.Getter;
import lombok.Setter;
import users.create.CreateUserRequestBody;

import static org.testng.Assert.assertEquals;

@Getter
public class GetUserErrorResponse {

	@Setter
	private int statusCode;

	private Data data;
	private String meta;

	public void assertError(int expectedStatusCode, String expectedMessage) {
		assertEquals(statusCode, expectedStatusCode);
		assertEquals(data.message, expectedMessage);
	}

	@Getter
	public static class Data{
		private String message;
	}
}