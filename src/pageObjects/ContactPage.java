package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {

	WebElement element;

	public static String contactUs_xpath = "//*[@id='hsForm_c391fd6c-db94-4e29-9166-598f28f48702']/div[12]/div[2]/input";
	public static String firstName_id = "firstname-c391fd6c-db94-4e29-9166-598f28f48702";
	public static String lastName_id = "lastname-c391fd6c-db94-4e29-9166-598f28f48702";
	public static String company_id = "company-c391fd6c-db94-4e29-9166-598f28f48702";
	public static String email_id = "email-c391fd6c-db94-4e29-9166-598f28f48702";
	public static String phone_id = "phone-c391fd6c-db94-4e29-9166-598f28f48702";
	public static String select_id = "potential_interest_picklist-c391fd6c-db94-4e29-9166-598f28f48702";
	public static String message_id = "lead_description__c-c391fd6c-db94-4e29-9166-598f28f48702";
	public static String getInTouch_xpath = "//*[@id='hsForm_c391fd6c-db94-4e29-9166-598f28f48702']/div[1]/div";
	public static String contactSuccessUrl = "https://uptake.com/contact/success";

	/*
	 * Checks the number of errors on the page.
	 * @return returns number of errors
	 */
	public int hasErrors(WebDriver driver) {
		return (driver.findElements(By.className("error")).size());
	}

}
