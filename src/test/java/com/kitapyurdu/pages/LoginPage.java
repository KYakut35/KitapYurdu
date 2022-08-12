package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

    }

    public void login(String eMail, String password) {
        sendKeys(By.id("login-email"),eMail);
        sendKeys(By.id("login-password"),password);
        click(By.xpath("//button[contains(@class,'login')]"));
    }

}
