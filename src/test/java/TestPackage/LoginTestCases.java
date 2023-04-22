package TestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePackage.BaseLoginClass;
import POMPackage.LoginPOM;
import POMPackage.SigninPOM;


public class LoginTestCases extends BaseLoginClass{

	LoginPOM lp;
	
	public LoginTestCases() {
		super();
	}
	
	@BeforeTest
	public void initSetup() throws InterruptedException {
		setup();
	}
	
	/*@Test
	public void seeTitle() {
		String actual = lp.title();
		System.out.println(actual);
		//Assert.assertEquals(actual, "Amazon");
	}*/
	
	@Test
	public void openSignInPage() {
		lp= new LoginPOM();
		driver.manage().timeouts().getImplicitWaitTimeout();
		lp.goTosignInPage();
	}
	
	@Test
	public void openSignUPPage() {
		lp = new LoginPOM();
		lp.goTosignUPPage();
	}
	
	@AfterTest
	public void windUP() {
		driver.close();
	}
	
}
