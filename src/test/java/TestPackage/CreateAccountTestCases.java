package TestPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseLoginClass;
import POMPackage.CreateAccountPOM;
import POMPackage.LoginPOM;

public class CreateAccountTestCases extends BaseLoginClass{

	LoginPOM lp;
	CreateAccountPOM crtAcc;
	
	public CreateAccountTestCases() {
		super();
	}
	
	@BeforeMethod
	public void intiate() {
		setup();
		lp =new LoginPOM();
		lp.goTosignUPPage();
	}
	
	/*@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	*/
	@Test(priority = 1)
	public void validName() {
		
		crtAcc = new CreateAccountPOM();
		//crtAcc.testCreatePage();
		crtAcc.typeYourName("Parth");
	}
	
	@Test
	public void validPhoneOREmail() {
		crtAcc = new CreateAccountPOM();
		crtAcc.typePhoneOREmail("vora.parth@gmail.com");
	}
	
	@Test(priority = 2)
	public void validPassword() {
		crtAcc = new CreateAccountPOM();
		crtAcc.typePasswprd("Parth123");
	}
	
	@Test(priority = 3)
	public void validPasswordAgain() {
		crtAcc = new CreateAccountPOM();
		crtAcc.typePasswordAgain("Parth123");
	}
	
}
