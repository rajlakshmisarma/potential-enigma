package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.*;
import java.net.URL;
import java.util.List;

public class TestAllLinksOnPage {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
	@BeforeClass
	public void start()
	{
		driver = page.setup();
	}
	
	@Test  //method to verify whether all links of the page are active or not
	public void verifylinks() {
		List<WebElement> list = LinksOnPage.allPageLinks(driver);
		for(WebElement element: list)
		{
			String link = element.getAttribute("href");
			try{
			System.out.println("Link: " + link + " ---->  " + LinksOnPage.linkstatus (new URL(link))); 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Total number of links on the page; " + "-->" + list.size());
	}
	@AfterClass
	public void end() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}
