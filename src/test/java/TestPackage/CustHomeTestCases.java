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

public class CustHomeTestCases extends BaseLoginClass{

	LoginPOM lp;
	SigninPOM sign;
	PasswordPOM pass;
	CustHomePage custPage;
	
	public CustHomeTestCases() {
		super();
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
	}
	
	@Test
	public void openHomePage() {
		custPage = new CustHomePage();
		custPage.gotoYourAccount();
		
		String actUrl = driver.getCurrentUrl();
		System.out.println(actUrl);
		String expUrl = "https://www.amazon.ca/gp/css/homepage.html?ref_=nav_youraccount_btn";
		Assert.assertEquals(actUrl, expUrl);
	}
	
	@AfterMethod
	public void shutDown() {
		driver.close();
	}
	
	
	
}
