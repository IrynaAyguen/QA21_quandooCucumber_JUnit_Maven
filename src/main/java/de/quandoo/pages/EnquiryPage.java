package de.quandoo.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class EnquiryPage extends Page {

    /* Elements */

    private static By enquiryPageTitle = By.xpath("//h1[@data-qa='enquiry-checkout-title']");
    private static By restaurantName = By.xpath("//span[@data-qa='reservation-details-merchant-name']");
    private static By peopleNumbField = By.xpath("//div[@class='sc-1qvxtok-1 hORNnu' ]//input[@class='sc-1qvxtok-2 gUeUdu']");
    private static By dateField = By.xpath("//div[@data-qa='widget-date-picker-selection']");
    private static By nextMonatNavi = By.xpath("//div[@data-qa='day-picker-navbar-next'] ");
    private static By day = By.xpath("//div[@class='DayPicker-Body'] /div[4]/div[1]");
    private static By emailField = By.xpath("//input[@data-qa='input-email']");
    private static By firstNameField = By.xpath("//input[@data-qa='input-first-name']");
    private static By lastNameField = By.xpath("//input[@data-qa='input-last-name']");
    private static By phoneNumberField = By.xpath("//input[@data-qa='input-phone']");
    private static By messageField = By.xpath("//textarea[@data-qa='message']");
    private static By iAgreeCheckBox = By.xpath("//div[@id='checkoutTermsCheckbox']//label[@class='sc-1rpkj04-0 fENpwb']//i[@data-qa='checkbox-icon-box']");
    private static By sendEnquiryBtn = By.xpath("//button[@data-qa='enquiry-submit']");
    private static By invalidEmailMsg = By.xpath("//div[@id='checkoutCustomerForm']/div/div/div/div/span[2]");
    private static By invalidFirstNameMsg = By.xpath("//div[@id='checkoutCustomerForm']/div/div[2]/div[1]/div/div/span[2]");
    private static By invalidLastNameMsg = By.xpath("//div[@id='checkoutCustomerForm']/div/div[2]/div[2]/div/div/span[2]");
    private static By invalidPhoneMsg = By.xpath("//div[@id='checkoutCustomerForm']/div/div[3]/div[2]/div/div/span[2]");
    private static By invalidMessageMsg = By.xpath("//div[@class='sc-1atpws7-0 iVrpTU'] //span[2]");
    //private static By pleaseAgreeMsg = By.xpath("//div[@class='sc-AxjAm t400xa-7 jJhcri'] /label/span");   ///why the locator don't work?
    private static By pleaseAgreeMsg = By.xpath("/html[1]/body[1]/div[1]/section[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/label[1]/span[1]");

    @FindBy(xpath = "//div[@data-qa='widget-time-picker-start']//select")
    WebElement timeFromSelectMenu;

    @FindBy(xpath = "//div[@data-qa='widget-time-picker-end']//select")
    WebElement timeToSelectMenu;

    public SelenideElement enquiryPageTitle() {
        return $(enquiryPageTitle).shouldBe(Condition.visible);
    }

    public SelenideElement nameOfRestaurant() {
        return $(restaurantName);
    }

    public void insertValidValidPeopleNumberDateTime(String peopleNumber, String date, String timeFrom, String timeTo) {

        $(peopleNumbField).click();
        $(peopleNumbField).clear();  //// why the command had not cleared?
        $(peopleNumbField).setValue(peopleNumber);

        $(dateField).click();
        $(nextMonatNavi).doubleClick();
        $(nextMonatNavi).doubleClick();
        $(day).click();
//        $(dateField).setValue(date);  ///////

        Select select1 = new Select(timeFromSelectMenu);
        select1.selectByVisibleText(timeFrom);

        Select select2 = new Select(timeToSelectMenu);
        select2.selectByVisibleText(timeTo);
    }

    public void emailInput(String email) {
        $(emailField).click();
        $(emailField).setValue(email);
    }

    public void firstNameInput(String firstName) {
        $(firstNameField).click();
        $(firstNameField).setValue(firstName);
    }

    public void lastNameInput(String lastName) {
        $(lastNameField).click();
        $(lastNameField).setValue(lastName);
    }

    public void phoneNumberInput(String phoneNumber) {
        $(phoneNumberField).click();
        $(phoneNumberField).setValue(phoneNumber);
    }

    public void messageInput(String message) {
        $(messageField).click();
        $(messageField).setValue(message);
    }

    public void selectIAgreeCheckbox(String iagreecheckbox) {
        if (iagreecheckbox.equals("1")) {
            $(iAgreeCheckBox).click();
        }else{
            $(iAgreeCheckBox).doubleClick();
        }
    }

    public void clickSendEnquiryBtn() {
        $(sendEnquiryBtn).click();

    }

    public SelenideElement wrongFormatOrEnterEmailMessage() {
        return $(invalidEmailMsg);
    }

    public SelenideElement enterFirstNameMessage() {
        return $(invalidFirstNameMsg);
    }

    public SelenideElement enterLastNameMessage() {
        return $(invalidLastNameMsg);
    }

    public SelenideElement wrongFormatOrEnterPhoneMessage() {
        return $(invalidPhoneMsg);
    }

    public SelenideElement enterMsgMessage() {
        return $(invalidMessageMsg);
    }


    public SelenideElement pleaseAgreeMessage() {
        return $(pleaseAgreeMsg);
    }
}
