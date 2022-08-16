package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritePage extends BasePage {

    public FavoritePage(WebDriver driver) {

    }

    public boolean checkFavorites() {
        if (isDisplayed(By.xpath("//img[contains(@src,'wi:100')]"))) {
            logger.info("Favorites List checked.");
        return true;
        }
        return false;
    }

    public void removeFromFavorites() {
        click(By.xpath("//a[contains(@onclick,'removeFromFavorites') and @data-title='Favorilerimden Sil']"));
        logger.info("Removed from Favorites List.");
    }

    public boolean checkFavoritesForEmpty() {
        logger.info("Favorites List checked.");
        return isDisplayed(By.cssSelector("a#tag-0"));
    }





}
