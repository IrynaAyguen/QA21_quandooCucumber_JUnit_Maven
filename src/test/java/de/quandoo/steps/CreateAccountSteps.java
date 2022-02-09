package de.quandoo.steps;

import com.codeborne.selenide.Condition;
import de.quandoo.pages.CreateAccountPage;
import de.quandoo.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

/**
 * Create account Steps
 * Class implements the Create account page step definitions.
 */

public class CreateAccountSteps {
    CreateAccountPage createAccountPage;
    HomePage homePage;


    @When("I click on the SignUp icon")
    public void iClickOnSignUpIcon() {
        homePage = page(HomePage.class);
        createAccountPage = homePage.clickSignUpIcon();
    }

    @Then("I see CreateAccount page")
    public void iSeeCreateAccountPage() {
        createAccountPage.createAccountButton().should(Condition.exist);
        createAccountPage.createAccountButton().shouldHave(text("Create account"));
    }

    @When("I insert valid user data")
    public void iInsertValidUserData() {
        createAccountPage.validUserDataForCreateAccountInput();
    }

    @When("I click checkbox")
    public void iClickCheckbox() {
        createAccountPage.clickCheckbox();
    }

    @When("I click on Create account button")
    public void iClickCreateAccountButton() {
        homePage=createAccountPage.clickCreateAccountBtn();
    }

}