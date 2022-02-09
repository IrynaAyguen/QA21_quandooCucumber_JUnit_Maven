package de.quandoo.steps;

import com.codeborne.selenide.Condition;
import de.quandoo.pages.HomePage;
import de.quandoo.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.docstring.DocString;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

/**
 * Login Steps
 * Class implements the Login page step definitions.
 */

public class LoginSteps {
    LoginPage loginPage;
    HomePage homePage;


    @When ("I click on the Login icon")
    public void iClickOnLoginIcon() {
        homePage = page(HomePage.class);
        loginPage = homePage.clickLoginIcon();
    }

    @Then ("I see Login page")
    public void iSeeLoginPage() {
        loginPage.loginButton().should(Condition.exist);
        loginPage.loginButton().shouldHave(text("Log in"));
    }

    @When ("I insert valid user credentials")
    public void iInsertValidUserCredential() {
        loginPage.validUserCredentialForLoginInput();
    }

    @When ("I click on Login button")
    public void iClickOnLoginButton() {
        homePage=loginPage.clickLoginBtn();
    }

    @When ("I hover on the User icon")
    public void iHoverOnUserIcon() {
        homePage.hoverUserIcon();
    }

    @Then ("I see Log out item menu")
    public void iSeeLogoutItemMenu() {
        homePage.logoutItemMenu().shouldBe(visible);
    }

    @When ("I click on Log out item menu")
    public void iClickLogoutItemMenu(){
        homePage.clickLogoutItemMenu();
    }


    @When("I insert invalid data")
    public void enterInvalidData(DataTable table){
        List<Map<String,String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");

        loginPage.validEmailInput(email);
        loginPage.invalidPasswordInput(password);
    }

    @When ("I insert invalid Faker-email")
    public void enterDataWithInvalidEmail(){
        loginPage.invalidFakerEmailInput();
        loginPage.validPasswordInput();
    }

    @Then("I see that message appeared")
    public void isMessageAppeared(DocString validationMsg) {
        String msg = validationMsg.getContent();
        loginPage.message().should(Condition.exist);
        loginPage.message().shouldHave(text(msg));
    }

    @Then("I see, message appeared")
    public void isMessageAppeared() {
        loginPage.message().should(Condition.exist);
    }
}
