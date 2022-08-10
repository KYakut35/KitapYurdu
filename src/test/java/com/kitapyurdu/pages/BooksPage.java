package com.kitapyurdu.pages;

import com.kitapyurdu.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
}
