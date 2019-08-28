package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ApplyNumerPlatePage {

	public WebDriver driver;
	By findlocations = By.linkText("Find locations");
	Properties prop = new Properties();
	
	public ApplyNumerPlatePage(WebDriver driver) {
		this.driver = driver;
	}
	
//  Method to click on Apply For A Number Plate Link
	public void clickFindLocations() throws IOException, InterruptedException {
		FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());		
		String pagetitle = prop.getProperty("applynoplatepagetitle");
		Assert.assertEquals(driver.getTitle(), pagetitle);	
		System.out.println("Search Results Page Title: " + pagetitle);		
		WebDriverWait waitsearchnumberplatelink=new WebDriverWait(driver, 20);
		waitsearchnumberplatelink.until(ExpectedConditions.elementToBeClickable(findlocations));
		waitsearchnumberplatelink.until(ExpectedConditions.visibilityOfElementLocated(findlocations));
		driver.findElement(findlocations).click();
	}
}
