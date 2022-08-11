package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {

    }

    public void goToCheckoutPage() {
        findAllElements(By.xpath("//a[contains(@href,'route=checkout') and @class=\"button red\"]")).get(1).click();
    }


    public void makeItDouble() {
        sendKeys(By.name("quantity"),"2");
        click(By.xpath("//i[contains(@onclick,'cart')]"));
        goToCheckoutPage();
    }

    public void clearCart() throws InterruptedException {
        Thread.sleep(2000);
        click(By.xpath("//i[@title=\"Kaldır\"]"));
    }

    public boolean checkCart(int i) {
        return true;
    }

    public boolean checkCartForEmpty() {
        return true;
    }
}
