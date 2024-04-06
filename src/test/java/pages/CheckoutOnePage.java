package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BasePage;
import components.checkoutOne.BuyerDataComponent;

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

    public void assertInvalidData() {
        Assert.assertTrue(buyerDataComponent.isErrorFieldDisplayed());
    }

    public CheckoutOnePage setFirstNameFieldText(String text) {
        buyerDataComponent.setFirstNameFieldText(text);
        return this;
    }
    
    public CheckoutOnePage setLastNameFieldText(String text) {
        buyerDataComponent.setLastNameFieldText(text);
        return this;
    }

    public CheckoutOnePage setPostalCodeText(String text) {
        buyerDataComponent.setPostalCodeText(text);
        return this;
    }

    public CartPage clickCancelButton() {
        driver.findElement(cancelButton).click();

        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public CheckoutTwoPage clickContinueButton() {
        driver.findElement(continueButton).click();

        CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage(driver);
        return checkoutTwoPage;
    }
}
