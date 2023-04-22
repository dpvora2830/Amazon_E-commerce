package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePackage.BaseLoginClass;
import POMPackage.AddAddressesPage;
import POMPackage.CustHomePage;
import POMPackage.LoginPOM;
import POMPackage.PasswordPOM;
import POMPackage.SigninPOM;
import POMPackage.YourAccountPage;
import POMPackage.YourAddressesPage;

public class AddAddressTestCases extends BaseLoginClass{

	LoginPOM lp;
	SigninPOM sign;
	PasswordPOM pass;
	CustHomePage custPage;
	YourAccountPage yourAccPage;
	YourAddressesPage yourAddress;
	AddAddressesPage addNewAddress;
	
	public AddAddressTestCases() throws InterruptedException {
		super();
		//Thread.sleep(5000);
	}
	
	@BeforeTest
	public void intiate() throws InterruptedException {
		setup();
		Thread.sleep(3000);
		lp = new LoginPOM();
		lp.goTosignInPage();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sign = new SigninPOM();
		sign.typeEmail(prop.getProperty("username"));
		
		driver.manage().timeouts().getImplicitWaitTimeout();
		
		pass=new PasswordPOM();
		pass.typePassword(prop.getProperty("password"));
		
	}
	
	@BeforeMethod
	public void testOpenAddAddressPage() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		custPage = new CustHomePage();
		custPage.gotoYourAccount();
		
		yourAccPage = new YourAccountPage();
		yourAccPage.goToAddressesPage();
		
		yourAddress = new YourAddressesPage();
		yourAddress.clickOnAddAddress();
	}
	
	@Test
	public void testAddressFieldsWithValidData() {
		
		addNewAddress = new AddAddressesPage();
		addNewAddress.validfullName("Pqrs");
		addNewAddress.validphoneNum("1234567890");
		addNewAddress.validAddressLine01("12 demo Street");
		addNewAddress.validCity("Brampton");
		addNewAddress.selectValidProvince("Ontario");
		addNewAddress.validPostalCode("A2BC4D");
		addNewAddress.clickOnAddAddressbtn();
	}
	
	@Test
	/*public void invalidFullName() {
		addNewAddress = new AddAddressesPage();
		addNewAddress.validfullName(null);
		addNewAddress.clickOnAddAddressbtn();
		WebElement errorOnName = driver.findElement(By.xpath("//*[contains(text(),'Please enter a name.')])"));	
		String actResult=errorOnName.getText();
		Assert.assertEquals(actResult, "Please enter a name");
	}*/
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
}
