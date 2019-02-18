package saucedemo.com.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucedemo.com.pageobjects.LoginPage;
import saucedemo.com.utils.Excel;


public class LoginTest extends BaseTest {



	@Test(priority=1, dataProvider="getDataFromExcel", description="try all login options")
	public void loginTests(String user,String password, String errorMsg) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.refreshPage();
		loginPage.login(user, password);
		if(loginPage.isCorrectUserAndPassword(user, password)) {
			Assert.assertTrue(loginPage.urlTest("https://www.saucedemo.com/inventory.html"));
			Assert.assertTrue(loginPage.titleTest("Swag Labs"));
		}
			
		else
			Assert.assertTrue(loginPage.errorMessageTest(errorMsg));
		

	}


	@DataProvider
	public Object[][] getDataFromExcel(){
		String excelPath = System.getProperty("user.dir") + "\\src\\data\\STD.xlsx";
		System.out.println(excelPath);
		Object[][] table = Excel.getTableArray(excelPath, "Login1");
		
		
		return table;
	}
	
	
	/*	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"","",							    "Epic sadface: Username is required"},
				{"","secret_sauce",				    "Epic sadface: Username is required"},
				{"standard_user","",			    "Epic sadface: Password is required"},
				{"standard_user",	"standard_user","Epic sadface: Username and password do not match any user in this service"},
				{"locked_out_user",	"secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
				{"standard_user",	"secret_sauce", ""},

		};
		return myData;
	}
*/


}
