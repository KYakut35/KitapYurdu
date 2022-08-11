package com.kitapyurdu.methods;

import com.kitapyurdu.driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage extends BaseTest {

    public static WebDriver driver;
    public BasePage() {
        driver = BaseTest.driver;
    }

    public void scrollWithAction(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(locator)).build().perform();
    }


    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAllElements(By locator) {
        return driver.findElements(locator);
    }
    public void click(By locator) {
        scrollWithAction(locator);
        findElement(locator).click();
    }
    public void sendKeys(By locator , String text) {
        scrollWithAction(locator);
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }

    public boolean checkURL(String URL) {
        if (driver.getCurrentUrl().equals(URL)) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }


}
