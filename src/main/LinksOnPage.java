package main;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class LinksOnPage {

	public static List<WebElement> allPageLinks(WebDriver driver)  //method to get all page links in a list
	{
		List<WebElement> links = new ArrayList<WebElement>();
		List<WebElement> list = driver.findElements(By.tagName("a"));
		
		for(WebElement element: list)
		{
			if(element.getAttribute("href")!=null)
			{
				links.add(element);
			}
		}
		return links;
	}	
	public static String linkstatus(URL url) throws IOException //method to check if the links in the page are responsive or not
	{
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.connect();
		String response =  http.getResponseMessage();
		http.disconnect();
		return response;
	}
}
