package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends CommonConditions {

    @Test(description = "Go back to inventory page using All items button in menu", enabled = true)
    public void goToInventoryA() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();
        CartPage cartPage = inventoryPage.clickCartButton();            

        cartPage.assertPage();

        cartPage.openMenu()
            .clickAllItemsButton();

        inventoryPage.assertPage();
    }

    @Test(description = "Go back to inventory page using Continue Shopping button", enabled = true)
    public void goToInventoryB() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();
        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();

        cartPage.clickContinueShoppingButton()
            .assertPage();
    }

    @Test(description = "Go to checkout step one", enabled = true)
    public void goToCheckoutOne() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();
        
        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.clickCheckoutButton()
            .assertPage();
    }
}
