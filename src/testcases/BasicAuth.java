package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

	public class BasicAuth {
	WebDriver driver;
	WebElement element;
	HomePage page = new  HomePage(driver);
	@BeforeClass
	public void start()
	{
		driver = page.setup();
	}

	@Test 
	public void basicAuthlink() //click on link - Basic Auth -  and login, verify logged-in text
	{
		element = driver.findElement(By.linkText("Basic Auth"));
		//element.click();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println("Basic Authentication: " + driver.findElement(By.tagName("p")).getText().toString());
	}
	@AfterClass
	public void end()
	{
		page.goToHomepage();
		page.teardown();
	}
}