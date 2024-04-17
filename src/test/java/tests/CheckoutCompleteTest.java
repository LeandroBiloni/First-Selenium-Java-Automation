package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutCompleteTest extends WebDriverManager{

    protected final String CORRECT_USER = "standard_user";
    protected final String CORRECT_PASSWORD = "secret_sauce";

    @Test(description = "Go back to home page", enabled = true)
    public void backHome() {
        //Arrange
        int itemIndex = 0;
        String firstName = "test";
        String lastName = "test";
        String postalCode = "1234";

        //Act
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage
                                        .login(CORRECT_USER, CORRECT_PASSWORD);
        
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
            .clickFinishButton()
            .clickHomeButton();
        
        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getPageURL());
    }
}
