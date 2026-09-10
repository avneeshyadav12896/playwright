package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.BrandSignupPage;

public class BrandSignupSteps {

    private final BrandSignupPage brandPage;

    public BrandSignupSteps() {
        brandPage = new BrandSignupPage();
    }

    @Given("I am on the brand signup page")
    public void i_am_on_the_brand_signup_page() throws Exception {

        brandPage.openBrandSignupPage();
    }

    @Then("the brand signup page title should be {string}")
    public void the_brand_signup_page_title_should_be(String title) {

        brandPage.verifyPageTitle();
    }

    @When("I create a brand account with a unique email")
    public void i_create_a_brand_account_with_a_unique_email() {

        brandPage.generateBrandData();

        brandPage.clickCreateAccount();

        brandPage.enterEmail();

        brandPage.sendOTP();
    }

    @When("I verify the brand signup OTP")
    public void i_verify_the_brand_signup_otp() {

        brandPage.enterOTP();

        brandPage.verifyOTP();
    }

    @When("I enter brand basic details")
    public void i_enter_brand_basic_details() {

        brandPage.enterBasicDetails();
    }

    @When("I upload the brand profile image")
    public void i_upload_the_brand_profile_image() {

        brandPage.uploadBrandImage();
    }

    @When("I enter brand business details")
    public void i_enter_brand_business_details() {

        brandPage.enterBusinessDetails();
    }

    @When("I confirm that the brand has no GST and PAN")
    public void i_confirm_that_the_brand_has_no_gst_and_pan() {

        brandPage.confirmNoGSTAndPAN();
    }

    @When("I provide GST details")
    public void iProvideGSTDetails() {
    	brandPage.provideGSTDetails();
    }

    @When("I provide PAN details")
    public void iProvidePANDetails() {
    	brandPage.providePANDetails();
    }
    @When("I enter point of contact details")
    public void i_enter_point_of_contact_details() {

        brandPage.enterPOCDetails();
    }

    @When("I enter brand location")
    public void i_enter_brand_location() {

        brandPage.enterLocation();
    }

    @When("I enter Instagram details")
    public void i_enter_instagram_details() {

        brandPage.enterInstagramDetails();
    }

    @When("I finish the brand setup")
    public void i_finish_the_brand_setup() {

        brandPage.finishSetup();
    }

    @When("I logout from the brand account")
    public void i_logout_from_the_brand_account() {

        brandPage.logoutBrand();
    }

//    @When("I login to admin")
//    public void i_login_to_admin() throws Exception {
//
//        brandPage.openAdmin();
//        brandPage.adminLogin();
//    }

    @When("I open Brands")
    public void i_open_brands() {

        brandPage.openBrands();
    }

    @When("I open the newly created brand")
    public void i_open_the_newly_created_brand() {

        brandPage.openCreatedBrand();
    }

    @Then("the newly created brand should be displayed")
    public void the_newly_created_brand_should_be_displayed() {

        brandPage.verifyCreatedBrand();
    }

    @When("I logout from admin")
    public void i_logout_from_admin() {

        brandPage.adminLogout();
    }
}