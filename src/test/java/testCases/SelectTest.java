package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Waiters;
import pageObjects.ItemsPage;

public class SelectTest {
	private ItemsPage itemsPage;
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		itemsPage = new ItemsPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		Waiters.fixedWait();
		driver.close();
		driver.quit();
	}
	@Test
	public void searchByLowestFirst() {
		itemsPage.searchElementByIndex(1);
	}
	
	@Test
	public void searchByNameAtoZ() {
		itemsPage.searchElementByValue("name:asc");
	}
	
	@Test
	public void searchByInStock() {
		itemsPage.searchElement("In stock");
	}

}
