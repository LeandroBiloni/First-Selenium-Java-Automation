package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.inventory.InventoryItem;
import helpers.WebDriverManager;
import pages.CartPage;
import pages.InventoryPage;
import pages.ItemPage;
import pages.LoginPage;

/**
 * Class for the Item page Tests
 */
public class ItemTest extends WebDriverManager {

    protected final String correctUser = "standard_user";
    protected final String correctPassword = "secret_sauce";

    /**
     * Test to go back to inventory
     */
    @Test(description = "Go back to inventory", enabled = true)
    public void backToInventory() {
        //Arrange
        int itemIndex = 0;

        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .createInventoryList()
            .getItemWithID(itemIndex)
            .clickItemLabelButton()
            .clickBackToProductsButton();
        
        InventoryPage inventoryPage = new InventoryPage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getPageURL());
    }
    
    /**
     * Test to add item to cart
     */
    @Test(description = "Add item to cart", enabled = true)
    public void addItemToCart() {
        //Arrange
        int itemIndex = 0;

        //Act
        LoginPage loginPage = new LoginPage(driver);

        InventoryItem item = loginPage
                                .login(correctUser, correctPassword)
                                .createInventoryList()
                                .getItemWithID(itemIndex);

        String itemName = item.getItemName();

        String cartItemName = item
                                .clickItemLabelButton()
                                .clickAddToCartButton()
                                .clickCartButton()
                                .getCartItemWithIndex(itemIndex)
                                .getItemName();

        //Assert
        Assert.assertEquals(cartItemName, itemName);
    }

    /**
     * Test to remove item from cart
     */
    @Test(description = "Remove item from cart", enabled = true)
    public void removeItemFromCart() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        int itemsCount = loginPage
                            .login(correctUser, correctPassword)
                            .createInventoryList()
                            .getItems()
                            .size();

        for(int i = 0; i < itemsCount; i++) {
            InventoryPage inventoryPage = new InventoryPage(driver);

            InventoryItem item = inventoryPage
                        .createInventoryList()
                        .getItemWithID(i);

            String itemName = item.getItemName();

            item.clickItemLabelButton();

            ItemPage itemPage = new ItemPage(driver);
    
            itemPage
                .clickAddToCartButton()
                .clickCartButton()
                .initCartItemsComponent()
                .clickContinueShoppingButton();

            boolean isItemInCart = inventoryPage
                                    .createInventoryList()
                                    .getItemWithID(i)
                                    .clickItemLabelButton()
                                    .initHeader()
                                    .clickRemoveFromCartButton()
                                    .clickCartButton()
                                    .initCartItemsComponent()
                                    .isItemInCart(itemName);
            
            CartPage cartPage = new CartPage(driver);

            cartPage
                .openMenu()
                .clickAllItemsButton();

            //Assert
            Assert.assertFalse(isItemInCart);            
        }
        
    }
}
