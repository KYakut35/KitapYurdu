package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        logger.info("Added to Favorites List.");
        goToFavoritesList();
    }

    public void goToFavoritesList() {
        click(By.xpath("//a[contains(@href,'route=account/account') and @class=\"common-sprite\"]"));
        click(By.xpath("//a[contains(@href,'favorite') and @class=\"highlight-link\" ]"));
        logger.info("Routed to Favorites List.");
    }

    public void goToCart() {
        click(By.id("cart-items"));
        click(By.id("js-cart"));
    }

    public void addToCart() throws InterruptedException {
        click(By.id("button-cart"));
        Thread.sleep(2000);
        goToCart();

    }

    public String getPriceForCheck() {
        String detailPagePrice = findElement(By.xpath("//div[@class=\"price__item\"]")).getText();
        return detailPagePrice;
    }

    public void addToShopList() {
    }

    public WebElement getBook() {
        return null;
    }
}
