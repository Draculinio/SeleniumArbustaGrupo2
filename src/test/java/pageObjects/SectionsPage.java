package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SectionsPage {
	WebDriver driver;
	private String sectionBanner = "//span[@class='cat-name']";
	public SectionsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getSectionText(){
		return driver.findElement(By.xpath(sectionBanner)).getText();
	}
}
