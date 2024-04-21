package components.checkoutOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

/**
 * Class for the Buyer Data fields in the Checkout 2 Page
 */
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
    
    /**
     * Set the text for the First Name field
     * @param text the text to write
     * @return this BuyerDataComponent instance
     */
    public BuyerDataComponent setFirstNameFieldText(String text) {
        logger.debug("Enter First Name: {}", text);
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, firstNameField)).sendKeys(text);;
        return this;
    }

    /**
     * Set the text for the Last Name field
     * @param text the text to write
     * @return this BuyerDataComponent instance
     */
    public BuyerDataComponent setLastNameFieldText(String text) {
        logger.debug("Enter Last Name: {}", text);
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, lastNameField)).sendKeys(text);;
        return this;
    }

    /**
     * Set the text for the Postal Code field
     * @param text the text to write
     * @return this BuyerDataComponent instance
     */
    public BuyerDataComponent setPostalCodeText(String text) {
        logger.debug("Enter Postal Code: {}", text);
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, postalCodeField)).sendKeys(text);;
        return this;
    }

    /**
     * Checks if the error for no data provided is displayed
     * @return True if the error is displayed. False otherwise
     */
    public boolean isErrorFieldDisplayed() {
        boolean isDisplayed = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(errorField)).isDisplayed();
        logger.debug("Is error field displayed: {}", isDisplayed);
        return isDisplayed;
    }
}
