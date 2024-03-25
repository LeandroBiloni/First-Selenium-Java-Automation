package tests;

import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;

public class CheckoutOneTest extends CommonConditions{

    @Test(description = "Go back to cart with cancel button", enabled = true)
    public void backToCart() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);

        inventoryPage.assertPage();
        inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.clickCancelButton();

        cartPage.assertPage();
    }

    @Test(description = "Continue to checkout 2 without inserting info", enabled = true)
    public void continueToCheckout2WithNoData() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);

        inventoryPage.assertPage();
        inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.clickContinueButton();
        checkoutOnePage.assertInvalidData();
    }

    @Test(description = "Continue to checkout 2", enabled = true)
    public void continueToCheckout2() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage(driver);

        inventoryPage.assertPage();
        inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.setFirstNameFieldText("test");
        checkoutOnePage.setLastNameFieldText("test");
        checkoutOnePage.setFPostalCodeText("1234");
        checkoutOnePage.clickContinueButton();
        
        checkoutTwoPage.assertPage();
    }
}