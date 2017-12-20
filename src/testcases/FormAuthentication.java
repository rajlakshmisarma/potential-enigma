package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class FormAuthentication {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void formvalidation1() throws InterruptedException //method to check valid credentials in the authentication
  {
	  element = driver.findElement(By.linkText("Form Authentication"));
		element.click();
		System.out.println("Test for valid credentials");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		Thread.sleep(2000);
		driver.findElement(By.tagName("i")).click();
		String text  = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(text, "Secure Area");
		System.out.println(driver.findElement(By.tagName("h4")).getText());
		Thread.sleep(2000);
		driver.findElement(By.className("icon-signout")).click();
		System.out.println(driver.findElement(By.id("flash")).getText().toString().trim());
  }
  @Test
  public void formvalidation2() throws InterruptedException //method to check invalid credentials in the authentication
  {
	  System.out.println("Test for invalid credentails");
	  driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword"); //invalid password
		Thread.sleep(2000);
		driver.findElement(By.tagName("i")).click();
		String text = driver.findElement(By.id("flash")).getText().toString().trim().replaceAll("\\P{L}", "");
		System.out.println(text);
		String expectedtext = "Yourpasswordisinvalid";
		Assert.assertEquals(text,expectedtext);	
  }
 @AfterClass
  public void end()
  {
	  driver.get(page.getURL());
	  page.teardown();
  }
}
