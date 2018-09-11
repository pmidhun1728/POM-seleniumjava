import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.webdriver", "C:\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	     driver.get("http://www.echoecho.com/htmlforms10.htm");
	     //driver.findElement(By.xpath("//*[@value='Milk']")).click();
	     
	     
	     int count=driver.findElements(By.xpath("//*[@name='group1']")).size();
	     
	    for(int i=0;i<count;i++)
	    {
	        driver.findElements(By.xpath("//*[@name='group1']")).get(i).getAttribute("1");
	        
	        
	   
	       // if(text.equals"cheese")
	        {
	        	driver.findElements(By.xpath("//*[@name='group1']")).get(i).click();
	        }
	        
	        
	}
	
	}

}
