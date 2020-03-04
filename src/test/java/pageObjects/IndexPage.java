package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Waiters;

public class IndexPage {
	private By searchBox;
	private By submitButton;
	private By womenLink;
	WebDriver driver;
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		searchBox = By.id("search_query_top");
		submitButton = By.name("submit_search");
		womenLink = By.linkText("Women");
	}
	
	public void search(String item) {
		driver.findElement(searchBox).sendKeys(item);
		driver.findElement(submitButton).click();
		Waiters.fixedWait();
	}
	
	public void goToWomen() {
		driver.findElement(womenLink).click();
		Waiters.fixedWait();
	}
}
