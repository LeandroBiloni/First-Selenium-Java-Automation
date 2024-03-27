package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutOnePage {
 
    private WebDriver driver;

    private By firstNameField;
    private By lastNameField;
    private By postalCodeField;
    private By cancelButton;
    private By continueButton;
    private By errorField;
    
    public CheckoutOnePage(WebDriver driver) {
        this.driver = driver;

        firstNameField = By.id("first-name");
        lastNameField = By.id("last-name");
        postalCodeField = By.id("postal-code");
        cancelButton = By.id("cancel");
        continueButton = By.id("continue");
        errorField = By.cssSelector("div > h3 > [data-test=\"error-button\"]");
    }

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }

    public void assertInvalidData() {
        Assert.assertTrue(driver.findElement(errorField).isDisplayed());
    }

    public void setFirstNameFieldText(String text) {
        driver.findElement(firstNameField).sendKeys(text);
    }
    
    public void setLastNameFieldText(String text) {
        driver.findElement(lastNameField).sendKeys(text);
    }

    public void setFPostalCodeText(String text) {
        driver.findElement(postalCodeField).sendKeys(text);
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
