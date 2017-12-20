package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class DropDown {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void dropdown() throws InterruptedException
  {
	  element = driver.findElement(By.linkText("Dropdown"));
		element.click();
		element = driver.findElement(By.id("dropdown"));
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();
		System.out.println("Total number of options available in the list: " + list.size());
		for(WebElement value : list)
		{
			System.out.println(value.getText());
  }
		System.out.println("Value currently selected: --> " + select.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		select.selectByVisibleText("Option 2");
		System.out.println("Value selected now: --> " + select.getFirstSelectedOption().getText());
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
