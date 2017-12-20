package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class Editor {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
  public void editor() throws InterruptedException //editor inside a frame
  {
	  element = driver.findElement(By.linkText("WYSIWYG Editor"));
	  element.click();
	  driver.switchTo().frame("mce_0_ifr");
	  WebElement editor = driver.findElement(By.tagName("body"));
	  System.out.println("Content present in the editor: " + editor.getText());
	  editor.clear();
	  Thread.sleep(2000);
	 ((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>Enter your Text</h1>Hello World!'" , editor);
	 System.out.println("Content present after entering: " + editor.getText());
	 driver.switchTo().defaultContent();
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
