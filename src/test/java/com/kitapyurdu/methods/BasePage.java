package com.kitapyurdu.methods;

import com.kitapyurdu.driver.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class BasePage extends BaseTest {

    public final static Logger logger = Logger.getLogger(BasePage.class);

    public static WebDriver driver;
    public BasePage() {
        driver = BaseTest.driver;
    }

    public void scrollWithAction(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(locator)).build().perform();
        logger.info("This element " + locator + " has been scrolled.");
    }

    public WebElement findElement(By locator) {
        logger.info(locator + " Element founded.");
        return driver.findElement(locator);

    }

    public List<WebElement> findAllElements(By locator) {
        logger.info(locator + " Elements of this have been found.");
        return driver.findElements(locator);
    }

    public void click(By locator) {
        scrollWithAction(locator);
        findElement(locator).click();
        logger.info("Clicked on this element " + locator + " .");
    }

    public void sendKeys(By locator , String text) {
        scrollWithAction(locator);
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
        logger.info(text + " has been written to this element " + locator + " .");

    }

    public boolean checkURL(String URL) {
        if (driver.getCurrentUrl().equals(URL)) {
            logger.info(URL + " website loaded successfully.");
            return true;

        }
        else {
            logger.error(URL + "website can not loaded.");
            return false;
        }
    }
    public boolean isDisplayed(By locator) {
        logger.info(locator + " Element located.");
        return findElement(locator).isDisplayed();
    }

}
