package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class Hovers {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
    public void hovers() throws InterruptedException //method to get the text present for each element which appears on mouse over
  {
	  element = driver.findElement(By.linkText("Hovers"));
	  element.click();
	 List<WebElement> element = driver.findElements(By.className("figure"));
	 Actions action = new Actions(driver);
	  for(WebElement ele : element)
	  {
		  System.out.println("Image: " + ele.findElement(By.tagName("img")).getAttribute("src"));
		  action.moveToElement(ele).build().perform();
		  Thread.sleep(3000);
		  System.out.println("Text present on mouse over: ----> " + ele.findElement(By.tagName("h5")).getText());
	  }
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
