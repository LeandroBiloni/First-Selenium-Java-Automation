package components.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

public class CartItem extends BaseComponent{

    private By itemName;
    private By removeButton;

    public CartItem(WebDriver driver, WebElement container) {
        super(driver, container);

        itemName = By.cssSelector("div > a[href=\"#\"]");
        removeButton = By.cssSelector("div > a+div+div");
    }
    
    public CartItem clickRemoveButton() {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, removeButton)).click();

        return this;
    }

    public String getItemName() {
        return webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, itemName)).getText();
    }
}
