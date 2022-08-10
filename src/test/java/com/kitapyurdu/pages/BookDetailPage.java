package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetailPage extends BasePage {

    public BookDetailPage(WebDriver driver) {

    }

    public boolean isOnDetailPage() {
        if (isDisplayed(By.id("button-cart"))) {
            return true;
        }
        return false;
    }

    public void addToFavorites() {
        click(By.className("personal-lists__text"));
        goToFavoritesList();
    }

    public void goToFavoritesList() {
        click(By.xpath("//a[contains(@href,'route=account/account') and @class=\"common-sprite\"]"));
        click(By.xpath("//a[contains(@href,'favorite') and @class=\"highlight-link\" ]"));
    }
}
