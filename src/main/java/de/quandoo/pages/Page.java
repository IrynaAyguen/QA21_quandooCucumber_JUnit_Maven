package de.quandoo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Page {

    private static By accCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    public void acceptAllCookies() {
        pause(2000);
        if ($(accCookies).exists()){
            $(accCookies).click();
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}