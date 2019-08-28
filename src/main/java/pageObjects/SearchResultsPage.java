package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class SearchResultsPage {

	public WebDriver driver;
	By applynumberplateurl = By.linkText("Apply for a number plate");
	Properties prop = new Properties();
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}


//  Method to click on Apply For A Number Plate Link
	public void selectApplyForNumberPlatePage() throws IOException, InterruptedException {
		FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());		
		String searchpageresultstitle = prop.getProperty("searchpagetitle");
		Assert.assertEquals(driver.getTitle(), searchpageresultstitle);	
		System.out.println("Search Results Page Title: " + searchpageresultstitle);		
		WebDriverWait waitsearchnumberplatelink=new WebDriverWait(driver, 20);
		waitsearchnumberplatelink.until(ExpectedConditions.visibilityOfElementLocated(applynumberplateurl));
		waitsearchnumberplatelink.until(ExpectedConditions.elementToBeClickable(applynumberplateurl));
		driver.findElement(applynumberplateurl).click();
	}
}
