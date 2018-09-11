import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookXpath {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.webdriver", "C:\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.rediff.com/");
		/*driver.findElement(By.xpath("//*[@id='email']")).sendKeys("pmidhun31@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("8056284834");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();*/
		
		/*driver.findElement(By.cssSelector("input[name=email]")).sendKeys("pmidhun31@gmail.com");
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("8056284834");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();*/
		
		
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.xpath("//*[@id='login1']")).sendKeys("pmidhun1728@gmail.com");
		driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("8056284834");
		driver.findElement(By.xpath("//input[contains(@name,'proceed')]")).click();
		driver.close();

}
	}
