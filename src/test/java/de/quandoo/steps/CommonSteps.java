package de.quandoo.steps;

import com.codeborne.selenide.Condition;
import de.quandoo.pages.EnquiryPage;
import de.quandoo.pages.HomePage;
import de.quandoo.pages.RestBerlinPage;
import de.quandoo.pages.RestaurantPage;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static de.quandoo.pages.HomePage.basicURL;

public class CommonSteps {

    HomePage homePage;
    RestaurantPage restaurantPage;
    RestBerlinPage restBerlinPage;
    EnquiryPage enquiryPage;

    @Given("I am on the {} page")
    public void iAmOnPage(String page) {
        if (page.equals("Homepage")) {
            homePage = open(basicURL, HomePage.class);
            homePage.acceptAllCookies();

        }
        if (page.equals("Berlin")){
            restBerlinPage = open("https://www.quandoo.de/en/berlin", RestBerlinPage.class);
            restBerlinPage.acceptAllCookies();
            //assert
            restBerlinPage.restBerlinPageTitle().shouldHave(Condition.exactText("Restaurants in Berlin"));
        }

        if (page.equals("CavallioRossoRestaurant")){
            restaurantPage = open("https://www.quandoo.de/en/place/cavallino-rosso-306", RestaurantPage.class);
            getWebDriver().manage().window().maximize();
            restaurantPage.acceptAllCookies();
            //assert
            restaurantPage.nameOfRestaurant().shouldHave(Condition.exactText("Cavallino Rosso"));
        }


    }
}