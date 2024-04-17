package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BasePage;

public class CheckoutTwoPage extends BasePage {
    
    private By cancelButton;
    private By finishButton;
    private By itemLabel;

    public CheckoutTwoPage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.saucedemo.com/checkout-step-two.html";
        
        cancelButton = By.id("cancel");
        finishButton = By.id("finish");
        itemLabel = By.cssSelector("div > a > [data-test=\"inventory-item-name\"]");
    }

    public InventoryPage clickCancelButton() {
        driver.findElement(cancelButton).click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    public CheckoutCompletePage clickFinishButton() {
        driver.findElement(finishButton).click();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        return checkoutCompletePage;
    }

    public String getItemText() {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(itemLabel)).getText();
    }
}
