package POMPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseLoginClass;

public class CreateAccountPOM extends BaseLoginClass{

	@FindBy (xpath="//input[@id='ap_customer_name']") WebElement yourName;
	@FindBy (xpath="//input[@id='ap_email']") WebElement phoneOREmail;
	@FindBy (xpath="//input[@id='ap_password']") WebElement password;
	@FindBy (xpath="//input[@id='ap_password_check']") WebElement passwordAgain;
	@FindBy (xpath="//input[@class='a-button-input']") WebElement continueBtn;
	@FindBy (xpath="//input[@id='continue']") WebElement verifyBtn;
	
	
	public CreateAccountPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public void testCreatePage() {
		System.out.println("Create Account Page");
	}
	
	public void typeYourName(String yn) {
		yourName.sendKeys(yn);
	}
	
	public void typePhoneOREmail(String email) {
		phoneOREmail.sendKeys(email);
	}
	
	public void typePasswprd(String ps) {
		password.sendKeys(ps);
	}
	
	public void typePasswordAgain(String psa) {
		passwordAgain.sendKeys(psa);
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
}
