package tests;

import org.testng.annotations.Test;

import components.inventory.InventoryItem;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutCompleteTest extends CommonConditions {
    @Test(description = "Go back to home page", enabled = true)
    public void backHome() {
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
        
        checkoutCompletePage.clickHomeButton()
            .assertPage();
    }
}
