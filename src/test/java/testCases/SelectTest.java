package testCases;

import org.testng.annotations.Test;

public class SelectTest extends Commons{
	
	@Test
	public void searchByLowestFirst() {
		itemsPage.searchElementByIndex(1);
	}
	
	@Test
	public void searchByNameAtoZ() {
		itemsPage.searchElementByValue("name:asc");
	}
	
	@Test
	public void searchByInStock() {
		itemsPage.searchElement("In stock");
	}

}
