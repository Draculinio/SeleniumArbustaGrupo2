package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Waiters;

public class IndexPage {
	private String searchBox = "search_query_top";
	private String submitButton = "submit_search";
	private String womenLink = "Women";
	WebDriver driver;
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void search(String item) {
		driver.findElement(By.id(searchBox)).sendKeys(item);
		driver.findElement(By.name(submitButton)).click();
		Waiters.fixedWait();
	}
	
	public void goToWomen() {
		driver.findElement(By.linkText("Women")).click();
		Waiters.fixedWait();
	}
}
