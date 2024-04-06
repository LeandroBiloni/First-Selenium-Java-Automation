package tests;

import org.testng.annotations.Test;

import components.inventory.InventoryItem;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTwoTest extends CommonConditions{
    
    @Test(description = "Cancel checkout", enabled = true)
    public void cancelCheckout() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();
        CheckoutOnePage checkoutOnePage = cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.setFirstNameFieldText("test")
            .setLastNameFieldText("test")
            .setPostalCodeText("1234");

        CheckoutTwoPage checkoutTwoPage = checkoutOnePage.clickContinueButton();
        
        checkoutTwoPage.assertPage();

        checkoutTwoPage.clickCancelButton()
            .assertPage();
    }

    @Test(description = "Finish checkout", enabled = true)
    public void finishCheckout() {
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();

        InventoryItem item = inventoryPage.getItems().get(0);

        String itemName = item.getItemName();

        item.clickAddOrRemoveButton();
        CartPage cartPage = inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.assertSameItem(itemName, 0);
        CheckoutOnePage checkoutOnePage = cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.setFirstNameFieldText("test")
            .setLastNameFieldText("test")
            .setPostalCodeText("1234");
        
        CheckoutTwoPage checkoutTwoPage = checkoutOnePage.clickContinueButton();
        
        checkoutTwoPage.assertPage();
        checkoutTwoPage.assertItemAdded(itemName);
        CheckoutCompletePage checkoutCompletePage = checkoutTwoPage.clickFinishButton();

        checkoutCompletePage.assertPage();
    }
}
