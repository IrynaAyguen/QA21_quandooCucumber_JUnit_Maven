package de.quandoo.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import de.quandoo.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * HomePage
 * Class implements the HomePage methods and fields.
 */
public class HomePage extends Page {
    /* Properties */

    public static String basicURL = PropertiesLoader.loadProperty("url");

    /* Elements */

    private static By loginIcon = By.xpath("//a[@data-qa='header-login-btn']");
    private static By signUpIcon = By.xpath("//a[@data-qa='header-register-btn']");
    private static By homePageLogo = By.cssSelector(".hBJuXh");
    private static By userIcon = By.xpath("//button[@data-qa='header-navigation-button']");
    private static By logoutItemMenu = By.xpath("//div[@data-qa='header-navigation-logout']");
    private static By findBtn = By.xpath("//button[@data-qa='button-search-find-hero']");
    private static By inputDistination = By.cssSelector(".tsxAj");

    /** Methods **/



    public SelenideElement homePageLogo(){
        return $(homePageLogo);
    }

    public LoginPage clickLoginIcon() {
        $(loginIcon).click();
        return Selenide.page(LoginPage.class);
    }

    public CreateAccountPage clickSignUpIcon() {
        $(signUpIcon).click();
        return Selenide.page(CreateAccountPage.class);
    }

    public void hoverUserIcon() {
        $(userIcon).hover();
    }

    public SelenideElement logoutItemMenu() {
        return $(logoutItemMenu);
    }



    public void clickLogoutItemMenu() {
        $(logoutItemMenu).click();
    }

    public SelenideElement UserIcon() {
        return $(userIcon);
    }

    public RestBerlinPage clickFindButton() {
        pause(2000);
        $(findBtn).click();
        return Selenide.page(RestBerlinPage.class);
    }

    public void inputBerlin(String BerlinStr) {
//        $(inputDistination).click();
//        $(inputDistination).clear();
        $(inputDistination).setValue(BerlinStr);
    }
}