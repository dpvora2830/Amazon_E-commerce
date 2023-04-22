package POMPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BasePackage.BaseLoginClass;

public class AddAddressesPage extends BaseLoginClass{

	@FindBy (xpath="//select[@id='address-ui-widgets-countryCode-dropdown-nativeId']") WebElement selectCountry;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressFullName']") WebElement fullName;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']") WebElement phoneNum;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressLine1']") WebElement addLine1;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressCity']") WebElement city;
	@FindBy (xpath="//*[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']") WebElement selectProvince;
	@FindBy (xpath="//*[@id='address-ui-widgets-enterAddressPostalCode']") WebElement postalCode;
	@FindBy (xpath="//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input") WebElement addAddressBtn;
	
	
	
	public AddAddressesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectValidCountry(String cn) {
		Select sel = new Select(selectCountry);
		sel.selectByVisibleText(cn);
	}
	
	public void validfullName(String fn) {
		fullName.sendKeys(fn);
	}
	
	public void validphoneNum(String phone) {
		phoneNum.sendKeys(phone);
	}
	
	public void validAddressLine01(String addl1) {
		addLine1.sendKeys(addl1);
	}
	
	public void validCity(String city) {
		addLine1.sendKeys(city);
	}
	
	public void selectValidProvince(String pro) {
		Select sel = new Select(selectProvince);
		sel.selectByVisibleText(pro);
	}
	
	public void validPostalCode(String posCode) {
		postalCode.sendKeys(posCode);
	}
	
	public void clickOnAddAddressbtn() {
		addAddressBtn.click();
	}
	
	
}
