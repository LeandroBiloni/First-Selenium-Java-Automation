package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));
    }

    public void assertPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory-item.html?id"));
    }

    public InventoryPage clickBackToProductsButton() {
        driver.findElement(backToProductsButton).click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    public ItemPage clickAddToCartButton() {
        driver.findElement(addToCarttButton).click();
        return this;
    }

    public ItemPage clickRemoveFromCartButton() {
        driver.findElement(removeFromCartButton).click();
        return this;
    }

    public CartPage clickCartButton() {
        headerComponent.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public void assertItem(String name) {
        Assert.assertEquals(driver.findElement(itemLabel).getText(), name);
    }
}
