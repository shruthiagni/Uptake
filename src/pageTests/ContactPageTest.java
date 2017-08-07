package pageTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Util_Constants;
import pageObjects.ContactPage;
import pageObjects.HomePage;
import pageObjects.Page;

public class ContactPageTest{
	
	ContactPage cpage = new ContactPage();
	 
	public static WebDriver driver;
	/*
	 * Set up browser and open the URL
	 */
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajb/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Util_Constants.URL);
		Page.timeWait(driver);
	}
	
	/*
	 * Test to check "get in touch" is present.
	 */
	@Test(priority=1)
	public void getInTouchTest(){
		Page.getElement(driver, HomePage.requestinfo_xpath).click();
		assertTrue(Page.getElement(driver,ContactPage.getInTouch_xpath).getText().contains("Get in Touch"));
	}
	
	/*
	 * Test makes sure that it displays errors if data is unfilled.
	 */
	@Test(priority=2)
	public void noDataFilled(){
		Page.getElement(driver, ContactPage.contactUs_xpath).click();
		assertEquals(cpage.hasErrors(driver), 6);
	}
	
	/*
	 * Test makes sure that it displays one error if wrong data is filled.
	 */
	@Test(priority=3)
	public void incorrectPhoneFilled(){
		driver.navigate().refresh();
		Page.fillInputbyID(driver,ContactPage.phone_id,"123");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		assertEquals(cpage.hasErrors(driver), 1);
	}
	
	/*
	 * Test makes sure correct data is filled and contact us button works.
	 */
	@Test(priority=4)
	public void allDataFilled(){
		driver.navigate().refresh();
		Page.fillInputbyID(driver, ContactPage.firstName_id, "test");
		Page.fillInputbyID(driver, ContactPage.lastName_id, "testTest");
		Page.fillInputbyID(driver, ContactPage.company_id, "Testing");
		Page.fillInputbyID(driver, ContactPage.email_id, "test@test.com");
		Page.fillInputbyID(driver, ContactPage.phone_id, "1234567891");
		Page.clickByID(driver, ContactPage.select_id);
		Select select = new Select(driver.findElement(By.id(ContactPage.select_id)));
		select.selectByValue("Other");
		Page.fillInputbyID(driver, ContactPage.message_id, "Testing 123");
		Page.getElement(driver, ContactPage.contactUs_xpath).click();
		assertTrue(driver.getCurrentUrl().contains(ContactPage.contactSuccessUrl));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
