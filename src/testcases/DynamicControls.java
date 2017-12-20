package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.HomePage;

public class DynamicControls {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void dymanicControls() throws InterruptedException
  {
	 element = driver.findElement(By.linkText("Dynamic Controls"));
		element.click();	
		System.out.println("Element present on page:   " + driver.findElement(By.id("checkbox")).getText());
		System.out.println("Clicking on the checkbox");
		driver.findElement(By.id("checkbox")).click();
		System.out.println("Is the checkbox displayed:   " + driver.findElement(By.id("checkbox")).isDisplayed());
		element = driver.findElement(By.id("btn"));
		System.out.println("Button currently on page:   " + element .getText());
		System.out.println("Clicking on the button");
		element.click();
		Thread.sleep(4000);
		System.out.println("Message after clicking on the button:   " + driver.findElement(By.id("message")).getText());
		System.out.println("Button present now:   " + driver.findElement(By.id("btn")).getText());
		Thread.sleep(3000);
		System.out.println("Clicking on the button again");
		driver.findElement(By.id("btn")).click();
		Thread.sleep(4000);
		System.out.println("After clicking on Add button:  " +  driver.findElement(By.id("message")).getText());
		System.out.println("Verifying if checkbox has been added again:  " + driver.findElement(By.id("checkbox")).isDisplayed());
  }
}
