package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import components.HeaderComponent;
import helpers.TestReports;

/**
 * Class for the Item page PageObject
 */
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

    /**
     * Initializes the HeaderComponent
     * @return this InventoryPage instance
     */
    public ItemPage initHeader() {
        TestReports.reportInfo("Initializing Header");
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));
        return this;
    }

    /**
     * Click Back To Products button
     * @return an InventoryPage instance
     */
    public InventoryPage clickBackToProductsButton() {
        TestReports.reportInfo("Clicking Back to Products");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(backToProductsButton)).click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    /**
     * Click Add To Cart button
     * @return this ItemPage instance
     */
    public ItemPage clickAddToCartButton() {
        TestReports.reportInfo("Clicking Add to Cart");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(addToCarttButton)).click();
        return this;
    }

    /**
     * Click Remove From Cart button
     * @return this ItemPage instance
     */
    public ItemPage clickRemoveFromCartButton() {
        TestReports.reportInfo("Clicking Remove from Cart");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(removeFromCartButton)).click();
        return this;
    }

    /**
     * Clicks the Cart button
     * @return a CartPage instance
     */
    public CartPage clickCartButton() {
        TestReports.reportInfo("Clicking Cart");
        headerComponent.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    /**
     * Get this Item name
     * @return the Item name
     */
    public String getItemName() {
        String name = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(itemLabel)).getText();
        TestReports.reportInfo("Get Item name: " + name);
        return name;
    }
}
