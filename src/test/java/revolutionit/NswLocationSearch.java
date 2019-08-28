package revolutionit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ApplyNumerPlatePage;
import pageObjects.FindServiceNswLocation;
import pageObjects.HomePage;
import pageObjects.NswServiceCenter;
import pageObjects.SearchResultsPage;
import resources.base;

public class NswLocationSearch extends base{
	
    public String suburb, location;
    public WebDriver driver;
	Properties prop = new Properties();
	
	@BeforeTest
	public void setUp() throws IOException
	{
	
		 driver =initializeDriver();
		 FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		 prop.load(datafile);
		 suburb = prop.getProperty("suburb_name");
		 location = prop.getProperty("service_center_name");
	}
	

	@Test
	public void findMyLocation() throws IOException, InterruptedException
	{
		HomePage home_page=new HomePage(driver);
		home_page.goToNswHomePage();
		home_page.searchApplyForANumberPlate();
		
		SearchResultsPage search_page=new SearchResultsPage(driver);
		search_page.selectApplyForNumberPlatePage();
		
		ApplyNumerPlatePage  apply_no_plate=new ApplyNumerPlatePage(driver);
		apply_no_plate.clickFindLocations();
		
		FindServiceNswLocation locations_for_suburb=new FindServiceNswLocation(driver);
		locations_for_suburb.searchSuburb(suburb);
		locations_for_suburb.clickOnServiceLocation(location);
			
		NswServiceCenter center=new NswServiceCenter(driver);
		center.verifyNswServiceCenter(location);
	}

	@AfterTest
	public void tearDown() throws IOException
	{
	
		 driver.quit();
		 
	}

	
}
