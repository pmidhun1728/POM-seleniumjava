import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeDemo {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.cumberland.edu/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		 
		WebElement footerdriver=driver.findElement(By.className("footer"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		WebElement columndriver=footerdriver.findElement(By.xpath("//div/div/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		for(int i=0;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinktab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
		    Thread.sleep(500L);
		}
		
		     Set<String> str=driver.getWindowHandles();
		     Iterator<String> it=str.iterator();
		     
		     while(it.hasNext())
		     {
		    	 driver.switchTo().window(it.next());
		    	 System.out.println(driver.getTitle());
		     }
		     
		     
		
		
	}

}
