package hooks;

import apiClasses.UserApi;
import io.cucumber.java.Before;

public class SetupAuth {
	
	@Before
	public void checkAuth()
	{
		UserApi objUser = new UserApi();
		int status_code=objUser.checkGetallUser();
		if(status_code==200)
		{
			  System.out.println("Authentication successful.");
		}
		else
		{
			throw new RuntimeException("Basic Auth failed. Stopping the tests.");
		}
	}

}
