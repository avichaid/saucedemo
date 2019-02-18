package locators;

import org.openqa.selenium.By;

public class LoginLocators {

	public static final By USER_INPUT = By.cssSelector("[placeholder='Username']");
	public static final By PASSWORD_INPUT = By.cssSelector("[placeholder='Password']");
	public static final By LOGIN_BTN = By.cssSelector("[value='LOGIN']");
	public static final By INFO_TEXT = By.id("login_credentials");
	public static final By ERROR_MSG = By.cssSelector("[data-test='error']");
	
}
