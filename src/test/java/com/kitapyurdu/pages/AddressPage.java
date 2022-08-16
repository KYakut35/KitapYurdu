package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends BasePage {

    public AddressPage(WebDriver driver) {

    }

    public void addNewAddress() throws InterruptedException {
        click(By.xpath("//a[contains(@onclick,'new')]"));
        sendKeys(By.name("firstname_companyname"),"Testinium");
        sendKeys(By.name("lastname_title"),"Software Testing");
        Select selectCity = new Select(findElement(By.id("address-zone-id")));
        selectCity.selectByVisibleText("İstanbul");
        Select selectCounty = new Select(findElement(By.id("address-county-id")));
        selectCounty.selectByVisibleText("KARTAL");
        sendKeys(By.id("district"),"SOĞANLIK YENİ MAH");
        sendKeys(By.id("address-address-text"),"Testinium Merkez Bina");
        sendKeys(By.id("address-postcode"),"34870");
        sendKeys(By.id("address-mobile-telephone"),"5301234562");
        sendKeys(By.id("address-telephone"),"2121234562");
        click(By.id("address_type_2"));
        Thread.sleep(3000);
        sendKeys(By.name("company_id"),"Kartal Vergi Dairesi");
        sendKeys(By.name("tax_id"),"1234567890");
        Thread.sleep(2000);
        logger.info("Address information entered.");
        click(By.id("button-checkout-continue"));
    }

    public boolean checkAddress() {
        return checkURL("https://www.kitapyurdu.com/index.php?route=checkout/checkout#ShippingMethod");
    }

}
