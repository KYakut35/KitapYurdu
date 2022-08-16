package com.kitapyurdu.tests;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.BasePage;
import com.kitapyurdu.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class testLoginForTenTimesSelectRandomAuthorSelectRandomBookAddShopListSelectHighestRated extends BaseTest {

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AuthorsPage authorsPage = new AuthorsPage(driver);
    AuthorsDetailPage authorsDetailPage = new AuthorsDetailPage(driver);
    ShopListPage shopListPage = new ShopListPage(driver);
    CartPage cartPage = new CartPage(driver);
    UserPage userPage = new UserPage(driver);
    BookDetailPage bookDetailPage = new BookDetailPage(driver);
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
        List<WebElement> books = new ArrayList<>();
        for (int i=0;i<10;i++) {
            homePage.selectAuthors();
            authorsPage.selectRandomAuthor();
            authorsDetailPage.selectBook();
            bookDetailPage.addToShopList();
            books.add(bookDetailPage.getBook());
        }
        Assertions.assertTrue(books.size()==10,"Problem");
    }


    @Test
    @Order(3)
    public void testGoToShopList() {
        userPage.goToShopList();
    }

    @Test
    @Order(4)
    public void testSelectHighestRated() {
        shopListPage.selectHighestRatedBook();
    }

    @Test
    @Order(5)
    public void testAddToCart() throws InterruptedException {
        bookDetailPage.addToCart();
    }



    @Test
    @Order(6)
    public void testClearCart() throws InterruptedException {
        cartPage.clearCart();
        Assertions.assertTrue(cartPage.checkCartForEmpty(),"Cart Is Not Empty");
    }

    @Test
    @Order(7)
    public void testLogout() throws InterruptedException {
        homePage.exit();
        Assertions.assertTrue(homePage.checkLogout(),"Logout Failed");
    }


}
