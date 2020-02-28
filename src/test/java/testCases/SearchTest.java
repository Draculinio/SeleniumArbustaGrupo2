package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Waiters;
import pageObjects.IndexPage;
import pageObjects.ItemsPage;

public class SearchTest {
	
	private WebDriver driver;
	ItemsPage itemsPage;
	IndexPage indexPage;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		itemsPage = new ItemsPage(driver);
		indexPage = new IndexPage(driver);
		driver.navigate().to("http://automationpractice.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test(enabled = false)
	public void searchWithResults() {
		indexPage.search("Dress");
		//String searchTitle = itemsPage.getTitleText();
		//Assert.assertTrue(searchTitle.contains("DRES"),"Expected: "+searchTitle);
		Assert.assertTrue(itemsPage.getTitleText().contains("DRES"),"Expected: "+itemsPage.getTitleText());
	}
	
	@Test(enabled = false)
	public void searchWithNoResults() {
		indexPage.search("dlsfkjflsdkfj");
		/*String noElements = itemsPage.getNoResultsText();
		Assert.assertTrue(noElements.contains("dfgsfhkjgfh"));*/
		Assert.assertTrue(itemsPage.getNoResultsText().contains("dlsfkjflsdkfj"));
	}
}
