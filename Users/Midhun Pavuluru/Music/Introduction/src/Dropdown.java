import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.webdriver", "C:\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spirit.com/");
		Select s=new Select(driver.findElement(By.id("paxAdults")));
	    s.selectByValue("2");
	    
	    
	    /*driver.findElement(By.cssSelector("#departCityCodeSelect")).click();
	    driver.findElement(By.xpath("//*[@value='CAK']")).click();
	    driver.findElement(By.xpath("(//*[@value='SAN'])[2]")).click();*/
	    driver.findElement(By.xpath("//*[@id='journeyOneWay']")).click();
	    
		
	}

}
