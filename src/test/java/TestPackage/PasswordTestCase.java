package TestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePackage.BaseLoginClass;
import POMPackage.LoginPOM;
import POMPackage.PasswordPOM;
import POMPackage.SigninPOM;

//used different testNG annotation..........

public class PasswordTestCase extends BaseLoginClass {

	LoginPOM lp;
	SigninPOM sign;
	PasswordPOM pass;
	
	public PasswordTestCase() {
		super();
	}
	
	@BeforeSuite
	public void intiate() {
		setup();
	}
	
	@BeforeTest
	public void openSignPagr() {
		
		lp = new LoginPOM();
		lp.goTosignInPage();
		driver.manage().timeouts().getImplicitWaitTimeout();
		sign = new SigninPOM();
		sign.typeEmail(prop.getProperty("username"));
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void validPassword() {
		
		pass = new PasswordPOM();
		pass.typePassword(prop.getProperty("password"));
		
		String actURL = driver.getCurrentUrl();
		//System.out.println(actURL);
		String expURL = "https://www.amazon.ca/?ref_=nav_custrec_signin";
		Assert.assertEquals(actURL, expURL);
	}
	
	/*@Test
	public void invalidPassword() {
		pass = new PasswordPOM();
		pass.typePassword("dipal123");
	}*/
}
