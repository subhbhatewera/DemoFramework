package qaclickacademy.e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qaclickacademy.pages.LandingPage;
import qaclickacademy.pages.LoginPage;
import resources.Base;

public class LoginTest extends Base{

	WebDriver driver;
	LandingPage landing ;
	LoginPage login;
	
	Logger log = LogManager.getLogger(LoginTest.class.getName());

	@BeforeClass
	public void initializeObjects() {	
		log.debug("Initializing Webdriver");
		driver = initializeBroswser();
		log.info("WebDriver is initialized");
		landing = new LandingPage(driver);
		login = new LoginPage(driver);		
	}

	@Test(dataProvider = "getLoginData")
	public void homePageNavigation(String email, String password) {			
		log.debug("Navigating to landing page");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to landing page");
		log.debug("Clicking on Login link");
		landing.getLogin().click();
		log.info("Clicked on Login link");
		log.debug("Entering data in Email field");
		login.getEmailAddress().sendKeys(email);
		log.info("Data entered in Email field");
		log.debug("Entering data in Password field");
		login.getPassword().sendKeys(password);
		log.info("Entered data in Password field");
		log.debug("Clicking on Login button");
		login.getLoginBtn().click();
		log.info("Clicked on Login button");
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = new Object[2][2];		
		data[0][0] = "login@mail.com";
		data[0][1]= "Welcome@321";
		data[1][0] = "singin@mail.com";
		data[1][1] = "Welcome@456";		
		return data ;
	}
	
	@AfterTest
	public void tearDown() {
		log.debug("Terminating Webdriver");
		driver.quit();
		log.info("WebDriver terminated");
	}

}
