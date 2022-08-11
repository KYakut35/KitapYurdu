package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class UserPage extends BasePage {

    public UserPage(WebDriver driver) {

    }

    public boolean isLoggedIn() {
        if (driver.getCurrentUrl().equals("https://www.kitapyurdu.com/index.php?route=account/account")) {
        return true;
        }
        else {
            return false;
        }
    }


    public void deleteAddress() {
        click(By.xpath("//a[contains(@href,'route=account/account') and @class=\"common-sprite\"]"));
        click(By.xpath("//a[contains(@href,'address') and @class='highlight-link']"));
        findAllElements(By.xpath("//a[contains(@href,'delete')]")).get(0).click();
    }

    public boolean checkMyAddress() {
        return true;
    }
}
