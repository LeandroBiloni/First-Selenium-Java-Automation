package components.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

/**
 * Component class for the Items in the Cart list from the Cart Page
 */
public class CartItem extends BaseComponent{

    private By itemName;
    private By removeButton;

    public CartItem(WebDriver driver, WebElement container) {
        super(driver, container);

        itemName = By.cssSelector("div > a[href=\"#\"]");
        removeButton = By.cssSelector("div > a+div+div");
    }
    
    /**
     * Clicks the Remove from cart button
     * @return this CartItem instance
     */
    public CartItem clickRemoveButton() {
        logger.debug("Click Remove button");
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, removeButton)).click();

        return this;
    }

    /**
     * Get the Item Name
     * @return this Item name
     */
    public String getItemName() {
        String name = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, itemName)).getText();
        logger.debug("Get Item name: {}", name);

        return name;
    }
}
