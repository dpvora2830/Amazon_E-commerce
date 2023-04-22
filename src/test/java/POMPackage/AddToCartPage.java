package POMPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseLoginClass;

public class AddToCartPage extends BaseLoginClass{

	@FindBy (xpath="//input[@id='twotabsearchtextbox']") WebElement searchItem;
	@FindBy (xpath="//*[@id='nav-search-submit-button']") WebElement searchBtn;
	@FindBy (xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]") WebElement selProduct;
	@FindBy (xpath="//input[@id='add-to-cart-button']") WebElement addToCartBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeProductName(String proName) {
		searchItem.sendKeys(proName);
		searchBtn.click();
	}
	
	public void selectProduct() {
		selProduct.click();
	}
	
	public void addInCart() {
		addToCartBtn.click();
	}
	
}
