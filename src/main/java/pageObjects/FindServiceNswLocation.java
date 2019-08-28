package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class FindServiceNswLocation {

	public WebDriver driver;
	By findlocations = By.xpath("//input[@id='locatorTextSearch']");
//	By servicecentername = By.linkText(linkText)
	
	public Properties prop = new Properties();
//	public FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
//	public prop.load(datafile);
	
	public FindServiceNswLocation(WebDriver driver) {
		this.driver = driver;
	}
	
//  Method to search suburb
	public void searchSuburb(String suburbname) throws IOException, InterruptedException {
		FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());		
		String pagetitle = prop.getProperty("nswlocationpage");
		Assert.assertEquals(driver.getTitle(), pagetitle);	
		System.out.println("Locations search Page Title: " + pagetitle);		
		WebDriverWait waitsearchnumberplatelink=new WebDriverWait(driver, 20);
		waitsearchnumberplatelink.until(ExpectedConditions.elementToBeClickable(findlocations));
		waitsearchnumberplatelink.until(ExpectedConditions.visibilityOfElementLocated(findlocations));
		driver.findElement(findlocations).clear();
		driver.findElement(findlocations).sendKeys(suburbname);
		driver.findElement(findlocations).sendKeys(Keys.ENTER);
	}
	
//  Method to verify is the given location is present in search results
	public void clickOnServiceLocation(String locationname) throws IOException, InterruptedException {
		FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());		
		String pagetitle = prop.getProperty("nswlocationpage");
		Assert.assertEquals(driver.getTitle(), pagetitle);	
		System.out.println("Locations search Page Title: " + pagetitle);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebDriverWait waitsearchnumberplatelink=new WebDriverWait(driver, 20);
		waitsearchnumberplatelink.until(ExpectedConditions.elementToBeClickable(By.linkText(locationname)));
		waitsearchnumberplatelink.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locationname)));
		driver.findElement(By.linkText(locationname)).click();
		
	}
	
}
