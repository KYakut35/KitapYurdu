package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage  extends BasePage {

    public CheckOutPage(WebDriver driver) {


    }





    public void backToCartPage() throws InterruptedException {
        Thread.sleep(2000);
        click(By.id("cart-header"));
    }
}
