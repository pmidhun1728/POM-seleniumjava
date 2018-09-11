import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormMethods {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.webdriver", "C:\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.makemytrip.com");
		System.out.println("Before selecting multicity");
		System.out.println(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")));
		driver.findElement(By.xpath("//*[@id='trip_type_roundtrip']")).isDisplayed();
		System.out.println("After selecting multicity");
		driver.findElement(By.xpath("//*[@id=\"trip_type_multicity\"]")).isSelected();
		
		
	}
}