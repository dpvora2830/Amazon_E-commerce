package TestPackage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

import BasePackage.BaseLoginClass;
import POMPackage.CustHomePage;
import POMPackage.LoginPOM;
import POMPackage.PasswordPOM;
import POMPackage.SigninPOM;

public class YourOrdersTestCases extends BaseLoginClass{
	LoginPOM lp;
	SigninPOM sign;
	PasswordPOM pass;
	CustHomePage custPage;
	
	public YourOrdersTestCases() {
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
	
	
}
