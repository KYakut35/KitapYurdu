package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BooksPage extends BasePage {

    public BooksPage(WebDriver driver) {

    }



    public void chooseBook(int page, int index) throws InterruptedException {
        List<WebElement> pages = findAllElements(By.xpath("//a[contains(@href,'search&page')]"));
        Thread.sleep(3000);
        pages.get(page-2).click();
        Thread.sleep(3000);

        List<WebElement> books = findAllElements(By.xpath("//img[contains(@src,'wi:100')]"));
        Thread.sleep(3000);

        books.get(index-1).click();
        Thread.sleep(3000);

    }

    public void chooseRandomBook(int page) throws InterruptedException {
        List<WebElement> pages = findAllElements(By.xpath("//a[contains(@href,'search&page')]"));
        Thread.sleep(1000);
        pages.get(page-2).click();
        Thread.sleep(1000);

        List<WebElement> books = findAllElements(By.xpath("//img[contains(@src,'wi:100')]"));
        Thread.sleep(1000);
        Random random = new Random();
        int upperBound = 20;
        books.get(random.nextInt(upperBound)).click();
        Thread.sleep(1000);
    }

    public boolean checkSearch(String text) {
        if (driver.getCurrentUrl().contains(text)) {

        return true;
        }
        else {
            return false;
        }

    }
}
