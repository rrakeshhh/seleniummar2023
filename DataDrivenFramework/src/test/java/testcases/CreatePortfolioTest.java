package testcases;

import org.testng.annotations.Test;

import Keywords.ApplicationKeywords;

public class CreatePortfolioTest {

	@Test
	public void createPortFolioTest() {
		// no webdriver code
		// login
		// create 
		// verify
		
		//GenericKeywords  gKeywords = new GenericKeywords();
		//ValidationKeywords vKeywords = new ValidationKeywords();
		ApplicationKeywords app = new ApplicationKeywords();
	
		
		app.openBrowser("Chrome");
		app.navigate("url");
		app.type("username_css", "m.rakesh2911@gmail.com");
		app.type("password_xpath", "Rakesh2911");
		app.validateElementPresent("login_submit_id");
		app.click("login_submit_id");
		app.validateLogin();
		// app.selectDateFromCalendar();
		
		
		
		
		
		
		
		
	}
	
}
