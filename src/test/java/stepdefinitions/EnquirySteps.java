package stepdefinitions;

import com.microsoft.playwright.Page;

import io.cucumber.java.en.*;

import pages.AdminLoginPage;
import pages.CRMPage;
import pages.EnquiryPage;
import utils.FileUtilities;
import utils.PlaywrightManager;
import utils.RandomDataUtility;

public class EnquirySteps {

	private Page page;

	private EnquiryPage enquiryPage;
	private AdminLoginPage adminLoginPage;
	private CRMPage crmPage;

	private int number;
	private String mobileNumber;

	private String influencerName;
	private String brandName;

	private FileUtilities fileUtility;

	public EnquirySteps() {

		page = PlaywrightManager.getPage();

		enquiryPage = new EnquiryPage(page);
		adminLoginPage = new AdminLoginPage(page);
		crmPage = new CRMPage(page);

		fileUtility = new FileUtilities();
	}

	// =====================================================
	// INFLUENCER ENQUIRY
	// =====================================================

	@Given("I am on the Influency website")
	public void i_am_on_the_influency_website() throws Exception {

		page.navigate(fileUtility.readDataFromPropertyFiles("websiteURL"));
	}

	@When("I open Get in Touch")
	public void i_open_get_in_touch() {

		enquiryPage.openGetInTouch();
	}

	@When("I select Join as an Influencer")
	public void i_select_join_as_an_influencer() {

		enquiryPage.selectInfluencer();
	}

	@Then("I should see Join as an Influencer")
	public void i_should_see_join_as_an_influencer() {

		enquiryPage.verifyInfluencerHeading();
	}

	@When("I enter influencer enquiry details")
	public void i_enter_influencer_enquiry_details() {

		number = RandomDataUtility.generateRandomNumber();

		mobileNumber = RandomDataUtility.generateRandomMobileNumber();

		influencerName = "Influcner Name " + number;

		enquiryPage.enterInfluencerName(influencerName);

		enquiryPage.enterInfluencerMobile(mobileNumber);

		enquiryPage.enterInfluencerEmail("avneesh.y+" + number + "@thecodebucket.com");

		enquiryPage.selectInfluencerCategories("Food & Beverages", "Health & Wellness");

		enquiryPage.enterFollowersCount("12,3456");

		enquiryPage.enterInfluencerLocation("Village: Danapur, Post: Danapur. District: Patna");

		enquiryPage.enterInstagramHandle("@testing");
	}

	@When("I submit the influencer enquiry")
	public void i_submit_the_influencer_enquiry() {

		enquiryPage.submitInfluencerEnquiry();
	}

	// =====================================================
	// BRAND ENQUIRY
	// =====================================================

	@When("I select Join as a Brand")
	public void i_select_join_as_a_brand() {

		enquiryPage.selectBrand();
	}

	@Then("I should see Join as a Brand")
	public void i_should_see_join_as_a_brand() {

		enquiryPage.verifyBrandHeading();
	}

	@When("I enter brand enquiry details")
	public void i_enter_brand_enquiry_details() {

		number = RandomDataUtility.generateRandomNumber();

		mobileNumber = RandomDataUtility.generateRandomMobileNumber();

		brandName = "Brand Name " + number;

		enquiryPage.enterBrandName(brandName);

		enquiryPage.enterBrandMobile(mobileNumber);

		enquiryPage.enterBrandEmail("avneesh.y+" + number + "@thecodebucket.com");

		enquiryPage.enterPOCName("POC test name");

		enquiryPage.enterPOCMobile(mobileNumber);

		enquiryPage.enterEmployeeCount("50");

		enquiryPage.selectBrandCategory();

		enquiryPage.enterCompanyAddress(
				"Test full address of your company " + "like Village: Danapur, Post: Danapur. " + "District: Patna");
	}

	@When("I submit the brand enquiry")
	public void i_submit_the_brand_enquiry() {

		enquiryPage.submitBrandEnquiry();
	}

	// =====================================================
	// ADMIN
	// =====================================================

	@When("I login to admin")
	public void i_login_to_admin() throws Exception {

		adminLoginPage.openAdminLogin();

		adminLoginPage.login();
	}

	@When("I open CRM")
	public void i_open_crm() {

		crmPage.openCRM();
	}

	@When("I open Contacted Influencers")
	public void i_open_contacted_influencers() {

		crmPage.openContactedInfluencers();
	}

	@When("I navigate to the last page")
	public void i_navigate_to_the_last_page() {

		crmPage.goToLastPage();
	}

	@Then("the influencer enquiry should be displayed")
	public void the_influencer_enquiry_should_be_displayed() {

		crmPage.verifyLastEntry(influencerName);
	}

	@Then("the brand enquiry should be displayed")
	public void the_brand_enquiry_should_be_displayed() {

		crmPage.verifyLastEntry(brandName);
	}
}