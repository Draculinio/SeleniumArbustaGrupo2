package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ItemsPage {
	private WebDriver driver;
	private By titleBanner;
	private By noResultsBanner;
	private By orderSelect;
	
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
		titleBanner = By.xpath("//span[@class='lighter']");
		noResultsBanner = By.xpath("//*[@id='center_column']/p");
		orderSelect = By.id("selectProductSort");
	}
	
	public String getTitleText() {
		return driver.findElement(titleBanner).getText();
	}
	
	public String getNoResultsText() {
		return driver.findElement(noResultsBanner).getText();
	}
	
	public void searchElement(String nameOfElement) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByVisibleText(nameOfElement);
	}
	
	public void searchElementByValue(String value) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByValue(value);
	}
	
	public void searchElementByIndex(int number) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByIndex(3);
	}
}
