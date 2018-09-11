import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MasterPass {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.get("https://stage1.masterpass.com");
		driver.findElement(By.xpath("//a[@title='Sign up for Masterpass']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("pmidhun1728@gmail.com");
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//a[@class='ng-binding']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountNumber']")).sendKeys("4111 1111 1111 1111");
		driver.findElement(By.xpath("//input[@name='expirationDate']")).sendKeys("05/27");
		driver.findElement(By.xpath("//input[@name='securityCode']")).sendKeys("406");
        driver.findElement(By.xpath("//button[@name='continue']")).click();
        Thread.sleep(500L);
        
        driver.findElement(By.xpath("//*[@id=\"formly_9_input_name.first_0\"]")).sendKeys("Midhun");
		
	
	
	}

}
