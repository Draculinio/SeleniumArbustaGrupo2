package testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helpers.Screenshots;
import helpers.Waiters;
import pageObjects.IndexPage;
import pageObjects.ItemsPage;
import pageObjects.SectionsPage;

public class Commons {
	protected WebDriver driver;
	protected ItemsPage itemsPage;
	protected IndexPage indexPage;
	protected SectionsPage sectionsPage;
	@BeforeMethod
	public void setUp() {
		String driverByOs;
		System.out.println(System.getProperty("os.name"));
		if(System.getProperty("os.name").equals("Windows 10")){ //.contains("Windows")
			driverByOs = "Drivers/chromedriver.exe";
		}else {
			driverByOs = "Drivers/chromedriver";
		}
		System.setProperty("webdriver.chrome.driver", driverByOs);
		ChromeOptions  options = new ChromeOptions();
		//options.addArguments("--start-maximized");
		//options.addArguments("--window-size=600,480");
		//options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(400,500));
		driver.manage().window().setPosition(new Point(500,700));
		driver.navigate().to("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		itemsPage = new ItemsPage(driver);
		indexPage = new IndexPage(driver);
		sectionsPage = new SectionsPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		String resultado;
		System.out.println(result.getStatus());
		if(result.getStatus()==1) {
			resultado = "PASO EL TEST";
		}else {
			resultado = "NO PASO EL TEST";
		}
		System.out.println("El test "+result.getMethod().getDescription()+" resulta: "+resultado);
		
		if(!result.isSuccess()) {
			Screenshots.takeScreenshot(driver,result.getMethod().getDescription());
		}
		driver.close();
		driver.quit();
	}
	
	
}
