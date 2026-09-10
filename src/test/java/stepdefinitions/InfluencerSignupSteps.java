package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InfluencerSignupPage;

public class InfluencerSignupSteps {

    private final InfluencerSignupPage influencerSignupPage;

    public InfluencerSignupSteps() {
        influencerSignupPage = new InfluencerSignupPage();
    }

    @Given("I am on the influencer signup page")
    public void iAmOnTheInfluencerSignupPage() throws IOException {
        influencerSignupPage.openInfluencerSignup();
    }

    @When("I create an influencer account with a unique email")
    public void iCreateAnInfluencerAccountWithAUniqueEmail() {
        influencerSignupPage.createInfluencerAccount();
    }

    @When("I verify the influencer signup OTP")
    public void iVerifyTheInfluencerSignupOTP() {
        influencerSignupPage.verifyOTP();
    }

    @When("I upload the influencer profile image")
    public void iUploadTheInfluencerProfileImage() {
        influencerSignupPage.uploadProfileImage();
    }

    @When("I enter influencer profile details")
    public void iEnterInfluencerProfileDetails() {
        influencerSignupPage.enterProfileDetails();
    }

    @When("I select influencer location and category")
    public void iSelectInfluencerLocationAndCategory() {
        influencerSignupPage.selectLocationAndCategory();
    }

    @When("I enter influencer Instagram details")
    public void iEnterInfluencerInstagramDetails() {
        influencerSignupPage.enterInstagramDetails();
    }

    @When("I complete the influencer signup")
    public void iCompleteTheInfluencerSignup() {
        influencerSignupPage.completeSignup();
    }
    @When("I open Influencers")
    public void clickOnInfluencer1() {
        influencerSignupPage.clickOnInfluencer();
    }
    @When("I open the newly created influencer")
    public void openNewCreator1() {
        influencerSignupPage.openNewCreator();
    }

    @Then("I should see the {string} button")
    public void iShouldSeeTheButton(String buttonName) {
        influencerSignupPage.verifySignupCompleted();
    }
}