package com.kitapyurdu.tests;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class testLoginSearchSelectAddToCartCheckCartCheckoutAddAddressRemoveFromCartLogout extends BaseTest {
    //Scenario 2


    HomePage homePage = new HomePage(driver);
    ShipmentPage shipmentPage = new ShipmentPage(driver);
    UserPage userPage = new UserPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    BooksPage booksPage = new BooksPage(driver);
    BookDetailPage bookDetailPage = new BookDetailPage(driver);
    AddressPage addressPage = new AddressPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);




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
    public void testSearchBook() throws InterruptedException {
        homePage.searchBook("Felsefe");
        Assertions.assertTrue(booksPage.checkSearch("Felsefe"),"Book Search Failed");
    }

    @Test
    @Order(3)
    public void testSelectRandomBook() throws InterruptedException {
        booksPage.chooseRandomBook(2);
        Assertions.assertTrue(bookDetailPage.isOnDetailPage(),"Not on Book Detail Page");

    }

    @Test
    @Order(4)
    public void testAddToCart() throws InterruptedException {
        bookDetailPage.addToCart();
        Thread.sleep(2000);
        //Need to rework Assertions.assertTrue(cartPage.checkCart(1),"Invalid Cart");
    }

    @Test
    @Order(5)
    public void testDoubleTheCart() throws InterruptedException {
        cartPage.makeItDouble();
        Thread.sleep(2000);
        // Need to rework Assertions.assertTrue(cartPage.checkCart(2),"Invalid Cart");
    }


    @Test
    @Order(6)
    public void testAddAddress() throws InterruptedException {
        Thread.sleep(1000);
        addressPage.addNewAddress();
        //Will be added Assertions.assertTrue(addressPage.checkAddress(),"Invalid Address");
    }

    @Test
    @Order(7)
    public void testSelectShipmentCompany() throws InterruptedException {
        shipmentPage.selectShipmentCompany();
        //Will be added Assertions.assertTrue(shipmentPage.checkShipmentMethod(),"Invalid Cart");
    }

    @Test
    @Order(8)
    public void testRemoveFromCart() throws InterruptedException {
        checkOutPage.backToCartPage();
        cartPage.clearCart();
        //Need to rework Assertions.assertTrue(cartPage.checkCartForEmpty(),"Cart Is Not Empty");

    }

    @Test
    @Order(9)
    public void testDeleteAddress() {
        userPage.deleteAddress();
       Assertions.assertTrue(userPage.checkMyAddress(),"Invalid Addresses");
    }

    @Test
    @Order(10)
    public void testLogout() throws InterruptedException {
        homePage.exit();
        Assertions.assertTrue(homePage.checkLogout(),"Logout Failed");
    }
}
