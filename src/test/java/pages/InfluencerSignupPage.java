package pages;

import java.io.IOException;
import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import started.SignUp;
import utils.FileUtilities;
import utils.PlaywrightManager;

public class InfluencerSignupPage {

	private final Page page;
	private final FileUtilities fileUtility;

	private int number;
	private String mobileNumber;

	public InfluencerSignupPage() {
		page = PlaywrightManager.getPage();
		fileUtility = new FileUtilities();
	}

	public void openInfluencerSignup() throws IOException {

		page.navigate(fileUtility.readDataFromPropertyFiles("influencerURL"));

		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an account")).click();
	}

	public void createInfluencerAccount() {

		number = SignUp.generateRandomNumber();
		mobileNumber = SignUp.generateRandomMobileNumber();

		page.locator("#email-address").fill("avneesh.y+" + number + "@thecodebucket.com");

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get OTP")).click();

		page.waitForTimeout(2000);
	}

	public void verifyOTP() {

		Locator otpInputs = page.locator("input");

		otpInputs.nth(0).fill("1");
		otpInputs.nth(1).fill("2");
		otpInputs.nth(2).fill("3");
		otpInputs.nth(3).fill("4");
		otpInputs.nth(4).fill("5");

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();

		page.waitForTimeout(2000);
	}

	public void uploadProfileImage() {

		page.locator("#avatar-upload").setInputFiles(Paths.get("src/test/resources/images.jpeg"));

		page.waitForTimeout(2000);

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Crop & Confirm")).click();
	}

	public void enterProfileDetails() {

		page.locator("#full-name").fill("Avneesh" + number);

		page.locator("#phone-number").fill(mobileNumber);

		page.locator("#dob").click();

		page.keyboard().press("Enter");

		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("About *")).fill("test");
	}

	public void selectLocationAndCategory() {

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Location*")).click();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Alappuzha")).click();

		page.getByRole(AriaRole.COMBOBOX).click();

		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
		page.locator("svg").nth(4).click();
	}

	public void enterInstagramDetails() {

		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram User Name*"))
				.fill("testing" + number);

		page.locator("#instagram").fill("testing" + number);

		page.locator("#followers").fill("12" + number);

		page.locator("#following").fill("1" + number);

		page.locator("#posts").fill("1223");

		page.locator("input[type='checkbox']").click();
	}

	public void completeSignup() {

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
	}

	public void verifySignupCompleted() {

		Locator signInButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go to Sign In"));

		PlaywrightAssertions.assertThat(signInButton).hasText("Go to Sign In");
	}

	public void clickOnInfluencer() {
		page.locator("xpath=//span[normalize-space()='Influencer']").click();
	}

	public void openNewCreator() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("avatar Avneesh" + number + " @")).click();
		page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Avneesh" + number)).click();
		PlaywrightAssertions
				.assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Avneesh" + number)))
				.isVisible();
		page.waitForTimeout(3000);
	}

	public int getNumber() {
		return number;
	}
}