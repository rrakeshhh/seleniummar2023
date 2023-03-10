package Keywords;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeywords extends ValidationKeywords{
	
	public ApplicationKeywords() {
		String path  = System.getProperty("user.dir")+"//src//test//resources//env.properties";
		prop = new Properties();
		envProp = new Properties();
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
			String env=prop.getProperty("env")+".properties";
			path  = System.getProperty("user.dir")+"//src//test//resources//"+env;
			fs = new FileInputStream(path);
			envProp.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		softAssert = new SoftAssert();
		
	}
	
	public void login() {
		
	}
	
	public void selectDateFromCalendar(String date) {
		log("Selecting Date "+date);
		
		try {
			Date currentDate = new Date();
			Date dateToSel=new SimpleDateFormat("d-MM-yyyy").parse(date);
			String day=new SimpleDateFormat("d").format(dateToSel);
			String month=new SimpleDateFormat("MMMM").format(dateToSel);
			String year=new SimpleDateFormat("yyyy").format(dateToSel);
			String monthYearToBeSelected=month+" "+year;
			String monthYearDisplayed=getElement("monthyear_css").getText();
			
			while(!monthYearToBeSelected.equals(monthYearDisplayed)) {
				click("datebackButoon_xpath");
				monthYearDisplayed=getElement("monthyear_css").getText();
			}
			driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void verifyStockAdded() {
		
	}
	public void defaultLogin() {
		navigate("url");
		type("username_css", envProp.getProperty("admin_user_name"));
		type("password_xpath", envProp.getProperty("admin_password"));
		click("login_submit_id");
		waitForPageToLoad();
		wait(5);
		
	}
	
	public int findCurrentStockQuantity(String companyName) {
		log("Finding current stock quantity for "+ companyName);
		int row = getRowNumWithCellData("stocktable_css",companyName);
		if(row==-1) {
			log("Current Stock Quantity is 0 as Stock not present in list");
			return 0;
		}
		// table#stock > tbody > tr:nth-child(2) >td:nth-child(4)
		String quantity = driver.findElement(By.cssSelector(prop.getProperty("stocktable_css")+" > tr:nth-child("+row+") >td:nth-child(4)")).getText();
		log("Current stock Quantity "+quantity);
		return Integer.parseInt(quantity);
	}

	public void goToBuySell(String companyName) {
		log("Selecting the company row "+companyName );
		int row = getRowNumWithCellData("stocktable_css", companyName);
		if(row==-1) {
			log("Stock not present in list");
		}
		driver.findElement(By.cssSelector(prop.getProperty("stocktable_css")+" > tr:nth-child("+row+") >td:nth-child(1)")).click();
		driver.findElement(By.cssSelector(prop.getProperty("stocktable_css")+"  tr:nth-child("+row+") input.buySell" )).click();
		
	}

	public void goToTransactionHistory(String companyName) {
	    log("Selecting the company row "+companyName );
		int row = getRowNumWithCellData("stocktable_css", companyName);
		if(row==-1) {
			log("Stock not present in list");
			// report failure
		}
		driver.findElement(By.cssSelector(prop.getProperty("stocktable_css")+" > tr:nth-child("+row+") >td:nth-child(1)")).click();
		driver.findElement(By.cssSelector(prop.getProperty("stocktable_css")+"  tr:nth-child("+row+") input.equityTransaction" )).click();
		
	}


	
	public void setReport(ExtentTest test) {
		this.test=test;
	}


}