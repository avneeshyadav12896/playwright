package started;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import utils.FileUtilities;

public class SignUp {
	FileUtilities fileUtility = new FileUtilities();

	public static int generateRandomNumber() {
		int number = ThreadLocalRandom.current().nextInt(10000, 100000);
		return number;
	}

	public static String generateRandomMobileNumber() {
		long number = ThreadLocalRandom.current().nextLong(2000000000L, 5000000000L);
		return String.valueOf(number);
	}

	Faker faker = new Faker();

	@Test
	public void brandSignUpCheckWithNoGSTAndPAN() throws IOException {
		Browser browser = null;
		Page page = null;
		int number = SignUp.generateRandomNumber();
		try {
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
			page = browser.newPage();

			page.navigate(fileUtility.readDataFromPropertyFiles("brandURL"));

			PlaywrightAssertions.assertThat(page).hasTitle("Influency");
			page.waitForTimeout(2000);
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an account")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"))
					.fill("avneesh.y+" + number + "@thecodebucket.com");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send OTP")).click();
			page.getByRole(AriaRole.TEXTBOX).first().click();
			page.getByRole(AriaRole.TEXTBOX).first().fill("1");
			page.getByRole(AriaRole.TEXTBOX).nth(1).fill("2");
			page.getByRole(AriaRole.TEXTBOX).nth(2).fill("3");
			page.getByRole(AriaRole.TEXTBOX).nth(3).fill("4");
			page.getByRole(AriaRole.TEXTBOX).nth(4).fill("5");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Brand Name*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Brand Name*")).fill("Brand" + number);
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*").setExact(true)).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*").setExact(true))
					.fill("Password@123");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Confirm Password*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Confirm Password*"))
					.fill("Password@123");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save & Next")).click();
			page.locator("//div[@class='_custom_design_1xh91_177']")
					.setInputFiles(Paths.get("src/test/resources/images.jpeg"));
			page.waitForTimeout(3000);
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Crop & Confirm")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Describe your brand's primary"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Describe your brand's primary"))
					.fill("test");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What is the number of")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What is the number of")).fill("30");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();

			page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions()
					.setName("I confirm that my company does not have a GST or Shop License number.")).check();
			page.getByRole(AriaRole.RADIO,
					new Page.GetByRoleOptions().setName("I confirm that my company does not have a PAN")).check();
			page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions()
					.setName("I confirm that my company does not have a GST or Shop License number.")).check();
			page.getByRole(AriaRole.RADIO,
					new Page.GetByRoleOptions().setName("I confirm that my company does not have a PAN")).check();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Name*"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Name*"))
					.fill("Avneesh");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Email*"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Email*"))
					.fill("avniy@gmai.com");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Phone*"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Phone*"))
					.fill("1234575765");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website"))
					.fill("https://influency.codebucketstage.online/brand/onboarding");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Location*")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bekal")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram User Name")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram User Name"))
					.fill("Testing" + number);
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Followers")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Followers")).fill("2,3232");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Following")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Following")).fill("3");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Following")).dblclick();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Posts")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Posts")).fill("23");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
			page.getByText("Food & Beverages").click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Finish Setup")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Check Status")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Refresh Status")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log Out")).click();
			page.navigate(fileUtility.readDataFromPropertyFiles("adminURL"));
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*"))
					.fill(fileUtility.readDataFromPropertyFiles("adminUN"));
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*"))
					.fill(fileUtility.readDataFromPropertyFiles("adminPWD"));
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("icon Brands")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("avatar Brand" + number + " avneesh."))
					.click();
			page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Brand" + number)).click();
			PlaywrightAssertions
					.assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Brand" + number)))
					.isVisible();
			page.waitForTimeout(2000);
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Super Admin")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log Out")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
		} finally {
			page.close();
			browser.close();
		}
	}

	@Test
	public void brandSignUpCheckWithGSTAndPAN() throws IOException {
		Browser browser = null;
		Page page = null;
		int number = SignUp.generateRandomNumber();
		try {
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
			page = browser.newPage();

			page.navigate(fileUtility.readDataFromPropertyFiles("brandURL"));

			PlaywrightAssertions.assertThat(page).hasTitle("Influency");
			page.waitForTimeout(2000);
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an account")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"))
					.fill("avneesh.y+" + number + "@thecodebucket.com");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send OTP")).click();
			page.getByRole(AriaRole.TEXTBOX).first().click();
			page.getByRole(AriaRole.TEXTBOX).first().fill("1");
			page.getByRole(AriaRole.TEXTBOX).nth(1).fill("2");
			page.getByRole(AriaRole.TEXTBOX).nth(2).fill("3");
			page.getByRole(AriaRole.TEXTBOX).nth(3).fill("4");
			page.getByRole(AriaRole.TEXTBOX).nth(4).fill("5");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Brand Name*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Brand Name*")).fill("Brand" + number);
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*").setExact(true)).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*").setExact(true))
					.fill("Password@123");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Confirm Password*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Confirm Password*"))
					.fill("Password@123");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save & Next")).click();
			page.locator("//div[@class='_custom_design_1xh91_177']")
					.setInputFiles(Paths.get("src/test/resources/images.jpeg"));
			page.waitForTimeout(3000);
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Crop & Confirm")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Describe your brand's primary"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Describe your brand's primary"))
					.fill("test");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What is the number of")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What is the number of")).fill("30");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
			
			page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Yes")).first().check();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("GST or Shop License Number*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("GST or Shop License Number*")).fill("GSTIN"+number);
		    page.getByLabel("Upload File").locator("div").setInputFiles(Paths.get("src/test/resources/pdf_file-sample_150kB.pdf"));
		    page.waitForTimeout(3000);
		    page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Yes")).nth(1).check();
		    page.pause();
		    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Click to upload \\*Only PDF\\. Maximum size is 2 MB\\*$"))).nth(2).setInputFiles(Paths.get("src/test/resources/pdf_file-sample_150kB.pdf"));
		    page.waitForTimeout(3000);
		    page.locator("div").nth(2).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Name*"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Name*"))
					.fill("Avneesh");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Email*"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Email*"))
					.fill("avniy@gmai.com");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Phone*"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("POC (Point of Contact) Phone*"))
					.fill("1234575765");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website"))
					.fill("https://influency.codebucketstage.online/brand/onboarding");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Location*")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bekal")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram User Name")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram User Name"))
					.fill("Testing" + number);
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Followers")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Followers")).fill("2,3232");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Following")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Following")).fill("3");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Following")).dblclick();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Posts")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Posts")).fill("23");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
			page.getByText("Food & Beverages").click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Finish Setup")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Check Status")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Refresh Status")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log Out")).click();
			page.navigate(fileUtility.readDataFromPropertyFiles("adminURL"));
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*"))
					.fill(fileUtility.readDataFromPropertyFiles("adminUN"));
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*"))
					.fill(fileUtility.readDataFromPropertyFiles("adminPWD"));
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("icon Brands")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("avatar Brand" + number + " avneesh."))
					.click();
			page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Brand" + number)).click();
			PlaywrightAssertions
					.assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Brand" + number)))
					.isVisible();			
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Super Admin")).click();
			page.waitForTimeout(2000);
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log Out")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
		} finally {
			page.close();
			browser.close();
		}
	}

	@Test
	public void influencerSignUp() throws IOException {
		Browser browser = null;
		Page page = null;
		int number = SignUp.generateRandomNumber();
		String mobileNumber = SignUp.generateRandomMobileNumber();
		try {
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(400));
			page = browser.newPage();
			page.navigate(fileUtility.readDataFromPropertyFiles("influencerURL"));
			page.locator("xpath=//a[normalize-space()='Create an account']").click();
			page.locator("css=#email-address").fill("avneesh.y+" + number + "@thecodebucket.com");
//		 page.waitForTimeout(5000);
			page.locator("css=button[aria-label='Get OTP'] span").click();
			page.waitForTimeout(2000);
			page.locator("css=input:nth-child(1)").fill("1");
			page.locator("css=input:nth-child(2)").fill("2");
			page.locator("css=input:nth-child(3)").fill("3");
			page.locator("css=input:nth-child(4)").fill("4");
			page.locator("css=input:nth-child(5)").fill("5");
			page.locator("css=button[aria-label='Verify'] span").click();
			page.waitForTimeout(2000);
			page.locator("css=#avatar-upload").setInputFiles(Paths.get("src/test/resources/images.jpeg"));
			page.waitForTimeout(2000);
			page.locator("xpath=//button[normalize-space()='Crop & Confirm']").click();
			page.locator("css=#full-name").fill("Avneesh" + number);
			page.locator("css=#phone-number").fill(mobileNumber);
			page.locator("xpath=//input[@id='dob']").click();
			page.keyboard().press("Enter");

			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Location*")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Alappuzha")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("About *")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("About *")).fill("test");
			page.getByRole(AriaRole.COMBOBOX).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
			page.locator("svg").nth(4).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram User Name*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Instagram User Name*"))
					.fill("testing" + number);

			page.locator("css=#instagram").fill("testing" + number);
			page.locator("css=#followers").fill("12" + number);
			page.locator("css=#following").fill("1" + number);
			page.locator("css=#posts").fill("1223");
			page.locator("css=input[type='checkbox']").click();
			page.locator("css=button[aria-label='Continue'] span").click();
			Locator text3 = page.locator("xpath=//button[normalize-space()='Go to Sign In']");
			System.out.print(text3.textContent());
			PlaywrightAssertions.assertThat(text3).hasText("Go to Sign In");
			page.waitForTimeout(2000);
			page.navigate(fileUtility.readDataFromPropertyFiles("adminURL"));
			page.locator("css=#email").fill(fileUtility.readDataFromPropertyFiles("adminUN"));
			page.locator("css=#password").fill(fileUtility.readDataFromPropertyFiles("adminPWD"));
			page.locator("css=button[aria-label='Login'] span").click();
			page.locator("xpath=//span[normalize-space()='Influencer']").click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("avatar Avneesh" + number + " @"))
					.click();
			page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Avneesh" + number)).click();
			PlaywrightAssertions
					.assertThat(
							page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Avneesh" + number)))
					.isVisible();
			page.waitForTimeout(3000);
		}

		finally {
			page.close();
			browser.close();
		}
	}

	public void autoLoginFeatureCheck() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://influency.codebucketstage.online/influencer");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address*"))
					.fill("avneesh.y+151@thecodebucket.com");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get OTP")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get OTP")).click();
			page.getByRole(AriaRole.TEXTBOX).first().click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address*"))
					.fill("avneesh.y+151@thecodebucket.com");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get OTP")).click();
			page.getByRole(AriaRole.TEXTBOX).first().click();
			page.getByRole(AriaRole.TEXTBOX).first().fill("6");
			page.getByRole(AriaRole.TEXTBOX).nth(1).fill("6");
			page.getByRole(AriaRole.TEXTBOX).nth(2).fill("6");
			page.getByRole(AriaRole.TEXTBOX).nth(3).fill("9");
			page.getByRole(AriaRole.TEXTBOX).nth(4).fill("7");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
			context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("login.json")));
		}
	}

}
