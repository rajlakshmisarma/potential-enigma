package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class DynamicLoading {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void dynamicLoading() throws InterruptedException //method to retrieve hidden elements
  {
	  element = driver.findElement(By.linkText("Dynamic Loading"));
		element.click();	
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		Thread.sleep(3000);
		System.out.println("Dynamically loaded elements page: ----> " + driver.findElement(By.tagName("h4")).getText());
		String script = "return document.getElementById('finish').innerHTML";
		String text = ((JavascriptExecutor) driver).executeScript(script).toString();
		System.out.println("Text which is hidden on the page: " + text);
		System.out.println("Clicking on the button to display the hidden text");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(10000);
		System.out.println("Text which is visible now on the page:  " + driver.findElement(By.id("finish")).getText());
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		Thread.sleep(3000);
		System.out.println();
		System.out.println("Dynamically loaded elements page: ----> " + driver.findElement(By.tagName("h4")).getText());
		System.out.println("Clicking on the button to display hidden text");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(10000);
		System.out.println("Text which is displayed after clicking on the button:  " + driver.findElement(By.id("finish")).getText());
		driver.navigate().back();
		Thread.sleep(3000);
}
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
