package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class FloatingMenu {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void floatingmenu() throws InterruptedException //method to test the menus items which are visible throughout the page
  {
	  element = driver.findElement(By.linkText("Floating Menu"));
		element.click();
		List<WebElement> menus = driver.findElements(By.tagName("a"));
		List<WebElement> newlist = new ArrayList<>();
		System.out.println("Menus present: ");
		int size = menus.size();
		for(int i=1; i<size; i++) //check the menu items visible on top of the page
		{
			if(menus.get(i).getText().equals(""))
			{
				menus.remove(i);
			}
			else{
				System.out.println(menus.get(i).getText().toString());
				newlist.add(menus.get(i));
			}
		}
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);"); //scroll vertically down the page
		Thread.sleep(3000);
		System.out.println("Are the menu items visible on the page after scrolling down: ");
		for(WebElement ele : newlist)
		{
			System.out.println(ele.getText().toString() + " ----> " + ele.isDisplayed());
		}
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
