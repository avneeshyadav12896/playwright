package started;

import java.io.IOException;
import java.nio.file.Paths;
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

public class E2E {
	FileUtilities fileUtility = new FileUtilities();

	@Test
	public void e2eMonetaryCampaign() throws IOException
	{		
		Browser browser = null;
		Page page = null;
		Faker faker=new Faker();
		int number=SignUp.generateRandomNumber();
		try {
		 browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
		 page = browser.newPage();
		 page.navigate(fileUtility.readDataFromPropertyFiles("brandURL"));
		 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).fill(fileUtility.readDataFromPropertyFiles("brandUN"));
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).fill(fileUtility.readDataFromPropertyFiles("brandPWD"));
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		    		   
		    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("icon Campaigns")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New Campaign")).click();
		    page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Online")).check();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Name*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Name*")).fill("Campaign"+number);
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Campaign Category*")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Start Date*")).fill("2026-09-07");
		    page.getByText("Click to upload *Only PNG or").setInputFiles(Paths.get("src/test/resources/images.jpeg"));

		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign End Date*")).fill("2026-09-14");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Deliverable Date*")).fill("2026-09-14");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Start Time")).fill("04:04");
		    page.getByText("Campaign End Date - The last").click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Description*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Description*")).fill("Campaign status is the duration of campaign that the influencers or the creators need to complete by");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Influencer's Location*")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Any")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min No. of Followers *")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min No. of Followers *")).fill("1212");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Category*")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Health & Wellness")).click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Min Age")).click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Min Age")).fill("22");
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Max Age")).click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Max Age")).fill("55");
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of influencers")).click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of influencers")).fill("2");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Deliverables Direction*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Deliverables Direction*")).fill("ertxd dfgdsfg dsfgsdfgsdfg dfg");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Hashtags")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Hashtags")).fill("#test");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mentions")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mentions")).fill("@test");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Social Media Platform*")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Instagram")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Content Type*")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Post")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Quantity*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Quantity*")).fill("1");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Offer’s Terms and Conditions*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Offer’s Terms and Conditions*")).fill("fdgd dfg dfgdff dfgdf ");
		    page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Monetary Campaign")).check();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Cost per Influencer*")).click();
		    page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Monetary Campaign")).press("1");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Cost per Influencer*")).fill("₹1002");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Influencers*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Influencers*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Influencers*")).fill("2");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Publish")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Publish Campaign")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View Campaign")).click();
		    PlaywrightAssertions.assertThat(page.getByText("Campaign"+number)).isVisible();
	    
		    
            BrowserContext influencerContext = browser.newContext(new Browser.NewContextOptions()
			        .setStorageStatePath(Paths.get("login.json")));
			Page influencerPage = influencerContext.newPage();
			influencerPage.navigate("https://influency.codebucketstage.online/influencer/dashboard");
		    
		    
		    
		    influencerContext = browser.newContext(new Browser.NewContextOptions());
		    influencerPage = influencerContext.newPage();
		    influencerPage.navigate(fileUtility.readDataFromPropertyFiles("influencerURL"));
		    
		    influencerPage.locator("xpath=//input[@id='email_address']").fill(fileUtility.readDataFromPropertyFiles("influencerEmail"));
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get OTP")).click();
		    influencerPage.waitForTimeout(2000);
		    influencerPage.getByRole(AriaRole.TEXTBOX).first().click();
		    influencerPage.getByRole(AriaRole.TEXTBOX).first().fill("1");
		    influencerPage.getByRole(AriaRole.TEXTBOX).nth(1).click();
		    influencerPage.getByRole(AriaRole.TEXTBOX).nth(1).fill("2");
		    influencerPage.getByRole(AriaRole.TEXTBOX).nth(2).click();
		    influencerPage.getByRole(AriaRole.TEXTBOX).nth(2).fill("3");
		    influencerPage.getByRole(AriaRole.TEXTBOX).nth(3).click();
		    influencerPage.getByRole(AriaRole.TEXTBOX).nth(3).fill("4");
		    influencerPage.getByRole(AriaRole.TEXTBOX).nth(4).click();
		    influencerPage.getByRole(AriaRole.TEXTBOX).nth(4).fill("5");
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
		    influencerPage.pause();
		    influencerPage.reload();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View Campaign"+number)).nth(1).click();
		    PlaywrightAssertions.assertThat(influencerPage.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Campaign"+number))).isVisible();
		    influencerPage.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("I Agree to Influency's Terms")).check();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply")).click();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Date")).click();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("7")).first().click();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send Request")).click();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Explore Campaign")).click();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View Campaign48153")).click();
		    PlaywrightAssertions.assertThat(influencerPage.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Campaign"+number))).isVisible();
		    influencerPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Influencer Profile Profile")).click();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("logout Log Out arrow")).click();
		    influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
			    influencerPage.close();
			    
			    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("icon Campaigns")).click();
			    
			    page.pause();
			    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ongoing 06-Sept-2026 brand logo Campaign43084 0 Influencers Get Paid test")).click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+")).click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay")).click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm & Pay ₹")).click();
			    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Wallets")).click();
			    page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Wallet icon PhonePe")).click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Pay")).click();
			    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("OTP")).click();
			    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("OTP")).fill("111000");
			    page.getByText("SUCCESS").click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back to Campaign")).click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active")).click();
			    PlaywrightAssertions.assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("profile_photo Avneesh23233 @"))).isVisible();
			    PlaywrightAssertions.assertThat(page.getByText("Campaign"+number+"Active")).isVisible();
			    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Brand81991 Brand81991")).click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout Log Out arrow")).click();
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log Out").setExact(true)).click();
		}
		finally{
			 page.close();
			 browser.close();
		}
	}

	@Test
	public void e2eBarterCampaign() throws IOException {
		Browser browser = null;
		Page page = null;
		Faker faker = new Faker();
		int number = SignUp.generateRandomNumber();
		try {
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			page = browser.newPage();
			page.navigate(fileUtility.readDataFromPropertyFiles("brandURL"));
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*"))
					.fill(fileUtility.readDataFromPropertyFiles("brandUN"));
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*"))
					.fill(fileUtility.readDataFromPropertyFiles("brandPWD"));
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("icon Campaigns")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Campaigns")).click();
			page.getByText("In-Person").click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Location*")).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Alappuzha")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Name*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Name*"))
					.fill("Campaign" + number);
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Campaign Category*")).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
			page.getByLabel("Click to upload *Only PNG or").setInputFiles(Paths.get("src/test/resources/images.jpeg"));
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Start Date*"))
					.fill("2026-08-08");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign End Date*"))
					.fill("2026-08-15");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Deliverables Date*"))
					.fill("2026-08-22");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Description*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Description*"))
					.fill(faker.lorem().sentence(30));
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Influencer's Location*")).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Any")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min No. of Followers *")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min No. of Followers *"))
					.fill("1,0000");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Category*")).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
			page.getByText("Category *").click();
			page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Min Age")).click();
			page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Min Age")).fill("23");
			page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Max Age")).click();
			page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Max Age")).fill("45");
			page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of influencers that"))
					.click();
			page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of influencers that"))
					.fill("2");
			page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of guests per")).click();
			page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of guests per")).fill("3");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Deliverables Direction*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Deliverables Direction*"))
					.fill(faker.lorem().sentence(30));
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Hashtags*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Hashtags*")).fill("#NewHashtags");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mentions*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mentions*")).fill("@NewMentions");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Social Media Platform*")).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Instagram")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Content Type*")).click();
			page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Post")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Quantity*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Quantity*")).fill("1");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Offer’s Terms and Conditions*"))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Offer’s Terms and Conditions*"))
					.fill(faker.lorem().sentence(30));
			page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Barter Campaign$")))
					.click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Product Information*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Product Information*")).fill("test");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Influencers*")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Influencers*"))
					.fill(fileUtility.readDataFromPropertyFiles("numberOfInfluencer"));
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
			page.locator("._radio_circle_9emfd_600").click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Publish")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Publish Campaign")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View Campaign")).click();
			PlaywrightAssertions.assertThat(page.locator("xpath=//div[@class='_campaign_name_d3pg2_226']"))
					.containsText("Campaign" + number);
			BrowserContext influencerContext = browser
					.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("login.json")));
			Page influencerPage = influencerContext.newPage();
			influencerPage.navigate("https://influency.codebucketstage.online/influencer/dashboard");
			influencerPage.locator("xpath=(//button[@class='_campaign_card_g0aie_161'])[1]").click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply")).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Date")).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("9").setExact(true)).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("16")).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("22")).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("00")).click();
			influencerPage.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("30")).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Total Guests")).click();
			influencerPage.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("2")).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send Request")).click();
			influencerPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Explore")).click();
			influencerPage.close();

			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("icon Campaigns")).click();
			System.out.println(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Campaigns"))
					.textContent());

			page.locator("xpath=(//p[@class='_campaign_name_lbquk_190'])[1]").click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm & Pay ₹")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Pay by UPI ID")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Use")).nth(1).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Pay").setExact(true))
					.click();
			page.navigate(
					"https://influency.codebucketstage.online/brand/campaign/payment-success?campaignId=423&orderId=payg_423_1786673976282");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back to Campaign")).click();
			PlaywrightAssertions.assertThat(page.locator("xpath=//span[text()='Campaign Summary']"))
					.hasText("Campaign Summary");
			System.out.println(page.locator("xpath=//span[text()='Campaign Summary']").textContent());
		} finally {
			page.close();
			browser.close();
		}
	}

}
