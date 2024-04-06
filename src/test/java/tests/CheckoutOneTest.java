package tests;

import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.LoginPage;
import pages.CartPage;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;

public class CheckoutOneTest extends CommonConditions{

    @Test(description = "Go back to cart with cancel button", enabled = true)
    public void backToCart() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();
        CheckoutOnePage checkoutOnePage = cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        
        checkoutOnePage.clickCancelButton()
            .assertPage();
    }

    @Test(description = "Continue to checkout 2 without inserting info", enabled = true)
    public void continueToCheckout2WithNoData() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();
        CheckoutOnePage checkoutOnePage = cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.clickContinueButton();
        checkoutOnePage.assertInvalidData();
    }

    @Test(description = "Continue to checkout 2", enabled = true)
    public void continueToCheckout2() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();
        CheckoutOnePage checkoutOnePage = cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.setFirstNameFieldText("test")
            .setLastNameFieldText("test")
            .setPostalCodeText("1234");
        
        CheckoutTwoPage checkoutTwoPage = checkoutOnePage.clickContinueButton();
        
        checkoutTwoPage.assertPage();
    }
}