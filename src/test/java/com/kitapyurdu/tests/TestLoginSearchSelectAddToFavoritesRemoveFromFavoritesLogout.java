package com.kitapyurdu.tests;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.BasePage;
import com.kitapyurdu.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestLoginSearchSelectAddToFavoritesRemoveFromFavoritesLogout extends BaseTest {

   BasePage basePage = new BasePage();
   HomePage homePage = new HomePage(driver);
   LoginPage loginPage = new LoginPage(driver);
   BooksPage booksPage = new BooksPage(driver);
   UserPage userPage = new UserPage(driver);
   BookDetailPage bookDetailPage = new BookDetailPage(driver);
   FavoritePage favoritePage = new FavoritePage(driver);

    @Test
    @Order(1)
    public void testCheckHomePage() {
        Assertions.assertTrue(basePage.checkURL("https://www.kitapyurdu.com/"));
    }

    @Test
    @Order(2)
    public void testCheckLogin() throws InterruptedException {
        homePage.goToLoginPage();
        loginPage.login("kyakut35@gmail.com","12345678"); // Email , Password
        Thread.sleep(2000);
        Assertions.assertTrue(userPage.isLoggedIn(),"User Login Failed");

    }

    @Test
    @Order(3)
    public void testSearchBook() throws InterruptedException {
       homePage.searchBook("Sanat");
        Assertions.assertTrue(booksPage.checkSearch("Sanat"),"Book Search Failed");
    }

    @Test
    @Order(4)
    public void testSelectBook() throws InterruptedException {
        booksPage.chooseBook(2,3); // 2.Page , 3.Book
        Assertions.assertTrue(bookDetailPage.isOnDetailPage(),"Not on Book Detail Page");
    }

    @Test
    @Order(5)
    public void testAddBookToFavorites() {
        bookDetailPage.addToFavorites();
        Assertions.assertTrue(favoritePage.checkFavorites(),"Favorites List is Empty");
    }

    @Test
    @Order(6)
    public void testRemoveBookFromFavorites() throws InterruptedException {
        favoritePage.removeFromFavorites();
        Thread.sleep(3000);
        Assertions.assertTrue(favoritePage.checkFavoritesForEmpty(),"Favorites List is not Empty");
    }

    @Test
    @Order(7)
    public void testLogout() throws InterruptedException {
        homePage.exit();
        Assertions.assertTrue(homePage.checkLogout(),"Logout Failed");
    }


}
