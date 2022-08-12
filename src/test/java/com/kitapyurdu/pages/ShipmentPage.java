package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShipmentPage extends BasePage {

    public ShipmentPage(WebDriver driver) {
    }

    public void selectShipmentCompany() throws InterruptedException {
        Thread.sleep(1000);
        click(By.xpath("//input[@value=\"23-non\"]"));
        click(By.id("button-checkout-continue"));
        Thread.sleep(1000);
    }

    public boolean checkShipmentMethod() {
        return checkURL("https://www.kitapyurdu.com/index.php?route=checkout/checkout#PaymentMethod");
    }

}

