package testcases;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class ExitIntent {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	JavascriptExecutor js;
	WebDriverWait wait;
	@BeforeClass
	public void start()
	{
		driver = page.setup();
	}
  @Test
  public void exitIntent() throws AWTException
  {
	  element = driver.findElement(By.linkText("Exit Intent"));
		element.click();
		System.out.println("Exit intent:  " + driver.findElement(By.className("example")).findElement(By.tagName("p")).getText());
		Robot robot = new Robot();
		Point coordinates = driver.findElement(By.xpath("//*[@id='content']/div[1]")).getLocation();
		int x = coordinates.getX();
		int y = coordinates.getY();
		robot.mouseMove(x, y+2000);
		robot.delay(2000);
		wait = new WebDriverWait(driver, 10);
		WebElement window = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal")));
		String title=window.findElement(By.tagName("h3")).getText();
		Assert.assertEquals(title, "THIS IS A MODAL WINDOW");
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
