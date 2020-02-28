package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.IndexPage;
import pageObjects.SectionsPage;

public class SectionsTest {
	WebDriver driver;
	IndexPage indexPage;
	SectionsPage sectionsPage;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		indexPage = new IndexPage(driver);
		sectionsPage = new SectionsPage(driver);
		driver.navigate().to("http://automationpractice.com/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test(enabled = false)
	public void womanSection() {
		indexPage.goToWomen();
		driver.findElement(By.linkText("Women")).click();
		//String sectionTitle = driver.findElement(By.xpath("//span[@class='cat-name']")).getText();
		String sectionTitle = sectionsPage.getSectionText();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='cat-name']")).getText(), "WOMEN ");
		Assert.assertTrue(sectionTitle.matches("WOMEN "));
		Assert.assertTrue(sectionTitle.contentEquals("WOMEN "));
		Assert.assertTrue(sectionTitle.contains("WOM"));
		//Assert.assertEquals(sectionTitle, "WOMEN ");
		/*Assert.assertTrue(sectionTitle=="WOMEN ");
		Assert.assertNotEquals(sectionTitle, "Dresses ");
		Assert.assertFalse(sectionTitle == "MEN ");*/
		
	}

}
