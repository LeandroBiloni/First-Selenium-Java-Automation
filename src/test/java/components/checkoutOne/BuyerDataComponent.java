package components.checkoutOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;
import pages.CheckoutOnePage;

public class BuyerDataComponent extends BaseComponent {

    private By firstNameField;
    private By lastNameField;
    private By postalCodeField;
    private By errorField;
    
    public BuyerDataComponent(WebDriver driver, WebElement container) {
        super(driver, container);

        firstNameField = By.id("first-name");
        lastNameField = By.id("last-name");
        postalCodeField = By.id("postal-code");
        errorField = By.cssSelector("div > h3");        
    }
    
    public BuyerDataComponent setFirstNameFieldText(String text) {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, firstNameField)).sendKeys(text);;
        return this;
    }

    public BuyerDataComponent setLastNameFieldText(String text) {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, lastNameField)).sendKeys(text);;
        return this;
    }

    public BuyerDataComponent setPostalCodeText(String text) {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, postalCodeField)).sendKeys(text);;
        return this;
    }

    public boolean isErrorFieldDisplayed() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(errorField)).isDisplayed();
    }
}
