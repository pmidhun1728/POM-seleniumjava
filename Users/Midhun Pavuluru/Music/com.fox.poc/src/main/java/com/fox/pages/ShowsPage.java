package com.fox.pages;

import org.openqa.selenium.By;

public class ShowsPage {
	
	

	public By menuShows = By.xpath("//a[text()='Shows']");
	public By linkFOX                                = By.xpath("//a[@role='button' and text()='FOX']");
	public By linkFX                                   = By.xpath("//a[text()='FX']");
	public By linkNationalGeographic = By.xpath("//a[text()='National Geographic']");
	public By linkFOXSports    			      = By.xpath("//a[text()='FOX Sports']");
	public By linkAllShows                       = By.xpath("//a[text()='All Shows']");
	public By linkShowsList1                    = By.xpath("html/body/div[1]/div/main/div/div[1]/div[2]/div/div/div/div/div/div[2]/div/a/div/div[1]");
	public By linkShowsList2		               = By.xpath("html/body/div[1]/div/main/div/div[1]/div[2]/div/div/div/div/div/div[2]/div/a/span/div[1]");


}
