import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExercise {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/18881/eng-vs-ind-2nd-odi-india-tour-of-england-2018");
		
		 WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-67 cb-scrd-lft-col html-refresh ng-isolate-scope']"));
		 int rowcount=table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
		    int count =table.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold'] div=nth-child(3)")).size();
		
		    
		    
		    for(int i=0;i<count;i++)
		    {
		    	System.out.println(table.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold'] div=nth-child(3)")).get(i).getText());
				
		    }
		    
	}

}
