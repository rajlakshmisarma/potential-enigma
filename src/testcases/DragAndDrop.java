package testcases;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class DragAndDrop {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void dragdrop() throws InterruptedException
  {
	  try{
	  element = driver.findElement(By.linkText("Drag and Drop"));
	  element.click();
	  System.out.println("Before drag and drop: ");
	  WebElement source = driver.findElement(By.id("column-a"));
	  System.out.println("Header of the source element: ---->  " + source.getText());
	  WebElement destination = driver.findElement(By.id("column-b"));
	  System.out.println("Header of the destination element: ----> " + destination.getText());
	 
	  //perform drag and drop function
	Point sourceLoc = source.getLocation();
	 int sourcex = sourceLoc.getX();
	 int sourcey = sourceLoc.getY();
	 
	 Point destLoc = destination.getLocation();
	 int destx = destLoc.getX();
	 int desty = destLoc.getY();
	 
	 Robot robot = new Robot();
	 robot.mouseMove(sourcex, sourcey); //move mouse on the source co-ordinates
	 robot.mousePress(InputEvent.BUTTON1_MASK); //press left button of the mouse
	 robot.mouseMove(destx, desty); //move mouse to the destination co-ordinates
	 robot.mouseRelease(InputEvent.BUTTON1_MASK); //release the left button of mouse

	 Thread.sleep(3000);
	 System.out.println("After drag and drop event: ");
	 WebElement source1 = driver.findElement(By.id("column-a"));
	 System.out.println("Header of the source element: ---->  " + source1.getText());
	 WebElement destination1 = driver.findElement(By.id("column-b"));
	 System.out.println("Header of the destination element: ----> " + destination1.getText());
	  }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage());
	  }
  }
  
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
