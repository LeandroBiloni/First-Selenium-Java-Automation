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

        firstNameField = By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input");
        lastNameField = By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input");
        postalCodeField = By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input");
        cancelButton = By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/button");
        continueButton = By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input");
        errorField = By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3");
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
