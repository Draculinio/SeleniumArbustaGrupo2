package testCases;

import java.util.concurrent.TimeUnit;

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

public class SearchTest extends Commons {
	
	
	@Test(enabled = false)
	public void searchWithResults() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		indexPage.search("Dress");
		//String searchTitle = itemsPage.getTitleText();
		//Assert.assertTrue(searchTitle.contains("DRES"),"Expected: "+searchTitle);
		Assert.assertTrue(itemsPage.getTitleText().contains("DRES"),"Expected: "+itemsPage.getTitleText());
	}
	
	@Test(enabled = false)
	public void searchWithNoResults() {
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		indexPage.search("dlsfkjflsdkfj");
		/*String noElements = itemsPage.getNoResultsText();
		Assert.assertTrue(noElements.contains("dfgsfhkjgfh"));*/
		Assert.assertTrue(itemsPage.getNoResultsText().contains("dlsfkjflsdkfj"));
	}
}
