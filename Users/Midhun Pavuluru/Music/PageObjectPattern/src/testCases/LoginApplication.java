package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Objectrepository.RediffLoginPage;

public class LoginApplication {

	
	
	@Test
	public void Login() {
	 
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		RediffLoginPage rd = new RediffLoginPage(driver);
		rd.Emailid().sendKeys("pmidhun1728@gmail.com");
		rd.password().sendKeys("8056284834");
		rd.submit().click();
	}
	
	
}


