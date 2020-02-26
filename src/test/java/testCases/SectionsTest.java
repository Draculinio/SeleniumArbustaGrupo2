package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SectionsTest {
	
	@Test
	public void womanSection() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/");
		driver.findElement(By.linkText("Women")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sectionTitle = driver.findElement(By.xpath("//span[@class='cat-name']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='cat-name']")).getText(), "WOMEN ");
		Assert.assertTrue(sectionTitle.matches("WOMEN "));
		Assert.assertTrue(sectionTitle.contentEquals("WOMEN "));
		Assert.assertTrue(sectionTitle.contains("WOM"));
		//Assert.assertEquals(sectionTitle, "WOMEN ");
		/*Assert.assertTrue(sectionTitle=="WOMEN ");
		Assert.assertNotEquals(sectionTitle, "Dresses ");
		Assert.assertFalse(sectionTitle == "MEN ");*/
		driver.close();
		driver.quit();
	}

}
