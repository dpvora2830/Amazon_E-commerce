package POMPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseLoginClass;

public class YourAddressesPage extends BaseLoginClass{

	@FindBy (xpath="//*[@id='ya-myab-plus-address-icon']") WebElement addAddress;
	
	public YourAddressesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddAddressesPage clickOnAddAddress() {
		addAddress.click();
		return new AddAddressesPage();
	}
	
}
