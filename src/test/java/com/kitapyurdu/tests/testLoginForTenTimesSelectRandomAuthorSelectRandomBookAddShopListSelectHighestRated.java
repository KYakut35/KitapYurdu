package com.kitapyurdu.tests;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.BasePage;
import com.kitapyurdu.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class testLoginForTenTimesSelectRandomAuthorSelectRandomBookAddShopListSelectHighestRated extends BaseTest {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    BooksPage booksPage = new BooksPage(driver);
    UserPage userPage = new UserPage(driver);
    BookDetailPage bookDetailPage = new BookDetailPage(driver);
    FavoritePage favoritePage = new FavoritePage(driver);

    @Test
    @Order(1)
    public void testCheckLogin() throws InterruptedException {
        homePage.goToLoginPage();
        loginPage.login("kyakut35@gmail.com","12345678"); // Email , Password
        Thread.sleep(2000);
        Assertions.assertTrue(userPage.isLoggedIn(),"User Login Failed");
    }

    @Test
    @Order(2)
    public void testSearchAuthorAndBook() {

    }


    @Test
    @Order(3)
    public void testGoToShopList() {

    }

    @Test
    @Order(4)
    public void testSelectHighestRated() {

    }

    @Test
    @Order(5)
    public void testAddToCart() {

    }



    @Test
    @Order(6)
    public void testClearCart() {

    }

    @Test
    @Order(7)
    public void testLogout() {

    }


}
