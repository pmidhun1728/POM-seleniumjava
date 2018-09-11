import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));  //Limiting web driver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			
			String clickontab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys( clickontab);
			Thread.sleep(5000L);
		}
			
		    Set<String> abc=driver.getWindowHandles();
		    Iterator<String> it=abc.iterator();
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}
		
	

}
