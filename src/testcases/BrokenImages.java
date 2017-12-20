package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.HomePage;

public class BrokenImages {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);

	@BeforeClass
	public void start()
	{
		driver = page.setup();
	}
	@Test
	public void brokenimageslink() //click on link - Broken Images -- and verify the images present
	{
		element = driver.findElement(By.linkText("Broken Images"));
		element.click();
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println();
		System.out.println("The images present on the page are:  ");
		for(WebElement img : images)
		{
			boolean ispresent = (boolean) ((JavascriptExecutor)driver) 
				.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", img);
			if(ispresent==false)
			{
				System.out.println("Image --" + img.getAttribute("src").toString() +  "  -->  is broken");
			}
			else{
				System.out.println("Image --" + img.getAttribute("src").toString() + "  -->  is properly displayed image");
			}
		}
}
	@AfterClass
	public void end()
	{
		page.goToHomepage();
		page.teardown();
	}
}
