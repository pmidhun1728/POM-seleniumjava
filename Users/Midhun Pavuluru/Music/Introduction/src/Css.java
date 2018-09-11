import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Midhun Pavuluru
 *
 */
public class Css {

	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.cssSelector("#username")).sendKeys("pmidhun1728@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("8056284834");
		driver.findElement(By.cssSelector("#Login")).click();
		driver.close();
		
	}

}
