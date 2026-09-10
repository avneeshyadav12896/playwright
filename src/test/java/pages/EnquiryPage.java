package pages;

import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EnquiryPage {

	private Page page;

	public EnquiryPage(Page page) {
		this.page = page;
	}

	public void openGetInTouch() {

		page.locator("xpath=//a[normalize-space()='Get in Touch']").click();
	}

	public void selectInfluencer() {

		page.locator("xpath=//div[@class='_cards_1tszw_210']//button[2]").click();
	}

	public void selectBrand() {

		page.locator("xpath=//div[@class='_cards_1tszw_210']//button[1]").click();
	}

	public void verifyInfluencerHeading() {

		Locator heading = page.locator("xpath=//p[@class='_centered_header_jjp0j_190']");

		heading.waitFor();

		if (!heading.textContent().equals("Join as an Influencer")) {
			throw new AssertionError("Expected 'Join as an Influencer' but found: " + heading.textContent());
		}
	}

	public void verifyBrandHeading() {

		Locator heading = page.locator("xpath=//p[@class='_centered_header_jjp0j_190']");

		heading.waitFor();

		if (!heading.textContent().equals("Join as a Brand")) {
			throw new AssertionError("Expected 'Join as a Brand' but found: " + heading.textContent());
		}
	}

	public void enterInfluencerName(String name) {

		page.locator("#name").fill(name);
	}

	public void enterInfluencerMobile(String mobile) {

		page.locator("#contact_number").fill(mobile);
	}

	public void enterInfluencerEmail(String email) {

		page.locator("#email_id").fill(email);
	}

	public void selectInfluencerCategory() {

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select")).click();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
	}

	public void enterFollowersCount(String followers) {

		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Followers count (max among"))
				.fill(followers);
	}

	public void enterInfluencerLocation(String location) {

		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Location*")).fill(location);
	}

	public void enterInstagramHandle(String instagramHandle) {

		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram handle*"))
				.fill(instagramHandle);
	}

	public void submitInfluencerEnquiry() {

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
	}

	// ---------------- BRAND ----------------

	public void enterBrandName(String name) {

		page.locator("#brand_name").fill(name);
	}

	public void enterBrandMobile(String mobile) {

		page.locator("#brand_number").fill(mobile);
	}

	public void enterBrandEmail(String email) {

		page.locator("#brand_email_id").fill(email);
	}

	public void enterPOCName(String name) {

		page.locator("#point_of_contact_name").fill(name);
	}

	public void enterPOCMobile(String mobile) {

		page.locator("#point_of_contact_number").fill(mobile);
	}

	public void enterEmployeeCount(String count) {

		page.locator("label[for='number_of_employees_in_your_company?']").fill(count);
	}

	public void selectBrandCategory() {

		page.getByRole(AriaRole.COMBOBOX).locator("div")
				.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Select$"))).click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Health & Wellness")).click();
		page.getByRole(AriaRole.IMG).nth(5).click();
	}

	public void enterCompanyAddress(String address) {

		page.locator("textarea[id='Full address of your company']").fill(address);
	}

	public void submitBrandEnquiry() {

		page.locator("xpath=//span[normalize-space()='Submit']").click();
	}

	public void selectInfluencerCategories(String category1, String category2) {
		page.getByRole(AriaRole.COMBOBOX).click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(category1)).click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(category2)).click();
		page.getByRole(AriaRole.IMG).nth(5).click();
	}
}