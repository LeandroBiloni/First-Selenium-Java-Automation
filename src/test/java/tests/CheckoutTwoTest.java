package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;
import pages.InventoryPage;

public class CheckoutTwoTest extends CommonConditions{
    
    @Test(description = "Cancel checkout", enabled = true)
    public void cancelCheckout() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage(driver);

        inventoryPage.assertPage();
        inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.setFirstNameFieldText("test");
        checkoutOnePage.setLastNameFieldText("test");
        checkoutOnePage.setFPostalCodeText("1234");
        checkoutOnePage.clickContinueButton();
        
        checkoutTwoPage.assertPage();

        checkoutTwoPage.clickCancelButton();

        inventoryPage.assertPage();
    }

    @Test(description = "Finish checkout", enabled = true)
    public void finishCheckout() {
        login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        inventoryPage.assertPage();
        inventoryPage.clickAddToCartButton();        
        String itemName = inventoryPage.getItemName();
        inventoryPage.clickCartButton();

        cartPage.assertPage();
        cartPage.assertSameItem(itemName);
        cartPage.clickCheckoutButton();

        checkoutOnePage.assertPage();
        checkoutOnePage.setFirstNameFieldText("test");
        checkoutOnePage.setLastNameFieldText("test");
        checkoutOnePage.setFPostalCodeText("1234");
        checkoutOnePage.clickContinueButton();
        
        checkoutTwoPage.assertPage();
        checkoutTwoPage.assertItemAdded(itemName);
        checkoutTwoPage.clickFinishButton();

        checkoutCompletePage.assertPage();
    }
}
