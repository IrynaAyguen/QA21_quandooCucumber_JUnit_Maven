package de.quandoo.steps;

import de.quandoo.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static de.quandoo.pages.HomePage.basicURL;

/**
 * HomePageSteps
 * Class implements the Homepage step definitions.
 */

public class HomePageSteps {
    HomePage homePage = new HomePage();

//    @Given("I am on the Homepage")
//    public void iAmOnHomePage() {
//        homePage = open(basicURL, HomePage.class);
//        homePage.acceptAllCookies();
//    }

    @Then("I should see Homepage")
    public void iShouldSeeHomepage() {

        homePage.homePageLogo().should(exist);
        homePage.acceptAllCookies();

    }
}