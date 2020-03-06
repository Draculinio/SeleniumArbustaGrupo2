package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectTest extends Commons{
	
	@Test(enabled = false)
	public void searchByLowestFirst() {
		itemsPage.searchElementByIndex(1);
	}
	
	@Test(enabled = false)
	public void searchByNameAtoZ() {
		itemsPage.searchElementByValue("name:asc");
	}
	
	@Test(description = "Search by stock")
	public void searchByInStock() {
		itemsPage.searchElement("In stock");
		Assert.assertEquals(1, 2);
	}

}
