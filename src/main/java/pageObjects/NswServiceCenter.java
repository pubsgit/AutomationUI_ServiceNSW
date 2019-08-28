package pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class NswServiceCenter {

	public WebDriver driver;
	
	Properties prop = new Properties();
	
	public NswServiceCenter(WebDriver driver) {
		this.driver = driver;
	}
	
//  Method to verify we landed on the service location page
	public void verifyNswServiceCenter(String locationname) throws IOException, InterruptedException {
		WebDriverWait waitsearchnumberplatelink=new WebDriverWait(driver, 20);
		waitsearchnumberplatelink.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='address']")));		
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + locationname + "')]"));
		Assert.assertTrue("Not in Location Web page!", list.size() > 0);
	}
	
}
