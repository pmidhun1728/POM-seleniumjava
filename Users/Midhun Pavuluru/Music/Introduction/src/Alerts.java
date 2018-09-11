import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.webdriver", "C:\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	     driver.get("http://www.echoecho.com/javascript4.htm");
	     driver.findElement(By.xpath("//*[@value='alert box']")).click();
	     System.out.println(driver.switchTo().alert().getText());
	     driver.switchTo().alert().accept();
	    
		
		
	}

}
