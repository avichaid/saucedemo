package saucedemo.com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import locators.BurgerMenuLocators;
import saucedemo.com.pageobjects.AllItemPage;
import saucedemo.com.pageobjects.LoginPage;

public class AllItemsTest extends BaseTest {


	@BeforeClass
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
	}

	@Test(priority=1)
	public void burgerOpenCloseTest() {
		AllItemPage allItemPage = new AllItemPage(driver);
		allItemPage.openBurgerMenu();
		allItemPage.wait(2000);
		allItemPage.closeBurgerMenu();
	}
	
	

	@Test(priority=2)
	public void allItemsLinkTest() {
		AllItemPage allItemPage = new AllItemPage(driver);
		allItemPage.openBurgerMenu();
		allItemPage.wait(200);
		allItemPage.clickAllItemsLink();
	}
	
	
	@Test(priority=3)
	public void resetLinkTest() {
		AllItemPage allItemPage = new AllItemPage(driver);
		allItemPage.openBurgerMenu();
		allItemPage.wait(200);
		allItemPage.clickResetLink();
		}	

	

	
	@Test(priority=8)
	public void aboutLinkTest() {
		AllItemPage allItemPage = new AllItemPage(driver);
		allItemPage.openBurgerMenu();
		allItemPage.wait(200);
		allItemPage.click(BurgerMenuLocators.ABOUT_LINK);
	}
	

	


}
