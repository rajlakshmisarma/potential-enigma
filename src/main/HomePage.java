package main;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	
	private WebDriver driver;
	String baseURL = "https://the-internet.herokuapp.com/";
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	public String getURL() //getter method for base url
	{
		return baseURL;
	}
	public WebDriver setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test  //method to verify title of the page
	public void verifyTitle() {
		String title = driver.getTitle().toString();
		AssertJUnit.assertEquals("The Internet", title);
	}
	
	public void goToHomepage()
	{
		driver.navigate().back();
	}

	public void teardown()
	{
		driver.quit();
	}
	}

