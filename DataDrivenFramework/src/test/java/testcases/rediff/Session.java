package testcases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.BaseTest;

public class Session extends BaseTest{
	
	@Test
	public void doLogin(ITestContext context) {
		//test.log(Status.INFO, "Logging In");
		app.log("Logging In");
		app.openBrowser("Chrome");
		app.navigate("url");
		// int i = 100/0;
		app.type("username_css", "m.rakesh2911@gmail.com");
		// failure
		//app.reportFailure("First Failure - Non Critical",false);
		app.type("password_xpath", "Rakesh@2911");
		app.validateElementPresent("login_submit_id");
		app.click("login_submit_id");	   
	}
	
	@Test
	public void doLogout() {
		test.log(Status.INFO, "Logging out");
	}

}
