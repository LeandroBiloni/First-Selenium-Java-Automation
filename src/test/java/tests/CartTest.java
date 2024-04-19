package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.CheckoutOnePage;
import pages.InventoryPage;
import pages.LoginPage;

/**
 * Class for the Cart page Tests
 */
public class CartTest extends WebDriverManager {

    protected final String correctUser = "standard_user";
    protected final String correctPassword = "secret_sauce";

    /**
     * Test to go back to inventory page using All items button in menu
     */
    @Test(description = "Go back to inventory page using All items button in menu", enabled = true)
    public void goToInventoryA() {
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
     * Test to go back to inventory page using Continue Shopping button
     */
    @Test(description = "Go back to inventory page using Continue Shopping button", enabled = true)
    public void goToInventoryB() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .clickCartButton()
            .clickContinueShoppingButton();

        InventoryPage inventoryPage = new InventoryPage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getPageURL());
    }

    /**
     * Test to go to checkout step one
     */
    @Test(description = "Go to checkout step one", enabled = true)
    public void goToCheckoutOne() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .clickCartButton()
            .clickCheckoutButton();

        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), checkoutOnePage.getPageURL());
    }
}
