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

    public void makeItDouble() throws InterruptedException {
        sendKeys(By.name("quantity"),"2");
        click(By.xpath("//i[contains(@onclick,'cart')]"));
    }

    public void clearCart() throws InterruptedException {
        Thread.sleep(2000);
        click(By.xpath("//i[@title=\"Kaldır\"]"));
    }

    public boolean checkCart(int bookCount) throws InterruptedException {
        Thread.sleep(2000);
        int count = findAllElements(By.xpath("//img[@style=\"max-height:80px;\"]")).size();
        if ((count == bookCount)) {

            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkCartForEmpty() throws InterruptedException {
        Thread.sleep(2000);
        if (findElement(By.xpath("//div[contains(@style,\"20\")]")).getText().equals("Sepetiniz boş")) {
            return true;
        }
        return false;
    }

    public boolean checkDoubleCart() {
        if(findElement(By.xpath("//input[@value=\"2\"]")).isDisplayed()) {
            goToCheckoutPage();
            return true;
        }
        return false;
    }

    public boolean checkPrice(String price) {
       String cartPagePrice = findElement(By.xpath("//span[@class=\"price-new\"]")).getText();
       if (cartPagePrice.equals(price)) {
           return true;
       }
        return false;
    }

}
