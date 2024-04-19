package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import components.checkoutOne.BuyerDataComponent;

/**
 * Class for the CheckoutOne page PageObject
 */
public class CheckoutOnePage extends BasePage {
    
    private By cancelButton;
    private By continueButton;    
    private By buyerDataContainer;
    private BuyerDataComponent buyerDataComponent;

    public CheckoutOnePage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.saucedemo.com/checkout-step-one.html";  
        cancelButton = By.id("cancel");
        continueButton = By.id("continue");        

        buyerDataContainer = By.cssSelector("[class=\"checkout_info\"]");
        buyerDataComponent = new BuyerDataComponent(driver, getContainer(buyerDataContainer));
    }

    /**
     * Checks if the error for no data provided is displayed
     * @return True if the error is displayed. False otherwise
     */
    public boolean isErrorFieldDisplayed() {
        return buyerDataComponent.isErrorFieldDisplayed();
    }
    
    /**
     * Set the text for the First Name field
     * @param text the text to write
     * @return this CheckoutOnePage instance
     */
    public CheckoutOnePage setFirstNameFieldText(String text) {
        buyerDataComponent.setFirstNameFieldText(text);
        return this;
    }
    
    /**
     * Set the text for the Lastt Name field
     * @param text the text to write
     * @return this CheckoutOnePage instance
     */
    public CheckoutOnePage setLastNameFieldText(String text) {
        buyerDataComponent.setLastNameFieldText(text);
        return this;
    }

    /**
     * Set the text for the Postal Code field
     * @param text the text to write
     * @return this CheckoutOnePage instance
     */
    public CheckoutOnePage setPostalCodeText(String text) {
        buyerDataComponent.setPostalCodeText(text);
        return this;
    }

    /**
     * Clicks the Cancel button
     * @return a CartPage instance
     */
    public CartPage clickCancelButton() {
        driver.findElement(cancelButton).click();

        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    /**
     * Clicks the Continue button
     * @return a CheckoutTwoPage instance
     */
    public CheckoutTwoPage clickContinueButton() {
        driver.findElement(continueButton).click();

        CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage(driver);
        return checkoutTwoPage;
    }
}
