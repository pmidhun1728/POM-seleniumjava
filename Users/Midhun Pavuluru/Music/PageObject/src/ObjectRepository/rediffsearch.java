package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class rediffsearch {
	
	
	
	
	WebDriver driver;
	public rediffsearch(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	By searchbox=By.xpath("//input[@id='srchword']");
	
	
	
	
	public WebElement search() {
		
		return driver.findElement(searchbox);
	}



}
