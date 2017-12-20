package testcases;

import org.testng.annotations.Test;
import main.HomePage;
import org.testng.annotations.BeforeClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Checkboxes {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  
  @Test
  public void checkbox()  //method to verify checkboxes
  {
	 element = driver.findElement(By.linkText("Checkboxes"));
	element.click();
	List<WebElement> element = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
	System.out.println("Number of checkboxes present:  " + element.size());
	System.out.println(driver.findElement(By.tagName("form")).getText()); //print checkbox name on console
	for(WebElement e : element)
	{
		System.out.println(e.getText() + e.isSelected());
	}
  }
  @AfterClass
  public void afterClass() {
	  page.goToHomepage();
	  page.teardown();
  }
}
