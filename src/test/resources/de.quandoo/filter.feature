@regression @smoke
Feature: Quandoo Filter Feature
  check filter Top rated
  check African filter in Cuisine filter

  @positiveScenarioFilter @positive
  Scenario: Successful Filter
    Given I am on the Berlin page

    When I click  Top rated filter
    Then I see restaurants rating higher than 4

    When I click African in Cuisine filter
    Then I see correct African restaurant count