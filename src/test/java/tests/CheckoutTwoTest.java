package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.CheckoutCompletePage;
import pages.InventoryPage;
import pages.LoginPage;

/**
 * Class for the Checkout Two page Tests
 */
public class CheckoutTwoTest extends WebDriverManager{
    
    protected final String correctUser = "standard_user";
    protected final String correctPassword = "secret_sauce";

    /**
     * Test to cancel checkout
     */
    @Test(description = "Cancel checkout", enabled = true)
    public void cancelCheckout() {
        //Arrange
        String firstName = "test";
        String lastName = "test";
        String postalCode = "1234";
        
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .clickCartButton()
            .clickCheckoutButton()
            .setFirstNameFieldText(firstName)
            .setLastNameFieldText(lastName)
            .setPostalCodeText(postalCode)
            .clickContinueButton()
            .clickCancelButton();

        InventoryPage inventoryPage = new InventoryPage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getPageURL());
    }

    /**
     * Test to finish checkout
     */
    @Test(description = "Finish checkout", enabled = true)
    public void finishCheckout() {
        //Arrange
        int itemIndex = 0;
        String firstName = "test";
        String lastName = "test";
        String postalCode = "1234";

        //Act
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);

        inventoryPage
            .createInventoryList()
            .getItemWithID(itemIndex)
            .clickAddOrRemoveButton();

        inventoryPage
            .clickCartButton()
            .clickCheckoutButton()
            .setFirstNameFieldText(firstName)
            .setLastNameFieldText(lastName)
            .setPostalCodeText(postalCode)
            .clickContinueButton()
            .clickFinishButton();
            
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), checkoutCompletePage.getPageURL());
    }
}
