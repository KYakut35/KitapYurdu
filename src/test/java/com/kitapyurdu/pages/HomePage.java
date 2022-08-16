package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {

    }

    public void goToLoginPage() {
        click(By.xpath("//a[contains(@href,'login')]"));
        logger.info("Directing to Login Page.");
    }

    public void searchBook(String text) throws InterruptedException {
        Thread.sleep(3000);
        sendKeys(By.cssSelector("input#search-input"),text);
        click(By.xpath("//span[contains(@class,'search')]"));
        logger.info("Searching for " + text + " .");
    }

    public void exit() throws InterruptedException {
        WebElement element =findElement(By.xpath("//a[contains(@href,'route=account/account') and @class=\"common-sprite\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        WebElement targetElement = findElement(By.xpath("//a[contains(@href,'logout')]"));
        Thread.sleep(1000);
        action.moveToElement(targetElement).perform();
        targetElement.click();
        logger.info("Logout from website successfully.");
    }

    public boolean checkLogout() {
        return findElement(By.xpath("//a[contains(@href,'login')]")).getText().equals("Giriş Yap");
    }

    public void selectAuthors() {
    }
}
