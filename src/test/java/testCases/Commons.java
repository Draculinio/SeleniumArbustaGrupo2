package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helpers.Waiters;
import pageObjects.IndexPage;
import pageObjects.ItemsPage;
import pageObjects.SectionsPage;

public class Commons {
	protected WebDriver driver;
	protected ItemsPage itemsPage;
	protected IndexPage indexPage;
	protected SectionsPage sectionsPage;
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		itemsPage = new ItemsPage(driver);
		indexPage = new IndexPage(driver);
		sectionsPage = new SectionsPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		Waiters.fixedWait();
		driver.close();
		driver.quit();
	}
}
