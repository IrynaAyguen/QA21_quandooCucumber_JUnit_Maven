package de.quandoo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RestBerlinPage extends Page {

    /* Elements */

    private static By restBerlinTitle = By.xpath("//h1[@data-qa='result-text']");
    private static By topRatedBtn = By.xpath("//button[@data-qa='filter-button-top-rated']");
    private static By reviewScore = By.xpath("//*[@id='tab-merchants']/div[2]/div[1]/div[2]/div[2]/div/div/div");
    private static By africanCuisineFilter = By.xpath("//div[@data-qa='filter-cuisine-label-03c331d2-8f5f-4d45-8731-e5e98ebfee00']");
    private static By africanCuisineFilterNumber = By.xpath("//div[@data-qa='filter-cuisine-label-03c331d2-8f5f-4d45-8731-e5e98ebfee00'] /span[2]");
    private static By merchantCards = By.xpath("//div[@data-qa='merchant-card-wrapper']");


    public SelenideElement restBerlinPageTitle() {
        return $(restBerlinTitle);
    }

    public void clickTopRatedButton() {
        $(topRatedBtn).click();
    }

    public int getFirstRestaurantRating() {
        pause(3000);
        String score = $(reviewScore).getText().split("\\.")[0];
        return Integer.parseInt(score);
    }

    public void selectAfricanCuisineFilter() {
        $(africanCuisineFilter).click();
    }

    public int getAfricanRestaurantCount() {
        String str = $(africanCuisineFilterNumber).getText();
        int count = Integer.parseInt(str.substring(1, str.length() - 1));
        return count;
    }

    public int getRestaurantListSize() {
        pause(3000);
        return $$(merchantCards).size();
    }

}