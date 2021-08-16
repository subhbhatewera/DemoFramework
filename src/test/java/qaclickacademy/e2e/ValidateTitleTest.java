package qaclickacademy.e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qaclickacademy.pages.LandingPage;
import resources.Base;

public class ValidateTitleTest extends Base{
	
	WebDriver driver;
	LandingPage landing;
	
	Logger log = LogManager.getLogger(ValidateTitleTest.class.getName());
	
	@BeforeClass
	public void initializeObjects() {
		log.debug("Initializing Webdriver");
		driver = initializeBroswser();
		log.info("WebDriver is initialized");
		landing = new LandingPage(driver);
	}
	
	@Test
	public void validateHeading() {
		log.debug("Reteriving title text");
		driver.get(prop.getProperty("url"));
		log.info("Title text reterived");
		Assert.assertEquals(landing.getHeading().getText(), "FEATURED COURSS");
	}
	
	@AfterTest
	public void tearDown() {
		log.debug("Terminating Webdriver");
		driver.quit();
		log.info("WebDriver terminated");
	}

}
