package saucedemo.com.pageobjects;

import org.openqa.selenium.WebDriver;
import locators.LoginLocators;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}


	public void login(String user, String password) {
		fillText(LoginLocators.USER_INPUT, user);
		fillText(LoginLocators.PASSWORD_INPUT, password);
		click(LoginLocators.LOGIN_BTN);

	}

	
	public boolean isCorrectUserAndPassword(String user, String password) {
		if(((user.equals("standard_user")) && (password.equals("secret_sauce"))))
			return true;
		else return false;
		
	}
	
	public boolean errorMessageTest(String error) {
		highlightTheError(LoginLocators.ERROR_MSG);
		if(elementFromBy(LoginLocators.ERROR_MSG).getText().equals(error))
			return true;
		else return false;
	}



/*	public void userInputVisibilityTest() {
		visibilityTest(userInput, "User input is not visible.");
	}
	
	public void passwordInputVisibilityTest() {
		visibilityTest(passwordInput, "Password input is not visible.");
	}
	
	public void loginButtonVisibilityTest() {
		visibilityTest(loginBtn, "Login button is not visible.");
	}
	
	public void infoBoxVisibilityTest() {
		String textInsideBox = "The currently accepted usernames for this application are:\n\nstandard_user\nlocked_out_user\nproblem_user\n\nAnd the password for all users is:\n\nsecret_sauce";
		visibilityTest(infoElement,textInsideBox, "The info box is not visible.");
	}
	
	
	public void allElementsVisibilityTest() {
	titleTest("Swag Labs");
	userInputVisibilityTest();
	passwordInputVisibilityTest();
	loginButtonVisibilityTest();
	infoBoxVisibilityTest();
	wait(5000);
}*/

}
