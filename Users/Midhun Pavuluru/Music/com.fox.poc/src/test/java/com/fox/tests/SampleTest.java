package com.fox.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fox.pages.ShowsPage;


public class SampleTest {
	
	@SuppressWarnings("resource")
	@Test
	public void sampleTest() throws InterruptedException, IOException{
		ShowsPage objShowsPage = new ShowsPage();
		WebDriver driver ;
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.fox.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,60);
		//opening shows menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(objShowsPage.menuShows)).click();
		wait.until(ExpectedConditions.elementToBeClickable(objShowsPage.menuShows)).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//scroll down to capture the last 4 shows info
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		List<WebElement> showsOnFoxList = driver.findElements(objShowsPage.linkShowsList2);
	   int foxMovListSize = showsOnFoxList.size();
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showsOnFoxList.get(foxMovListSize-4));
	   Thread.sleep(5000);
	   
	   List<String> foxLastFourMovies = new ArrayList<String>();
	   //adding last four FOX movies to list
	   for(int i=foxMovListSize-4;i<foxMovListSize;i++){
		   foxLastFourMovies.add(showsOnFoxList.get(i).getText());
	    }
	   //sorts the movies in the list
	   Collections.sort(foxLastFourMovies);
	   
	    FileInputStream fis = new FileInputStream(new File("C:\\Users\\Midhun Pavuluru\\Music\\com.fox.poc\\TestResults.xlsx"));
	    
	    XSSFWorkbook workbook;
	    workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("FoxTest");
		//adding the last four movies of Fox tab to excel
		for(int i=0;i<foxLastFourMovies.size();i++){
			sheet.createRow(i+1).createCell(0).setCellValue(foxLastFourMovies.get(i));	
			Thread.sleep(1000);
		}
		
		
	   //navigating to FX tab
	   wait.until(ExpectedConditions.elementToBeClickable(objShowsPage.linkFX)).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		
		List<WebElement> showsOnFXList1= driver.findElements(objShowsPage.linkShowsList1);
		List<WebElement> showsOnFXList2 = driver.findElements(objShowsPage.linkShowsList2);
		List<String> fxMovies = new ArrayList<String>();
		
		//adding all the  FX movies to list
		   for(int i=0;i<showsOnFXList1.size();i++){
			   fxMovies.add(showsOnFXList1.get(i).getText());
		   }
		   for(int i=0;i<showsOnFXList2.size();i++){
			   fxMovies.add(showsOnFXList2.get(i).getText());
		   }
		   Collections.sort(fxMovies);
		   
		   //removing the movies from the list which are not matched with fox last 4 movies
		   fxMovies.retainAll(foxLastFourMovies);
		  
		   for(int j=0;j<foxLastFourMovies.size();j++){
			   boolean fxMoviesFlag = false;
			   for(int i=0;i<fxMovies.size();i++){
				   if(fxMovies.get(i).equals(foxLastFourMovies.get(j))){
					   fxMoviesFlag = true;
					   break;
					}
			   }
			   if(fxMoviesFlag){
				   sheet.getRow(j+1).createCell(1).setCellValue("DUPLICATE");						 
			 }else{
				 sheet.getRow(j+1).createCell(1).setCellValue("N/A");	
			 }
		   }
	
		   //navigating to National Geographic tab
		   wait.until(ExpectedConditions.elementToBeClickable(objShowsPage.linkNationalGeographic)).click();
		   driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
			Thread.sleep(2000);
			
			List<WebElement> showsOnNGList1= driver.findElements(objShowsPage.linkShowsList1);
			List<WebElement> showsOnNGList2 = driver.findElements(objShowsPage.linkShowsList2);
			List<String> ngMovies = new ArrayList<String>();
			
			//adding all the  NG movies to list
			   for(int i=0;i<showsOnNGList1.size();i++){
				   ngMovies.add(showsOnNGList1.get(i).getText());
			   }
			   for(int i=0;i<showsOnNGList2.size();i++){
				   ngMovies.add(showsOnNGList2.get(i).getText());
			   }
			   Collections.sort(ngMovies);
			   
			   ngMovies.retainAll(foxLastFourMovies);
			   
		  for(int j=0;j<foxLastFourMovies.size();j++){
				   boolean ngMoviesFlag = false;
				   for(int i=0;i<ngMovies.size();i++){
					   if(ngMovies.get(i).equals(foxLastFourMovies.get(j))){
						   ngMoviesFlag = true;
						   break;
						}
				   }
				   if(ngMoviesFlag){
					   sheet.getRow(j+1).createCell(2).setCellValue("DUPLICATE");						 
				 }else{
					 sheet.getRow(j+1).createCell(2).setCellValue("N/A");	
				 }
			   }
				
			   //navigating to FOX Sports tab
			   wait.until(ExpectedConditions.elementToBeClickable(objShowsPage.linkFOXSports)).click();
			   driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
				Thread.sleep(2000);
				
				List<WebElement> showsOnFoxSportsList1= driver.findElements(objShowsPage.linkShowsList1);
				List<WebElement> showsOnFoxSportsList2 = driver.findElements(objShowsPage.linkShowsList2);
				List<String> foxSprotsMovies = new ArrayList<String>();
				
				Thread.sleep(2000);
				//adding all the  FOX Sports movies to list
				   for(int i=0;i<showsOnFoxSportsList1.size();i++){
					   foxSprotsMovies.add(showsOnFoxSportsList1.get(i).getText());
				   }
				   for(int i=0;i<showsOnFoxSportsList2.size();i++){
					   foxSprotsMovies.add(showsOnFoxSportsList2.get(i).getText());
				   }
				   Collections.sort(foxSprotsMovies);
				   
				   foxSprotsMovies.retainAll(foxLastFourMovies);
				   
				   for(int j=0;j<foxLastFourMovies.size();j++){
					   boolean foxSprotsMoviesFlag = false;
					   for(int i=0;i<foxSprotsMovies.size();i++){
						   if(foxSprotsMovies.get(i).equals(foxLastFourMovies.get(j))){
							   foxSprotsMoviesFlag = true;
							   break;
							}
					   }
					   if(foxSprotsMoviesFlag){
						   sheet.getRow(j+1).createCell(3).setCellValue("DUPLICATE");						 
					 }else{
						 sheet.getRow(j+1).createCell(3).setCellValue("N/A");	
					 }
				   }
				   //navigating to All Shows tab
				   wait.until(ExpectedConditions.elementToBeClickable(objShowsPage.linkAllShows)).click();
				   driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				   Thread.sleep(2000);
				   ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
					Thread.sleep(5000);
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
					Thread.sleep(2000);
					
					List<WebElement> allShowsList1= driver.findElements(objShowsPage.linkShowsList1);
					List<WebElement> allShowsList2 = driver.findElements(objShowsPage.linkShowsList2);
					List<String> allShowsMovies = new ArrayList<String>();
					
					//adding all the  FOX Sports movies to list
					   for(int i=0;i<allShowsList1.size();i++){
						   allShowsMovies.add(allShowsList1.get(i).getText());
					   }
					   for(int i=0;i<allShowsList2.size();i++){
						   allShowsMovies.add(allShowsList2.get(i).getText());
					   }
					   Collections.sort(allShowsMovies);
				   
		
					   allShowsMovies.retainAll(foxLastFourMovies);
					   
					   for(int j=0;j<foxLastFourMovies.size();j++){
						   boolean allShowsMoviesFlag = false;
						   for(int i=0;i<allShowsMovies.size();i++){
							   if(allShowsMovies.get(i).equals(foxLastFourMovies.get(j))){
								   allShowsMoviesFlag = true;
								   break;
								}
						   }
						   if(allShowsMoviesFlag){
							   sheet.getRow(j+1).createCell(4).setCellValue("DUPLICATE");						 
						 }else{
							 sheet.getRow(j+1).createCell(4).setCellValue("N/A");	
						 }
					   }
					   
					   FileOutputStream fout = new FileOutputStream(new File("C:\\Users\\Midhun Pavuluru\\Music\\com.fox.poc\\TestResults.xlsx"));
					   					   
					// finally write content 
					 
					   workbook.write(fout);
					  
					// close the file
					 
					   fout.close();
					   
					   driver.close();
					   System.out.println("Test completed");
					   
	}
}