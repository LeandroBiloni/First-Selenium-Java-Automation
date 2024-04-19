package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.LoginPage;
import pages.CartPage;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;

/**
 * Class for the Checkout One page Tests
 */
public class CheckoutOneTest extends WebDriverManager{

    protected final String correctUser = "standard_user";
    protected final String correctPassword = "secret_sauce";

    /**
     * Test to go back to cart with cancel button
     */
    @Test(description = "Go back to cart with cancel button", enabled = true)
    public void backToCart() {        
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .clickCartButton()
            .clickCheckoutButton()
            .clickCancelButton();

        CartPage cartPage = new CartPage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.getPageURL());
    }

    /**
     * Test to continue to checkout 2 without inserting info
     */
    @Test(description = "Continue to checkout 2 without inserting info", enabled = true)
    public void continueToCheckout2WithNoData() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .login(correctUser, correctPassword)
            .clickCartButton()
            .clickCheckoutButton()
            .clickContinueButton();

        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);

        //Assert
        Assert.assertTrue(checkoutOnePage.isErrorFieldDisplayed());
    }

    /**
     * Test to continue to checkout 2 without inserting info
     */
    @Test(description = "Continue to checkout 2", enabled = true)
    public void continueToCheckout2() {
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
            .clickContinueButton();

        CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage(driver);

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), checkoutTwoPage.getPageURL());
    }
}