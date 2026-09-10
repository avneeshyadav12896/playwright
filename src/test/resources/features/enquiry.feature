Feature: Enquiry Management

  Background:
    Given I am on the Influency website
    When I open Get in Touch


  Scenario: Influencer submits an enquiry successfully

    When I select Join as an Influencer
    Then I should see Join as an Influencer

    When I enter influencer enquiry details
    And I submit the influencer enquiry

    And I login to admin
    And I open CRM
    And I open Contacted Influencers
    And I navigate to the last page

    Then the influencer enquiry should be displayed


  Scenario: Brand submits an enquiry successfully

    When I select Join as a Brand
    Then I should see Join as a Brand

    When I enter brand enquiry details
    And I submit the brand enquiry

    And I login to admin
    And I open CRM
    And I navigate to the last page

    Then the brand enquiry should be displayed