package tests;

import java.util.ArrayList;

import org.testng.annotations.Test;

import components.inventory.InventoryItem;
import pages.CartPage;
import pages.InventoryPage;
import pages.ItemPage;
import pages.LoginPage;

public class ItemTest extends CommonConditions {
    @Test(description = "Go back to inventory", enabled = true)
    public void backToInventory() {
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

        itemPage.clickBackToProductsButton()
            .assertPage();
    }
    
    @Test(description = "Add to cart", enabled = true)
    public void addToCart() {
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

        CartPage cartPage =  itemPage.clickAddToCartButton()
            .clickCartButton();

        cartPage.assertPage();

        cartPage.assertSameItem(itemName, 0);
    }

    @Test(description = "Remove from cart", enabled = true)
    public void removeFromCart() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();    
        
        inventoryPage.createInventoryList();

        int itemsCount = inventoryPage.getItemsCount();

        for(int i = 0; i < itemsCount; i++) {
           
            ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();

            inventoryPage.createInventoryList();

            items = inventoryPage.getItems();

            InventoryItem item = items.get(i);
            String itemName = item.getItemName();

            item.clickItemLabelButton();

            ItemPage itemPage = new ItemPage(driver);

            itemPage.assertPage();
    
            itemPage.assertItem(itemName);
    
            CartPage cartPage = itemPage.clickAddToCartButton()
                .clickCartButton();
    
            cartPage.assertPage();
    
            cartPage.initCartItemsComponent()
                .assertSameItem(itemName, 0);
    
            cartPage.clickContinueShoppingButton()
                .assertPage();
    
            items = new ArrayList<InventoryItem>();

            inventoryPage.createInventoryList();

            items = inventoryPage.getItems();

            item = items.get(i);

            item.clickItemLabelButton();
            
            itemPage.assertPage();
            
            itemPage.assertItem(itemName);
    
            itemPage.initHeader()
                .clickRemoveFromCartButton()
                .clickCartButton()
                .assertPage();
            
            cartPage.initCartItemsComponent()
                .assertItemRemoved(itemName);

            cartPage.initHeader()
                .openMenu()
                .clickAllItemsButton();
        }
        
    }
}
