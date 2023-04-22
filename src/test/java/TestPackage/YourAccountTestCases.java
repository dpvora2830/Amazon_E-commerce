package TestPackage;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseLoginClass;
import POMPackage.CustHomePage;
import POMPackage.LoginPOM;
import POMPackage.PasswordPOM;
import POMPackage.SigninPOM;
import POMPackage.YourAccountPage;
import POMPackage.YourAddressesPage;

public class YourAccountTestCases extends BaseLoginClass{

	LoginPOM lp;
	SigninPOM sign;
	PasswordPOM pass;
	CustHomePage custPage;
	YourAccountPage yourAccPage;
	
	public YourAccountTestCases() throws InterruptedException {
		super();
		//Thread.sleep(5000);
	}
	
	@BeforeMethod
	public void intiate() throws InterruptedException {
		setup();
		Thread.sleep(2000);
		lp = new LoginPOM();
		lp.goTosignInPage();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sign = new SigninPOM();
		sign.typeEmail(prop.getProperty("username"));
		
		driver.manage().timeouts().getImplicitWaitTimeout();
		
		pass=new PasswordPOM();
		pass.typePassword(prop.getProperty("password"));
		
		custPage = new CustHomePage();
		custPage.gotoYourAccount();
	}
	
	@Test
	public void testOrderPage() {
		yourAccPage = new YourAccountPage();
		yourAccPage.goToOrderPage();
		String actUrl = driver.getCurrentUrl();
		//System.out.println(actUrl);
		String expUrl = "https://www.amazon.ca/gp/your-account/order-history?ref_=ya_d_c_yo";
		Assert.assertEquals(actUrl, expUrl);
	}
	
	@Test
	public void testAddressPage() {
		yourAccPage = new YourAccountPage();
		yourAccPage.goToAddressesPage();
		String actUrl = driver.getCurrentUrl();
		//System.out.println(actUrl);
		String expUrl = "https://www.amazon.ca/a/addresses?ref_=ya_d_c_addr";
		Assert.assertEquals(actUrl, expUrl);
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	

}
