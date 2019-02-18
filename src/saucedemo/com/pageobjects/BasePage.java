package saucedemo.com.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 10,500);
		PageFactory.initElements(driver, this);
	}

	public void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void refreshPage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public boolean urlTest(String url) {
		if(getURL().equals(url))
			return true;
		else return false;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean titleTest(String title) {
		if(getTitle().equals(title))
			return true;
		else return false;
	}

	public void alertOK() {
		driver.switchTo().alert().accept();
	}

	public WebElement elementFromBy(By by) {
		return driver.findElement(by);
	}

	public List<WebElement> elementsFromBy(By by) {
		return driver.findElements(by);
	}

	public void hoverMouse(By by) {
		Actions action = new Actions(driver);
		action.moveToElement(elementFromBy(by)).build().perform();
	}

	public String getText(By by) {
		highlightElement(by);
		return elementFromBy(by).getText();
	}

	public void clearText(By by) {
		elementFromBy(by).clear();
	}

	public void fillText(By by, String text) {
		highlightElement(by);
		wait(100);
		clearText(by);
		elementFromBy(by).sendKeys(text);
	}

	public void pressEnter(By by) {
		elementFromBy(by).sendKeys(Keys.RETURN);
	}

	public void click(By by) {
		highlightElement(by);
		elementFromBy(by).click();
	}
	
	public void clickByPosition(By by,int position) {
		driver.findElements(by).get(position).click();
	}

	public void waitClick(By by){
		// using wait to reco if element is clickable

		for(int i=0;i<=5;i++) {
			try {
				WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(by));
				element.click();
				break;
			}
			catch(StaleElementReferenceException  e){
				e.printStackTrace();
				continue;
			}

		}

	}

	public void select(By by,String value) {
		Select dropdown = new Select(elementFromBy(by));
		dropdown.selectByValue(value);

	}

	public WebElement elementByPositionAtList(By by,int position) {

		List<WebElement> list = elementsFromBy(by);
		return list.get(position);
	}

	protected void highlightElement(By by) {
		hoverMouse(by);
		String originalStyle = elementFromBy(by).getAttribute("style");

		int r = 255;
		int g = 255;
		int b = 255;
		for (int i=255;i>=150;i-=4) {

			String color = String.format("#%02x%02x%02x", r, g, b);
			String newStyle = "background:" + color + ";" + originalStyle;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",elementFromBy(by));
			r=i;
			b=i;
		}

	}

	protected void highlightTheError(By by) {
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elementFromBy(by));
		wait(500);
	}

}