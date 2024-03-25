package tests;

import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.ItemPage;
import pages.LoginPage;
import pages.AboutPage;
import pages.CartPage;

public class InventoryTest extends CommonConditions {

    @Test(description = "Change the shop filter", enabled = false)
    public void filterChange() {
        login(correctUser, correctPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.assertPage();

        inventoryPage.selectFilter(3);
    }    

    @Test(description = "Go to about page")
    public void goToAboutPage() {
        login(correctUser, correctPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        AboutPage aboutPage = new AboutPage(driver);
        inventoryPage.assertPage();

        inventoryPage.openMenu();
        inventoryPage.clickAboutButton();
        aboutPage.assertPage();
    }

    @Test(description = "Try to logout")
    public void logout() {
        login(correctUser, correctPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        inventoryPage.assertPage();

        inventoryPage.openMenu();
        inventoryPage.clickLogoutButton();

        loginPage.assertPage();
    }

    @Test(description = "Go back to Inventory page")
    public void goToInventory() {
        login(correctUser, correctPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        inventoryPage.assertPage();

        inventoryPage.clickCartButton();
        cartPage.openMenu();
        cartPage.clickAllItemsButton();
        inventoryPage.assertPage();
    }

    @Test(description = "Close hamburger menu")
    public void closeMenu() {
        login(correctUser, correctPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        
        inventoryPage.assertPage();

        inventoryPage.openMenu();
        inventoryPage.closeMenu();
    }

    @Test(description = "Go to item page from label")
    public void goToItemPageFromLabel() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        ItemPage itemPage = new ItemPage(driver);

        inventoryPage.assertPage();

        String itemName = inventoryPage.getItemName();

        inventoryPage.clickItemLabelButton();

        itemPage.assertPage();

        itemPage.compareItem(itemName);
    }

    @Test(description = "Go to item page from image")
    public void goToItemPageFromImage() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        ItemPage itemPage = new ItemPage(driver);

        inventoryPage.assertPage();

        String itemName = inventoryPage.getItemName();

        inventoryPage.clickItemImageButton();

        itemPage.assertPage();

        itemPage.compareItem(itemName);
    }

    @Test(description = "Go to cart")
    public void goToCart() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        inventoryPage.assertPage();

        inventoryPage.clickCartButton();

        cartPage.assertPage();
    }

    @Test(description = "Go to cart and check item")
    public void goToCartWithAddedItem() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        inventoryPage.assertPage();

        inventoryPage.clickAddToCartButton();
        
        String itemName = inventoryPage.getItemName();

        inventoryPage.clickCartButton();

        cartPage.assertPage();

        cartPage.assertSameItem(itemName);
    }
}
