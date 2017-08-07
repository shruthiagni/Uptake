package pageTests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Util_Constants;
import pageObjects.HomePage;
import pageObjects.Page;

public class HomePageTest {

	public static WebDriver driver;
	HomePage hpage = new HomePage();
	/*
	 * Set up browser and open the URL
	 */
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajb/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Util_Constants.URL);
		HomePage.timeWait(driver);
	}

	/*
	 * Test About menu and url
	 */
	@Test(priority = 1)
	public void aboutMenuClick() {
		hpage.menuClick(driver, HomePage.about_xpath, Util_Constants.aboutTitle, HomePage.aboutContent_xpath,
				Util_Constants.aboutUrl);
	}

	/*
	 * Test the Uptake menu if it is able to navigate back to home page Check
	 * the url
	 */
	@Test(priority = 2)
	public void uptakeImageClick() {

		Assert.assertEquals(Page.getElement(driver, HomePage.uptake_xpath).isDisplayed(), true);
		Page.getElement(driver, HomePage.uptake_xpath).click();

		Page.waitUntilLoad(driver, HomePage.uptakeContent_xpath);
		String newurl1 = driver.getCurrentUrl();
		Assert.assertEquals(newurl1, Util_Constants.URL);

	}

	/*
	 * Test Learn more button
	 */
	@Test(priority = 3)
	public void learnMoreButton() {

		assertTrue(HomePage.getElement(driver, HomePage.learnmore_xpath).getText()
				.equalsIgnoreCase(Util_Constants.learnMore));
		Assert.assertEquals(HomePage.getElement(driver, HomePage.learnmore_xpath).isDisplayed(), true);
		Page.getElement(driver, HomePage.learnmore_xpath).click();
		Assert.assertEquals(driver.getCurrentUrl(), Util_Constants.aboutUrl);
		Page.waitUntilLoad(driver, HomePage.learnmoreContent_xpath);
	}

	/*
	 * Test the Products menu and url
	 */
	@Test(priority = 4)
	public void productsMenuClick() {

		hpage.menuClick(driver, HomePage.products_xpath, Util_Constants.productsTitle, HomePage.productsContent_xpath,
				Util_Constants.productsUrl);

	}

	/*
	 * Test the Industries menu and url
	 */
	@Test(priority = 5)
	public void industriesMenuClick() {

		hpage.menuClick(driver, HomePage.industries_xpath, Util_Constants.industriesTitle,
				HomePage.industriesContent_xpath, Util_Constants.industriesUrl);

	}

	/*
	 * Test the Newsroom menu and url
	 */
	@Test(priority = 6)
	public void newsroomMenuClick() {

		hpage.menuClick(driver, HomePage.newsroom_xpath, Util_Constants.newsroomTitle, HomePage.newsContent_xpath,
				Util_Constants.newsroomUrl);
	}

	/*
	 * Test the Beyond.uptake menu and url
	 */
	@Test(priority = 7)
	public void beyondUptakeMenuClick() {
		String actualBeyondTitle = HomePage.getElement(driver, HomePage.beyond_xpath).getText();
		assertTrue(actualBeyondTitle.equalsIgnoreCase(Util_Constants.beyond_uptakeTitle));
		Page.getElement(driver, HomePage.beyond_xpath).click();
		hpage.checkNewWindow(driver, HomePage.beyondContent_xpath, Util_Constants.beyondUrl);
	}

	/*
	 * Test the Blog menu and url
	 */

	@Test(priority = 8)
	public void blogMenuClick() {

		String actualBlogTitle = HomePage.getElement(driver, HomePage.blog_xpath).getText();
		assertTrue(actualBlogTitle.equalsIgnoreCase(Util_Constants.blogTitle));
		Page.getElement(driver, HomePage.blog_xpath).click();

		hpage.checkNewWindow(driver, HomePage.blogContent_xpath, Util_Constants.blogUrl);

	}

	/*
	 * Test the Request info button and url
	 */
	@Test(priority = 9)
	public static void requestMoreInfoButton() {

		String actualInfoTitle = HomePage.getElement(driver, HomePage.requestinfo_xpath).getText();
		assertTrue(actualInfoTitle.equalsIgnoreCase(Util_Constants.requestInfo));

		Assert.assertEquals(HomePage.getElement(driver, HomePage.requestinfo_xpath).isDisplayed(), true);
		Page.getElement(driver, HomePage.requestinfo_xpath).click();

		Assert.assertEquals(driver.getCurrentUrl(), Util_Constants.contactUrl);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
