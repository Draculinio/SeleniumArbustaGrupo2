package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ItemsPage {
	private WebDriver driver;
	private String titleBanner= "//span[@class='lighter']";
	private String noResultsBanner = "//*[@id='center_column']/p";
	private String orderSelect = "selectProductSort";
	
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitleText() {
		return driver.findElement(By.xpath(titleBanner)).getText();
	}
	
	public String getNoResultsText() {
		return driver.findElement(By.xpath(noResultsBanner)).getText();
	}
	
	public void searchElement(String nameOfElement) {
		Select select = new Select(driver.findElement(By.id(orderSelect)));
		select.selectByVisibleText(nameOfElement);
	}
	
	public void searchElementByValue(String value) {
		Select select = new Select(driver.findElement(By.id(orderSelect)));
		select.selectByValue(value);
	}
	
	public void searchElementByIndex(int number) {
		Select select = new Select(driver.findElement(By.id(orderSelect)));
		select.selectByIndex(3);
	}
}
