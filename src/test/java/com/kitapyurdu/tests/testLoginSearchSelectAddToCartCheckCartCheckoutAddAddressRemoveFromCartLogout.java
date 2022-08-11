package com.kitapyurdu.tests;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class testLoginSearchSelectAddToCartCheckCartCheckoutAddAddressRemoveFromCartLogout extends BaseTest {

    HomePage homePage = new HomePage(driver);
    UserPage userPage = new UserPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    BooksPage booksPage = new BooksPage(driver);
    BookDetailPage bookDetailPage = new BookDetailPage(driver);

    AddressPage addressPage = new AddressPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);


    @Test
    @Order(1)
    public void testCheckLogin() {
        homePage.goToLoginPage();
        loginPage.login("kyakut35@gmail.com","12345678"); // Email , Password
        Assertions.assertTrue(userPage.isLoggedIn(),"User Login Failed");
    }


    @Test
    @Order(2)
    public void testSearchBook() throws InterruptedException {
        homePage.searchBook("Felsefe");

    }

    @Test
    @Order(3)
    public void testSelectRandomBook() throws InterruptedException {
        booksPage.chooseRandomBook(2);
    }

    @Test
    @Order(4)
    public void testAddToCart() throws InterruptedException {
        bookDetailPage.addToCart();
    }

    @Test
    @Order(5)
    public void testDoubleTheCart() {
        cartPage.makeItDouble();
    }

    @Test
    @Order(6)
    public void testAddAddress() throws InterruptedException {
        addressPage.addNewAddress();
    }

    @Test
    @Order(7)
    public void testSelectShipmentCompany() throws InterruptedException {
        checkOutPage.selectShipmentCompany();
    }

    @Test
    @Order(8)
    public void testRemoveFromCart() throws InterruptedException {
        checkOutPage.backToCartPage();
        cartPage.clearCart();
    }

    @Test
    @Order(9)
    public void testDeleteAddress() {
        userPage.deleteAddress();
    }

    @Test
    @Order(10)
    public void testLogout() throws InterruptedException {
         homePage.exit();
    }
}
