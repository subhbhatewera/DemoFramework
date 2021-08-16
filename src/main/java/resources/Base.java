package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	String path = System.getProperty("user.dir");
	public Properties prop ;
	public WebDriver driver ;

	public WebDriver initializeBroswser() {
		try {
			FileInputStream fis = new FileInputStream(path+"/config.properties");
			prop = new Properties();
			prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		/*
		 * We are passing browserName via maven instead of property file, when we use
		 * System.getProperty("browser") method then it looks for the data from maven
		 * which we can pass while running the test as mvn test -Dbrowser=chrome
		 */
		 //String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", path+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver ;
	}

	public String getScreenshot(String testName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = path+"/reports/screenshots/"+testName+".png";
		try {
			FileUtils.copyFile(sourceFile, new File(destinationFile));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return destinationFile ;
	}

}
