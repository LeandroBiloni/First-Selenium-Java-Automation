package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BasePage;
import components.HeaderComponent;

public class ItemPage extends BasePage {

    private By backToProductsButton;
    private By addToCarttButton;
    private By removeFromCartButton;
    private By itemLabel;

    private By headerContainer;
    private HeaderComponent headerComponent;

    public ItemPage(WebDriver driver) {
        super(driver);

        backToProductsButton = By.id("back-to-products");
        addToCarttButton = By.id("add-to-cart");
        removeFromCartButton = By.id("remove");
        itemLabel = By.cssSelector("div > [data-test=\"inventory-item-name\"]");

        headerContainer = By.cssSelector("div > div[data-test=\"primary-header\"]");
        
        initHeader();
    }

    public ItemPage initHeader() {
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));
        return this;
    }
    
    public void assertPage() {
        String  currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("https://www.saucedemo.com/inventory-item.html?id"), "Current url is: " + currentURL);
    }

    public InventoryPage clickBackToProductsButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(backToProductsButton)).click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    public ItemPage clickAddToCartButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(addToCarttButton)).click();
        return this;
    }

    public ItemPage clickRemoveFromCartButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(removeFromCartButton)).click();
        return this;
    }

    public CartPage clickCartButton() {
        headerComponent.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public void assertItem(String name) {
        String item = driver.findElement(itemLabel).getText();
        Assert.assertEquals(item, name, "Actual Item: " + item + " - Expected Item: " + name);
    }
}
