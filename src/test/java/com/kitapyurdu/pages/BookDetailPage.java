package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetailPage extends BasePage {

    public BookDetailPage(WebDriver driver) {

    }

    public boolean isOnDetailPage() {
        if (findElement(By.xpath("//img[contains(@src,'wi:220')]")).isDisplayed()) {
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

    public void goToCart() {
        click(By.id("cart-items"));
        click(By.id("js-cart"));
    }

    public void addToCart() throws InterruptedException {
        click(By.id("button-cart"));
        Thread.sleep(3000);
        goToCart();

    }
}
