package POMPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseLoginClass;

public class PasswordPOM extends BaseLoginClass{

	@FindBy (xpath="//input[@id='ap_password']") WebElement password;
	@FindBy (xpath="//input[@id='signInSubmit']") WebElement signInBtn;
	
	public PasswordPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public CustHomePage typePassword(String ps) {
		
		password.sendKeys(ps);
		signInBtn.click();
		
		return new CustHomePage();
	}
	
}
