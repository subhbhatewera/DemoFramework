package qaclickacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver ;
	
	By emailAddress = By.cssSelector("#user_email");
	By password = By.cssSelector("[type='password']");
	By login = By.cssSelector("[value='Log In']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getEmailAddress() {
		return driver.findElement(emailAddress);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(login);
	}

}
