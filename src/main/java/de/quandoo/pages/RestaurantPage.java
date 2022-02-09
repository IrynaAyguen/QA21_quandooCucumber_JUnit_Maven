package de.quandoo.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RestaurantPage extends Page {

    /* Elements */

    private static By restaurantName = By.xpath("//h1[@data-qa='merchant-name']");
    private static By makeEnquiryBtn = By.xpath("//button[@data-qa='make-enquiry-button']");

    public SelenideElement nameOfRestaurant() {
        return $(restaurantName);
    }

    public EnquiryPage clickMakeEnquiryButton() {
        $(makeEnquiryBtn).scrollIntoView(false);
        $(makeEnquiryBtn).click();
        return Selenide.page(EnquiryPage.class);
    }
}
