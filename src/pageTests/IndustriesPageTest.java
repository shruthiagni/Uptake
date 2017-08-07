package pageTests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Util_Constants;
import pageObjects.IndustriesPage;
import pageObjects.Page;
import pageObjects.HomePage;

public class IndustriesPageTest{
	public static WebDriver driver;

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
	 * Test to click industries and check the content
	 */
	@Test(priority = 1)
	public void industriesMenuClick() {
		Page.getElement(driver, HomePage.industries_xpath).click();
		assertTrue(Page.getElement(driver,HomePage.industriesContent_xpath).getText().contains("Built to scale insights across global industries"));
	}
	
	/*
	 * Test to list the bubble elements
	 */
	@Test(priority=2)
	public void getAllBubbles(){
		WebElement bubble_list = driver.findElement(By.cssSelector(IndustriesPage.bubble_css));
		List<WebElement> bubble_element = bubble_list.findElements(By.className("bubble"));
		for (WebElement element : bubble_element) {
			assertTrue(element.getAttribute("class").contains("bubble industry"));
		}
	}
	
	/*
	 * Test to click agriculture bubble and check content
	 */
	@Test(priority=3)
	public void agricultureBubbleClick() throws InterruptedException{
		Page.getElement(driver, IndustriesPage.agriculture_xpath).click();
		Page.waitUntilLoad(driver,IndustriesPage.agricultureMain_xpath);
		assertTrue(Page.getElement(driver,IndustriesPage.agricultureMain_xpath).getText().equals("Optimize field management decisions"));
	}
	
	/*
	 * Test to scroll down and check content
	 */
	@Test(priority=4)
	public void agricultureScrollDown() {
		driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		Page.waitUntilLoad(driver,IndustriesPage.agricultureScroll_xpath);
		assertTrue(Page.getElement(driver,IndustriesPage.agricultureScroll_xpath).getText().equals("Make smart irrigation smarter"));
	}
	
	/*
	 * Test to click back button and check url
	 */
	@Test(priority=5)
	public void agricultureBackButton() {
		Page.getElement(driver,IndustriesPage.backButton).click();
		Page.waitUntilLoad(driver,HomePage.industriesContent_xpath);
		assertTrue(driver.getCurrentUrl().equals(Util_Constants.industriesUrl));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
