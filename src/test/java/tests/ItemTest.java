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
        
        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
        items = inventoryPage.getItems();

        for(int i = 0; i < items.size(); i++) {

            InventoryItem item = items.get(i);
            String itemName = item.getItemName();

            item.clickItemLabelButton();

            ItemPage itemPage = new ItemPage(driver);

            itemPage.assertPage();
    
            itemPage.assertItem(itemName);
    
            CartPage cartPage = itemPage.clickAddToCartButton()
                .clickCartButton();
    
            cartPage.assertPage();
    
            cartPage.assertSameItem(itemName, i);
    
            cartPage.clickContinueShoppingButton()
                .assertPage();
    
            item.clickItemLabelButton();
            
            itemPage.assertPage();
            
            itemPage.assertItem(itemName);
    
            itemPage.clickRemoveFromCartButton()
                .clickCartButton()
                .assertPage();
            
            cartPage.assertItemRemoved(itemName);
        }
        
    }
}
