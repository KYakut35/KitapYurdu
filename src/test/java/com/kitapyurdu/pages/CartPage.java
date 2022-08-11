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

    public boolean checkCart(int bookCount) throws InterruptedException {
        Thread.sleep(2000);
        if ((findElement(By.name("quantity")).getText().equals(bookCount)) || (findElement(By.name("quantity")).getText().equals("2"))) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkCartForEmpty() throws InterruptedException {
        Thread.sleep(2000);
        return !isDisplayed(By.xpath("//img[contains(@src,'wi:40')]"));
    }
}
