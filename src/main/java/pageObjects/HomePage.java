package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class HomePage {
	
	Properties prop = new Properties();
	public  WebDriver driver;
	By searchbox = By.xpath("//div[@id='homeAutosuggest']//input[@placeholder='Search']");


			
	public HomePage(WebDriver driver) {
		System.out.println("HOME PAGE: HELLLOEEEE");
		this.driver = driver;
	}

//  Method to verify Home Page Title
	public void goToNswHomePage() throws IOException, InterruptedException {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("goToNswHomePage: HELLLOEEEE");
		FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		String homepageurl = prop.getProperty("url");
		driver.get(homepageurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());		
		String homepagetitle = prop.getProperty("nswhomepage");
		Assert.assertEquals(driver.getTitle(), homepagetitle);	
	}

//  Method to enter "apply for a number plate" in search box
	public void searchApplyForANumberPlate() throws IOException {
		FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		String searchstring = prop.getProperty("homepagesearchstring");
		System.out.println("Search String is: " + searchstring);
		driver.findElement(searchbox).sendKeys(searchstring);
		driver.findElement(searchbox).sendKeys(Keys.ENTER);		
	}
	
	

}
