package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.rediffsearch;

public class SearchApplication {

	
	@Test
	
	public void Search()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.rediff.com/movies/report/i-have-never-been-happier-making-someone-else-cry/20180728.htm");
        rediffsearch rs=new rediffsearch(driver);
        rs.search().sendKeys("Hello");
        
	}
	
	
}
