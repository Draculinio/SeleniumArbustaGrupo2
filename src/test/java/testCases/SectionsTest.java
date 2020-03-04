package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.IndexPage;
import pageObjects.SectionsPage;

public class SectionsTest extends Commons{
	
	@Test(enabled = false)
	public void womanSection() {
		indexPage.goToWomen();
		/*Find Element desglosado
		 * 
		 * WebElement womenLink;
		womenLink = driver.findElement(By.linkText("Women"));
		womenLink.click();*/
		WebElement womenLink;
		WebDriverWait wait = new WebDriverWait(driver,10);
		womenLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women")));
		womenLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Women")));
		womenLink.click();
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
