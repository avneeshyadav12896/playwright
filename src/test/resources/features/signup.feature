Feature: Brand Signup

  @BrandSignup @NoGSTPAN
  Scenario: Brand completes signup without GST and PAN
    Given I am on the brand signup page
    Then the brand signup page title should be "Influency"

    When I create a brand account with a unique email
    And I verify the brand signup OTP
    And I enter brand basic details
    And I upload the brand profile image
    And I enter brand business details
    And I confirm that the brand has no GST and PAN
    And I enter point of contact details
    And I enter brand location
    And I enter Instagram details
    And I finish the brand setup

    And I logout from the brand account

    When I login to admin
    And I open Brands
    And I open the newly created brand

    And the newly created brand should be displayed
    Then I logout from admin
    
    
  @BrandSignup @GSTPAN
  Scenario: Brand completes signup with GST and PAN

    Given I am on the brand signup page
    Then the brand signup page title should be "Influency"

    When I create a brand account with a unique email
    And I verify the brand signup OTP
    And I enter brand basic details
    And I upload the brand profile image
    And I enter brand business details

    And I provide GST details
    And I provide PAN details

    And I enter point of contact details
    And I enter brand location
    And I enter Instagram details
    And I finish the brand setup

    And I logout from the brand account

    When I login to admin
    And I open Brands
    And I open the newly created brand

    And the newly created brand should be displayed
    Then I logout from admin
    
  @InfluencerSignup
  Scenario: Influencer completes signup successfully

    Given I am on the influencer signup page
    When I create an influencer account with a unique email
    And I verify the influencer signup OTP
    And I upload the influencer profile image
    And I enter influencer profile details 
    And I select influencer location and category
    And I enter influencer Instagram details
    And I complete the influencer signup

    Then I should see the "Go to Sign In" button

    When I login to admin
    And I open Influencers
    And I open the newly created influencer

    Then I logout from admin