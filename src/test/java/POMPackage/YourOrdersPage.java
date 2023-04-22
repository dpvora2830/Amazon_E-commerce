package POMPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseLoginClass;

public class YourOrdersPage extends BaseLoginClass{
	
	@FindBy (xpath="//*[contains(text(),'Cancelled Orders')]") WebElement cancelledOrder;
	@FindBy (xpath="//*[contains(text(),'Not Yet Shipped')]") WebElement notShippedOrders;
	@FindBy (xpath="//*[contains(text(),'But Again')]") WebElement buyAgainOrders;
	
	public YourOrdersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CancelledOrderPage showCancelledOrders() {
		cancelledOrder.click();
		return new CancelledOrderPage();
	}
	
	public CancelledOrderPage showNotShippedOrders() {
		cancelledOrder.click();
		return new CancelledOrderPage();
	}
	
	public CancelledOrderPage buyAgainOrders() {
		cancelledOrder.click();
		return new CancelledOrderPage();
	}
	
	
}
