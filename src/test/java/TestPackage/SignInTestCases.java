package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePackage.BaseLoginClass;
import POMPackage.LoginPOM;
import POMPackage.SigninPOM;

public class SignInTestCases extends BaseLoginClass{

	LoginPOM lp;
	SigninPOM sign;
	
	public SignInTestCases() {
		super();
	}
	
	@BeforeTest
	public void intiate(){
		setup();
		lp= new LoginPOM();
		lp.goTosignInPage();
	}
	
	@Test
	public void validUserName(){
		driver.manage().timeouts().getImplicitWaitTimeout();
		sign = new SigninPOM();
		//sign.testSignPage();
		
		sign.typeEmail(prop.getProperty("username"));
		String actURL = driver.getCurrentUrl();
		String expURL = "https://www.amazon.ca/ap/signin";
		Assert.assertEquals(actURL, expURL);
	}
	
	/*@Test
	public void invalidUserName() {
		sign = new SigninPOM();
		sign.typeEmail("dipalsor@gmail.com");
		
		String actResult= driver.switchTo().alert().getText();
		System.out.println(actResult);
	}*/
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
}
