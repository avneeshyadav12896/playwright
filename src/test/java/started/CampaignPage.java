package started;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import utils.FileUtilities;

public class CampaignPage {
	FileUtilities fileUtility=new FileUtilities();
	@Test
	public void createCampaign() throws IOException
	{ 
		Faker faker=new Faker();
		Browser browser = null;
		Page page = null;
		int number=SignUp.generateRandomNumber();
		try {
		 browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		 page = browser.newPage();
		 page.navigate(fileUtility.readDataFromPropertyFiles("brandURL"));
		 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).fill(fileUtility.readDataFromPropertyFiles("brandUN"));
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).fill(fileUtility.readDataFromPropertyFiles("brandPWD"));
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("icon Campaigns")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Campaigns")).click();
		    page.getByText("In-Person").click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Location*")).click();
		    page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Alappuzha")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Name*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Name*")).fill("Campaign"+number);
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Campaign Category*")).click();
		    page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
		    page.getByLabel("Click to upload *Only PNG or").setInputFiles(Paths.get("src/test/resources/images.jpeg"));;
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Start Date*")).fill("2026-08-08");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign End Date*")).fill("2026-08-15");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Deliverables Date*")).fill("2026-08-22");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Description*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Campaign Description*")).fill(faker.lorem().sentence(30));
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Influencer's Location*")).click();
		    page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Any")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min No. of Followers *")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min No. of Followers *")).fill("1,0000");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Category*")).click();
		    page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Food & Beverages")).click();
		    page.getByText("Category *").click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Min Age")).click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Min Age")).fill("23");
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Max Age")).click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Max Age")).fill("45");
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of influencers that")).click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of influencers that")).fill("2");
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of guests per")).click();
		    page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number of guests per")).fill("3");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Deliverables Direction*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Deliverables Direction*")).fill(faker.lorem().sentence(30));
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
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Offer’s Terms and Conditions*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Offer’s Terms and Conditions*")).fill(faker.lorem().sentence(30));
		    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Monetary Campaign$"))).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Cost per Influencer*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Cost per Influencer*")).fill("₹100");
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Influencers*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Number of Influencers*")).fill("2");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		    page.locator("._radio_circle_9emfd_600").click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Publish")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Publish Campaign")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View Campaign")).click();
		    PlaywrightAssertions.assertThat(page.locator("xpath=//div[@class='_campaign_name_d3pg2_226']")).containsText("New Campaign Test "+number);	 
		}
		finally{
			 page.close();
			 browser.close();
		}
	}
}
