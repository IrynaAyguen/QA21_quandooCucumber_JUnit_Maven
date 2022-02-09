package de.quandoo.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import de.quandoo.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends Page {

    /* Properties */

    private static String validEmail = PropertiesLoader.loadProperty("valid.email");
    private static String validPwd = PropertiesLoader.loadProperty("valid.password");

    /* Elements */

    private static By loginBtn = By.xpath("//button[@data-qa='login-btn']");
    private static By emailInput = By.xpath("//input[@data-qa='email-input']");
    private static By pwdInput = By.xpath("//input[@data-qa='password-input']");
    private static By message = By.cssSelector(".eBoGeh");



    /** Methods **/

    public SelenideElement loginButton() {
        return $(loginBtn);
    }

    public void validUserCredentialForLoginInput() {
        $(emailInput).setValue(validEmail);
        $(pwdInput).setValue(validPwd);
    }

    public HomePage clickLoginBtn(){
        $(loginBtn).click();
        return Selenide.page(HomePage.class);
    }

    public void validEmailInput(String email) {
        $(emailInput).setValue(email);
    }

    public void invalidPasswordInput(String password) {
        $(pwdInput).setValue(password);
    }

    public SelenideElement message() {
        return $(message);
    }

    public void invalidFakerEmailInput() {
        Faker faker = new Faker();
        String fakerEmail = faker.internet().emailAddress();
        $(emailInput).setValue(fakerEmail);
    }

    public void validPasswordInput() {
        $(pwdInput).setValue(validPwd);
    }


}