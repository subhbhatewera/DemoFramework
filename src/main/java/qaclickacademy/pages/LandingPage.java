package qaclickacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;	
	
	private By login = By.xpath("//a //span[text()='Login']");
	
	private By heading = By.xpath("//div[@class='text-center']/h2");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getHeading() {
		return driver.findElement(heading);
	}

}
