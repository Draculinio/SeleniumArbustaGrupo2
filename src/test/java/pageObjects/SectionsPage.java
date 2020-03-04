package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SectionsPage {
	WebDriver driver;
	private By sectionBanner;
	public SectionsPage(WebDriver driver) {
		this.driver = driver;
		sectionBanner = By.xpath("//span[@class='cat-name']");
	}
	
	public String getSectionText(){
		return driver.findElement(sectionBanner).getText();
	}
}
