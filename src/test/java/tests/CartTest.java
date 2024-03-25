package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutOnePage;
import pages.InventoryPage;

public class CartTest extends CommonConditions {

    @Test(description = "Go back to inventory page using All items button in menu", enabled = true)
    public void goToInventoryA() {
        login(correctUser, correctPassword);

        CartPage cartPage = new CartPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.assertPage();
        inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.openMenu();
        cartPage.clickAllItemsButton();

        inventoryPage.assertPage();
    }

    @Test(description = "Go back to inventory page using Continue Shopping button", enabled = true)
    public void goToInventoryB() {
        login(correctUser, correctPassword);

        CartPage cartPage = new CartPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.assertPage();
        inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.clickContinueShoppingButton();

        inventoryPage.assertPage();
    }

    @Test(description = "Go to checkout step one", enabled = true)
    public void goToCheckoutOne() {
        login(correctUser, correctPassword);

        CartPage cartPage = new CartPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);

        inventoryPage.assertPage();
        inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.clickCheckoutButton();
        
        checkoutOnePage.assertPage();
    }
}
