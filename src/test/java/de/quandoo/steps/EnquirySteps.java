package de.quandoo.steps;

import de.quandoo.pages.EnquiryPage;
import de.quandoo.pages.RestaurantPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.docstring.DocString;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EnquirySteps {
    RestaurantPage restaurantPage;
    EnquiryPage enquiryPage;

    @When("I click  Make an enquiry Button")
    public void clickMakeEnquiryButton() {
        restaurantPage = page(RestaurantPage.class);
        enquiryPage = restaurantPage.clickMakeEnquiryButton();
    }

    @Then("I see  Enquiry Page")
    public void seeEnquiryPage() {

        enquiryPage.enquiryPageTitle().shouldHave(text("Make an enquiry"));
        enquiryPage.nameOfRestaurant().shouldHave(text("Cavallino Rosso"));
    }

    @When("I insert valid PeopleNumber,Date, Time in Enquiry form")
    public void insertValidPeopleDateTime() {
        enquiryPage.insertValidValidPeopleNumberDateTime("1", "28/02/2022", "10:30 pm", "11:45 pm");
    }

    @When("I insert invalid Email or Name or PhoneNumber or Message in Enquiry form")
    public void enterInvalidData(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String firstName = dataTable.get(0).get("firstName");
        String lastName = dataTable.get(0).get("lastName");
        String phoneNumber = dataTable.get(0).get("phoneNumber");
        String message = dataTable.get(0).get("message");
        String iAgreeCheckbox = dataTable.get(0).get("iAgreeCheckbox");

        enquiryPage.emailInput(email);
        enquiryPage.firstNameInput(firstName);
        enquiryPage.lastNameInput(lastName);
        enquiryPage.phoneNumberInput(phoneNumber);
        enquiryPage.messageInput(message);
        enquiryPage.selectIAgreeCheckbox(iAgreeCheckbox);
    }

    @When("I click on Send enquiry button")
    public void clickSendEnquiryButton() {
        enquiryPage.clickSendEnquiryBtn();
    }

    @Then("I see that wrong enquiry message appeared")
    public void isMessageAppeared(DocString validationMsg) {

        String msg = validationMsg.getContent();
        String strText;

        strText = enquiryPage.wrongFormatOrEnterEmailMessage().getText();
        if (assertTextMessage(msg, strText)) {
            return;
        }

        strText = enquiryPage.enterFirstNameMessage().getText();
        if (assertTextMessage(msg, strText)) {
            return;
        }

        strText = enquiryPage.enterLastNameMessage().getText();
        if (assertTextMessage(msg, strText)) {
            return;
        }

        strText = enquiryPage.wrongFormatOrEnterPhoneMessage().getText();
        if (assertTextMessage(msg, strText)) {
            return;
        }

        strText = enquiryPage.pleaseAgreeMessage().getText();
        if (assertTextMessage(msg, strText)) {
            return;
        }

        strText = enquiryPage.enterMsgMessage().getText();
        if (assertTextMessage(msg, strText)) {
            return;
        }

    }

    private boolean assertTextMessage(String msg, String str) {
        if (!str.equals("")) {
            assertEquals(str, msg);
            return true;
        }
        return false;
    }
}


