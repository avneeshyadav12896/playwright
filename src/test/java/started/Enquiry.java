package started;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import utils.FileUtilities;

public class Enquiry {
	FileUtilities fiUtility = new FileUtilities();

	@Test
	public void influencerEnquiry() throws IOException {

		Browser browser = null;
		Page page = null;
		int number = SignUp.generateRandomNumber();
		String mobileNumber = SignUp.generateRandomMobileNumber();
		try {
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
			page = browser.newPage();
			page.navigate(fiUtility.readDataFromPropertyFiles("websiteURL"));
			page.locator("xpath=//a[normalize-space()='Get in Touch']").click();
			page.waitForTimeout(3000);
			page.locator("//div[@class='_cards_1tszw_210']//button[2]").click();
			Locator text4 = page.locator("xpath=//p[@class='_centered_header_jjp0j_190']");
			PlaywrightAssertions.assertThat(text4).hasText("Join as an Influencer");
			page.locator("css=#name").fill("Influcner Name " + number);
			page.locator("css=#contact_number").fill(mobileNumber);
			page.locator("css=#email_id").fill("avneesh.y+" + number + "@thecodebucket.com");
//			page.pause();
			page.getByRole(AriaRole.COMBOBOX).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Health & Wellness")).click();
			page.getByRole(AriaRole.IMG).nth(5).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Followers count (max among")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Followers count (max among"))
					.fill("12,3456");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Location*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Location*"))
					.fill("Village: Danapur, Post: Danapur. District: Patna");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram handle*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram handle*")).fill("@testing");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
			page.waitForTimeout(3000);
			page.navigate(fiUtility.readDataFromPropertyFiles("adminURL"));
			page.locator("css=#email").fill(fiUtility.readDataFromPropertyFiles("adminUN"));
			page.locator("css=#password").fill(fiUtility.readDataFromPropertyFiles("adminPWD"));
			page.locator("css=button[aria-label='Login'] span").click();
			page.locator("xpath=//span[normalize-space()='CRM']").click();
			page.locator("xpath=//button[normalize-space()='Influencers']").click();

			Locator nextButton = page.locator("css=button[aria-label='Next page']");
			while (!nextButton.isDisabled()) {
				nextButton.click();
				page.waitForLoadState();
			}

			Locator lastBrand = page.locator("css=tbody tr td:first-child").last();
			System.out.println(lastBrand.textContent());
			PlaywrightAssertions.assertThat(lastBrand).hasText("Influcner Name " + number);
			page.waitForTimeout(3000);
		} finally {
			page.close();
			browser.close();
		}
	}

	@Test
	public void brandEnquiry() throws IOException {
		Browser browser = null;
		Page page = null;
		int number = SignUp.generateRandomNumber();
		String mobileNumber = SignUp.generateRandomMobileNumber();
		try {
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			page = browser.newPage();
			page.navigate(fiUtility.readDataFromPropertyFiles("websiteURL"));
			page.locator("xpath=//a[normalize-space()='Get in Touch']").click();
			page.waitForTimeout(3000);
			page.locator("//div[@class='_cards_1tszw_210']//button[1]").click();
			Locator text4 = page.locator("xpath=//p[@class='_centered_header_jjp0j_190']");
			PlaywrightAssertions.assertThat(text4).hasText("Join as a Brand");
			page.locator("css=#brand_name").fill("Brand Name " + number);
			page.locator("css=#brand_number").fill(mobileNumber);
			page.locator("css=#brand_email_id").fill("avneesh.y+" + number + "@thecodebucket.com");
			page.locator("css=#point_of_contact_name").fill("POC test name");
			page.locator("css=#point_of_contact_number").fill(mobileNumber);
			page.locator("css=label[for='number_of_employees_in_your_company?']").fill("50");
			page.pause();
			page.getByRole(AriaRole.COMBOBOX).locator("div")
					.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Select$"))).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Health & Wellness")).click();
			page.getByRole(AriaRole.IMG).nth(5).click();
			page.locator("css=textarea[id='Full address of your company']")
					.fill("Test full address of your company like Village: Danapur, Post: Danapur. District: Patna");
			page.locator("xpath=//span[normalize-space()='Submit']").click();
			page.navigate(fiUtility.readDataFromPropertyFiles("adminURL"));
			page.locator("css=#email").fill(fiUtility.readDataFromPropertyFiles("adminUN"));
			page.locator("css=#password").fill(fiUtility.readDataFromPropertyFiles("adminPWD"));
			page.locator("css=button[aria-label='Login'] span").click();
			page.locator("xpath=//span[normalize-space()='CRM']").click();

			Locator nextButton = page.locator("css=button[aria-label='Next page']");
			while (!nextButton.isDisabled()) {
				nextButton.click();
				page.waitForLoadState();
			}

			Locator lastBrand = page.locator("css=tbody tr td:first-child").last();
			System.out.println(lastBrand.textContent());
			PlaywrightAssertions.assertThat(lastBrand).hasText("Brand Name " + number);
			page.waitForTimeout(3000);
		} finally {
			page.close();
			browser.close();
		}
	}
}
