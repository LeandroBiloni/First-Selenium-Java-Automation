package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.inventory.InventoryItem;
import helpers.WebDriverManager;
import pages.InventoryPage;
import pages.ItemPage;
import pages.LoginPage;
import pages.AboutPage;
import pages.CartPage;

/**
 * Class for the Inventory page Tests
 */
public class InventoryTest extends WebDriverManager {

    protected final String correctUser = "standard_user";
    protected final String correctPassword = "secret_sauce";

    /**
     * Test to change the shop filter
     */
    @Test(description = "Change the shop filter", enabled = true)
    public void filterChange() {
        //Arrange
        int filterIndex = 3;
        String filterTextToCheck = "Price (high to low)";
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .selectFilter(filterIndex);
        
        InventoryPage inventoryPage = new InventoryPage(driver);

        String filterText = inventoryPage
                                .getSelectedFilterText();

        //Assert
        Assert.assertTrue(filterText.contains(filterTextToCheck));
    }    

    /**
     * Test to go to about page
     */
    @Test(description = "Go to about page", enabled = true)
    public void goToAboutPage() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .openMenu()
            .clickAboutButton();

        AboutPage aboutPage = new AboutPage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), aboutPage.getPageURL());
    }

    /**
     * Test to try to logout
     */
    @Test(description = "Try to logout", enabled = true)
    public void logout() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .openMenu()
            .clickLogoutButton();

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getPageURL());
    }

    /**
     * Test to go back to Inventory page
     */
    @Test(description = "Go back to Inventory page", enabled = true)
    public void goToInventory() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .clickCartButton()
            .openMenu()
            .clickAllItemsButton();    

        InventoryPage inventoryPage = new InventoryPage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getPageURL());
    }

    /**
     * Test to close hamburger menu
     */
    @Test(description = "Close hamburger menu", enabled = true)
    public void closeMenu() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .openMenu()
            .closeMenuList();

        InventoryPage inventoryPage = new InventoryPage(driver);

        //Assert
        Assert.assertTrue(inventoryPage.isMenuClosed());
    }

    /**
     * Test to go to item page from label
     */
    @Test(description = "Go to item page from label", enabled = true)
    public void goToItemPageFromLabel() {
        //Arrange
        int itemIndex = 0;

        //Act
        LoginPage loginPage = new LoginPage(driver);

        InventoryItem item = loginPage
                                .login(correctUser, correctPassword)
                                .createInventoryList()
                                .getItemWithID(itemIndex);

        String itemName = item.getItemName();

        item.clickItemLabelButton();

        ItemPage itemPage = new ItemPage(driver);

        //Assert
        Assert.assertEquals(itemPage.getItemName(), itemName);
    }

    /**
     * Test to go to item page from image
     */
    @Test(description = "Go to item page from image", enabled = true)
    public void goToItemPageFromImage() {
        //Arrange
        int itemIndex = 0;

        //Act
        LoginPage loginPage = new LoginPage(driver);

        InventoryItem item = loginPage
                                .login(correctUser, correctPassword)
                                .createInventoryList()
                                .getItemWithID(itemIndex);

        String itemName = item.getItemName();

        item.clickImageButton();

        ItemPage itemPage = new ItemPage(driver);

        //Assert
        Assert.assertEquals(itemPage.getItemName(), itemName);
    }

    /**
     * Test to go to cart
     */
    @Test(description = "Go to cart", enabled = true)
    public void goToCart() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .clickCartButton();
        
        CartPage cartPage = new CartPage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.getPageURL());
    }

    /**
     * Test to add item to cart and check if its the same item
     */
    @Test(description = "Add item to cart and check if its the same item", enabled = true)
    public void goToCartWithAddedItem() {
        //Arrange
        int itemIndex = 0;

        //Act
        LoginPage loginPage = new LoginPage(driver);

        InventoryItem item = loginPage
                                .login(correctUser, correctPassword)
                                .createInventoryList()
                                .getItemWithID(itemIndex);

        String itemName = item.getItemName();

        item.clickAddOrRemoveButton();
        
        InventoryPage inventoryPage = new InventoryPage(driver);

        String cartItemName = inventoryPage
                                    .clickCartButton()
                                    .getCartItemWithIndex(itemIndex)
                                    .getItemName();
        //Assert
        Assert.assertEquals(cartItemName, itemName);
    }
}
