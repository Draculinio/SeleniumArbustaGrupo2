package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/");
	}
	
	@Test
	public void searchWithResults() {
		driver.findElement(By.id("search_query_top")).sendKeys("Dresses");
		driver.findElement(By.name("submit_search")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String searchTitle = driver.findElement(By.xpath("//span[@class='lighter']")).getText();
		Assert.assertTrue(searchTitle.contains("DRES"),"Expected: "+searchTitle);
		driver.close();
		driver.quit();
	}
	
	@Test
	public void searchWithNoResults() {
		driver.findElement(By.id("search_query_top")).sendKeys("dfgsfhkjgfh");
		driver.findElement(By.name("submit_search")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String noElements = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
		Assert.assertTrue(noElements.contains("dfgsfhkjgfh"));
	}
}
