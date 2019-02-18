package saucedemo.com.pageobjects;

import org.openqa.selenium.WebDriver;
import locators.AllItemsLocators;
import locators.BurgerMenuLocators;

public class AllItemPage extends BasePage{

	public AllItemPage(WebDriver driver) {
		super(driver);
	}

	public void openBurgerMenu() {
		click(BurgerMenuLocators.BURGER_BTN);
	}

	public void closeBurgerMenu() {
		click(BurgerMenuLocators.CLOSE_BURGER_MENU);
	}
	
	
	public void logout() {
		openBurgerMenu();
		click(BurgerMenuLocators.LOGOUT_LINK);
	}
	
	public void clickAllItemsLink() {
		openBurgerMenu();
		click(BurgerMenuLocators.ALL_ITEMS_LINK);
	}
	
	public void clickAboutLink() {
		openBurgerMenu();
		click(BurgerMenuLocators.ABOUT_LINK);
	}
	
	public void clickResetLink() {
		openBurgerMenu();
		click(BurgerMenuLocators.RESET_LINK);
	}
	
	public void addToCart(int position) {
		clickByPosition(AllItemsLocators.LIST_OF_ADD_TO_CART_BTN, position);
	}

}
