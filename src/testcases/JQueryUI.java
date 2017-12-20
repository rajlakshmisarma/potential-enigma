package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class JQueryUI {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
  public void uiMenus() throws InterruptedException //method for capturing JQuery UI menus
  {
	  element = driver.findElement(By.linkText("JQuery UI Menus"));
	  element.click();
	  String title = driver.findElement(By.tagName("h3")).getText();
	  Assert.assertEquals(title, "JQueryUI - Menu");
	  List<WebElement> list1 = driver.findElements(By.tagName("a"));
	  List<WebElement> list2 = new ArrayList<WebElement>();
	  Actions action = new Actions(driver);
	  for (WebElement menus : list1)
	  {
		 if(menus.getText().contains("Disabled") || menus.getText().contains("Enabled"))
		  {
			  list2.add(menus);
		  }
	  }
	  int size = list2.size();
	  for(int i=0; i<size; i++)
	  {
		  if(list2.get(i).getText().contains("Enabled")) //menu option has submenus under it
		  {
			  action.moveToElement(list2.get(i)).build().perform();
			  Thread.sleep(2000);
			  action.moveToElement(driver.findElement(By.linkText("Downloads"))).build().perform();
			  Thread.sleep(2000);
			  driver.findElement(By.linkText("Back to JQuery UI")).click();
			  Thread.sleep(2000);
			 String title1 =  driver.findElement(By.tagName("h3")).getText();
			 Assert.assertEquals(title1, "JQuery UI");
			 System.out.println("Text present: " + driver.findElement(By.tagName("p")).getText());
			 driver.findElement(By.linkText("Menu")).click();
			 Assert.assertEquals(title, "JQueryUI - Menu");
		  }
		  else{
			  continue;
		  }
	  }
  }
  @AfterClass
  public void end()
  {
	  driver.get(page.getURL());
	  page.teardown();
  }
}
