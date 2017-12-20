package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class ABTesting {
		WebDriver driver;
		WebElement element;
		HomePage page = new  HomePage(driver);
	@BeforeClass
	public void start()
	{
		driver = page.setup();
	}
	@Test
	public void abtestinglink() //click on link - A/B Testing -  and print the text present
	{	
		element = driver.findElement(By.linkText("A/B Testing"));
		element.click();
		element = driver.findElement(By.tagName("p"));
		String text = element.getText().toString();
		System.out.println("Text present for A/B Testing description: ");
		System.out.println(text);	//print to console	
	}
	@AfterClass
	public void end()
	{
		page.goToHomepage();
		page.teardown();
	}
}
