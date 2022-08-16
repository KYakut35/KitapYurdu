package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {

    }

    public void goToCheckoutPage() {
        findAllElements(By.xpath("//a[contains(@href,'route=checkout') and @class=\"button red\"]")).get(1).click();
        logger.info("Going to checkout page.");
    }

    public void makeItDouble() throws InterruptedException {
        sendKeys(By.name("quantity"),"2");
        click(By.xpath("//i[contains(@onclick,'cart')]"));
        logger.info("The number of orders was 2.");
    }

    public void clearCart() throws InterruptedException {
        Thread.sleep(2000);
        click(By.xpath("//i[@title=\"Kaldır\"]"));
        logger.info("Car has been cleared.");
    }

    public boolean checkCart(int bookCount) throws InterruptedException {
        Thread.sleep(2000);
        int count = findAllElements(By.xpath("//img[@style=\"max-height:80px;\"]")).size();
        if ((count == bookCount)) {
            logger.info("The expected number of books in the basket was match.");
            return true;
        }
        else {
            logger.info("The expected number of books in the basket was not match.");
            return false;
        }
    }

    public boolean checkCartForEmpty() throws InterruptedException {
        Thread.sleep(2000);
        if (findElement(By.xpath("//div[contains(@style,\"20\")]")).getText().equals("Sepetiniz boş")) {
            logger.info("Cart is empty.");
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
           logger.info("The price in the cart matched the price on the search page.");
           return true;
       }
        logger.info("The price in the cart was not match the price on the search page.");
        return false;
    }

}
