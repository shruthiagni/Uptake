package pageObjects;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Page;

public class HomePage extends Page {

	WebElement element;

	public static String about_xpath = "//*[@id='header']/div[1]/nav/a[1]";
	public static String uptake_xpath = "//*[@id='header']/div[1]/div[1]/a/img";
	public static String learnmore_xpath = "//*[@id='home']/div[1]/div/div[1]/div/button";
	public static String products_xpath = "//*[@id='header']/div[1]/nav/a[2]";
	public static String industries_xpath = "//*[@id='header']/div[1]/nav/a[3]";
	public static String newsroom_xpath = "//*[@id='header']/div[1]/nav/a[4]";
	public static String beyond_xpath = "//*[@id='header']/div[1]/nav/a[5]";
	public static String blog_xpath = "//*[@id='header']/div[1]/nav/a[6]";
	public static String requestinfo_xpath = "//*[@id='header']/div[1]/div[2]/button";

	public static String aboutContent_xpath = "//*[@id='about']/div[1]/div/div/div[1]/div[2]/p";
	public static String uptakeContent_xpath = "//*[@id='home']/div[1]/div/div[1]/div/div[1]/p";
	public static String learnmoreContent_xpath = "//*[@id='about']/div[1]/div/div/div[1]/div[2]/p";
	public static String productsContent_xpath = "//*[@id='products']/div[1]/div/div/div[1]";
	public static String industriesContent_xpath = "//*[@id='industries']/div[1]/div[1]";
	public static String newsContent_xpath = "//*[@id='newsroom']/div[1]/h1";
	public static String beyondContent_xpath = "//*[@id='page-top']/header/div/div/div";
	public static String blogContent_xpath = "/html/body/header/div/nav/div/p";

	/**
	 * Finds the number of elements of a certain type on the page.
	 * @param driver
	 * @param testType - method name
	 * @param menuName - name of the menu item
	 * @param id - xpath locator
	 * @param url- url of the each of the menu item
	 * @return
	 */
	public void menuClick(WebDriver driver, String locator, String menuName, String id, String url) {
		String actualTitle = Page.getElement(driver, locator).getText();
		assertTrue(actualTitle.equalsIgnoreCase(menuName));
		Page.getElement(driver, locator).click();
		Page.waitUntilLoad(driver, id);
		String newurl = driver.getCurrentUrl();
		Assert.assertEquals(newurl, url);
	}

	/**
	 * Window switching function that switches to the newest window
	 * @param driver
	 * @param id - xpath locator
	 * @param url - url of the menu item
	 */
	public void checkNewWindow(WebDriver driver, String id, String url) {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Page.waitUntilLoad(driver, id);
		String newurl5 = driver.getCurrentUrl();
		Assert.assertEquals(newurl5, url);
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}
}
