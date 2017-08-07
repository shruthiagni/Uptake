package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Util_Constants;

public abstract class Page {
	
	/*
	 * Abstract page object class. Contains general class functions and utility functions. 
	 */
	
	/*
	 * Implicict time wait
	 */
	public static void timeWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Util_Constants.waitTime, TimeUnit.SECONDS);
	}
		
	/*
	 * Find element based on xpath
	 * @param driver
	 * @param id - locator xpath
	 */
	public static WebElement getElement(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	/*
	 * Find element based on its id
	 * @param driver
	 * @param name
	 */
	public static void clickByID(WebDriver driver, String name){
		driver.findElement(By.id(name)).click();
	}
	
	/*
	 * Fills input based on its id.
	 * @param name - input name
	 * @param value - input value
	 */
	public static void fillInputbyID(WebDriver driver, String name, String value) {
		driver.findElement(By.id(name)).sendKeys(value);
	}
	
	/*
	 * Wait function, helps with selenium issues with trying to call functions before page fully loaded. 
	 * @param driver
	 * @param item
	 */
	public static void waitUntilLoad(WebDriver driver,String item){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(item)));
	}
	
}
