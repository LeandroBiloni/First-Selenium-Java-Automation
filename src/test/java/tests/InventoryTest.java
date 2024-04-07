package tests;

import org.testng.annotations.Test;

import components.inventory.InventoryItem;
import pages.InventoryPage;
import pages.ItemPage;
import pages.LoginPage;
import pages.AboutPage;
import pages.CartPage;

public class InventoryTest extends CommonConditions {

    @Test(description = "Change the shop filter", enabled = true)
    public void filterChange() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        inventoryPage.selectFilter(3);
    }    

    @Test(description = "Go to about page", enabled = true)
    public void goToAboutPage() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        inventoryPage.openMenu()
            .clickAboutButton();
        
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.assertPage();
    }

    @Test(description = "Try to logout", enabled = true)
    public void logout() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        inventoryPage.openMenu()
            .clickLogoutButton();
        
            loginPage.assertPage();
    }

    @Test(description = "Go back to Inventory page", enabled = true)
    public void goToInventory() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();       

        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();

        cartPage.openMenu()
            .clickAllItemsButton();
        
        inventoryPage.assertPage();
    }

    @Test(description = "Close hamburger menu", enabled = true)
    public void closeMenu() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        inventoryPage.openMenu()
            .closeMenuList();
    }

    @Test(description = "Go to item page from label", enabled = true)
    public void goToItemPageFromLabel() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        inventoryPage.createInventoryList();

        InventoryItem item = inventoryPage.getItems().get(0);

        String itemName = item.getItemName();

        item.clickItemLabelButton();

        ItemPage itemPage = new ItemPage(driver);

        itemPage.assertPage();

        itemPage.assertItem(itemName);
    }

    @Test(description = "Go to item page from image", enabled = true)
    public void goToItemPageFromImage() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        inventoryPage.createInventoryList();

        InventoryItem item = inventoryPage.getItems().get(0);

        String itemName = item.getItemName();

        item.clickImageButton();

        ItemPage itemPage = new ItemPage(driver);
        itemPage.assertPage();

        itemPage.assertItem(itemName);
    }

    @Test(description = "Go to cart", enabled = true)
    public void goToCart() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        inventoryPage.clickCartButton()
            .assertPage();
    }

    @Test(description = "Add item to cart and check if its the same item", enabled = true)
    public void goToCartWithAddedItem() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        inventoryPage.createInventoryList();
        
        InventoryItem item = inventoryPage.getItems().get(0);

        String itemName = item.getItemName();

        item.clickAddOrRemoveButton();
        
        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();

        cartPage.assertSameItem(itemName, 0);
    }
}
