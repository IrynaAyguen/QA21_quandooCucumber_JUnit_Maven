package de.quandoo.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import de.quandoo.util.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;

public class CreateAccountPage extends Page {

    /* Properties */
    private static String validFirstName = PropertiesLoader.loadProperty("valid.firstname");
    private static String validLastName = PropertiesLoader.loadProperty("valid.lastname");
    private static String validEmail = PropertiesLoader.loadProperty("valid.email");
    private static String validPwd = PropertiesLoader.loadProperty("valid.password");

    /* Elements */

    private static By createAccountBtn = By.xpath("//button[@data-qa='submit-btn']");
    private static By firstNameInput = By.xpath("//input[@data-qa='first-name-input']");
    private static By lastNameInput = By.xpath("//input[@data-qa='last-name-input']");
    private static By emailInput = By.xpath("//input[@data-qa='email-input']");
    private static By pwdInput = By.xpath("//input[@data-qa='password-input']");
    private static By pwdConfirmInput = By.xpath("//input[@data-qa='password-confirm-input']");
    private static By checkbox = By.cssSelector(".fFSDbK");

    /** Methods **/

    public SelenideElement createAccountButton() {
        return $(createAccountBtn);
    }

    public void validUserDataForCreateAccountInput(){
        $(firstNameInput).setValue(validFirstName);
        $(lastNameInput).setValue(validLastName);
        $(emailInput).setValue(validEmail);
        $(pwdInput).setValue(validPwd);
        $(pwdConfirmInput).setValue(validPwd);
    }

    public void clickCheckbox() {
        $(checkbox).click();
    }

    public HomePage clickCreateAccountBtn(){
        $(createAccountBtn).click();
        return Selenide.page(HomePage.class);
    }
}