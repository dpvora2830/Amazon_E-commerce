package POMPackage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseLoginClass;

public class LoginPOM extends BaseLoginClass{

	//@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]") WebElement SignInLink;
	@FindBy(xpath="//*[@id='nav-link-accountList']") WebElement Account;
	@FindBy(xpath="//*[@id=\"nav-signin-tooltip\"]/a/span") WebElement SignInBtn;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-ya-newCust\"]/a") WebElement StartHere;
	
	Actions action;
	
	public LoginPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public SigninPOM goTosignInPage() {
		action = new Actions(driver);
		action.moveToElement(Account).build().perform();
		
		SignInBtn.click();
		//SignIN.click();
		return new SigninPOM();
	}
	
	public CreateAccountPOM goTosignUPPage() {
		action = new Actions(driver);
		action.moveToElement(Account).build().perform();
		//Thread.sleep(2000);
		StartHere.click();
		
		return new CreateAccountPOM();
	}
	
	public String title() {
		return driver.getTitle();
	}
	
}
