package locators;

import org.openqa.selenium.By;

public class BurgerMenuLocators {

	public static final By BURGER_BTN = By.cssSelector(".bm-burger-button>button");
	public static final By BURGER_MENU = By.cssSelector(".bm-menu");
	public static final By BURGER_ITEMS_LIST = By.cssSelector(".bm-item-list");
	public static final By CLOSE_BURGER_MENU = By.cssSelector(".bm-cross-button>button");
	public static final By ALL_ITEMS_LINK = By.cssSelector("#inventory_sidebar_link");
	public static final By ABOUT_LINK = By.cssSelector("#about_sidebar_link");
	public static final By RESET_LINK = By.cssSelector("#reset_sidebar_link");
	public static final By LOGOUT_LINK = By.cssSelector("#logout_sidebar_link");
}
