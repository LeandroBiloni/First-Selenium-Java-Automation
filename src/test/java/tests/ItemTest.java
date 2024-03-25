package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.InventoryPage;
import pages.ItemPage;

public class ItemTest extends CommonConditions {
    @Test(description = "Go back to inventory", enabled = false)
    public void backToInventory() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        ItemPage itemPage = new ItemPage(driver);

        inventoryPage.assertPage();

        String itemName = inventoryPage.getItemName();

        inventoryPage.clickItemLabelButton();

        itemPage.assertPage();

        itemPage.compareItem(itemName);

        itemPage.clickBackToProductsButton();

        inventoryPage.assertPage();
    }
    
    @Test(description = "Add to cart", enabled = false)
    public void addToCart() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        ItemPage itemPage = new ItemPage(driver);
        CartPage cartPage = new CartPage(driver);

        inventoryPage.assertPage();

        String itemName = inventoryPage.getItemName();

        inventoryPage.clickItemLabelButton();

        itemPage.assertPage();

        itemPage.compareItem(itemName);

        itemPage.clickAddToCartButton();

        itemPage.clickCartButton();

        cartPage.assertPage();

        cartPage.assertSameItem(itemName);
    }

    @Test(description = "Remove from cart", enabled = false)
    public void removeFromCart() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        ItemPage itemPage = new ItemPage(driver);
        CartPage cartPage = new CartPage(driver);

        inventoryPage.assertPage();

        String itemName = inventoryPage.getItemName();

        inventoryPage.clickItemLabelButton();

        itemPage.assertPage();

        itemPage.compareItem(itemName);

        itemPage.clickAddToCartButton();

        itemPage.clickCartButton();

        cartPage.assertPage();

        cartPage.assertSameItem(itemName);

        cartPage.clickContinueShoppingButton();

        inventoryPage.assertPage();

        inventoryPage.clickItemLabelButton();

        itemPage.assertPage();

        itemPage.clickRemoveFromCartButton();

        itemPage.clickCartButton();

        cartPage.assertPage();

        cartPage.assertItemRemoved();
    }
}
