package de.quandoo.steps;

import com.codeborne.selenide.Condition;
import de.quandoo.pages.HomePage;
import de.quandoo.pages.RestBerlinPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterSteps {
    HomePage homePage;
    RestBerlinPage restBerlinPage = new RestBerlinPage();

//    @When("I input Berlin")
//    public void inputBerlin(){
//        homePage = page(HomePage.class);
//        homePage.inputBerlin("Berlin");
//    }
//
//    @When("I click  Find button")
//    public void clickFindButton(){
//        restBerlinPage = homePage.clickFindButton();
//    }
//
//    @Then("I see RestBerlin page")
//    public void iSeeRestBerlinPage(){
//        restBerlinPage.restBerlinPageTitle().shouldHave(Condition.exactText("Restaurants in Berlin"));
//    }

    @When("I click  Top rated filter")
    public void iClickTopRatedButton(){
        restBerlinPage.clickTopRatedButton();
    }

    @Then("I see restaurants rating higher than {}")
    public void firstRestaurantRatingIsMoreThen(Integer rating){
        assertTrue(restBerlinPage.getFirstRestaurantRating() >= rating);
    }


    @When("I click African in Cuisine filter")
    public void iClickAfricanInCuisineFilter(){
        restBerlinPage.selectAfricanCuisineFilter();
    }

    @Then("I see correct {} restaurant count")
    public void firstRestaurantHasAfricanCuisineLabel(String filterName){
        int filterRestCount = 0;
        if (filterName.equals("African")){
            filterRestCount = restBerlinPage.getAfricanRestaurantCount();
        }
        if (filterName.equals("Afghan")){
//            filterRestCount = restBerlinPage.getAfghanRestaurantCount();
        }
        assertEquals(filterRestCount, restBerlinPage.getRestaurantListSize());
    }
}
