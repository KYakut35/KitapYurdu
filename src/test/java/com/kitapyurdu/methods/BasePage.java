package com.kitapyurdu.methods;

import com.kitapyurdu.driver.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class BasePage extends BaseTest {

    final static Logger logger = Logger.getLogger(BasePage.class);

    public static WebDriver driver;
    public BasePage() {
        driver = BaseTest.driver;
    }

    public void scrollWithAction(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(locator)).build().perform();
        logger.info(locator + " Elementine scroll islemi uygulandi.");
    }

    public WebElement findElement(By locator) {
        logger.info(locator + " Elementi bulundu.");
        return driver.findElement(locator);

    }

    public List<WebElement> findAllElements(By locator) {
        logger.info(locator + " Elementler bulundu.");
        return driver.findElements(locator);
    }

    public void click(By locator) {
        scrollWithAction(locator);
        findElement(locator).click();
        logger.info(locator + " Elementine tiklandi");
    }

    public void sendKeys(By locator , String text) {
        scrollWithAction(locator);
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
        logger.info(locator + " Elementine '"+ text +"' yazildi.");

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
        logger.info(locator + " Elementi bulundu.");
        return findElement(locator).isDisplayed();
    }

}
