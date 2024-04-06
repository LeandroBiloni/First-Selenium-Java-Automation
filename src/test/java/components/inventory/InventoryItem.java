package components.inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;
import pages.ItemPage;

public class InventoryItem extends BaseComponent {

    private By imageButton;
    private By itemLabelButton;
    private By addRemoveButton;
    private int itemID;

    public InventoryItem(WebDriver driver, WebElement container, int itemID) {
        super(driver, container);
        
        this.itemID = itemID;

        imageButton = By.cssSelector("a > img");
        itemLabelButton = By.cssSelector("div[data-test=\"inventory-item-name\"]");
        addRemoveButton = By.cssSelector("div+button");
    }
    
    public InventoryItem clickImageButton() {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, imageButton)).click();
        return this;
    }

    public InventoryItem clickItemLabelButton() {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, itemLabelButton)).click();
        return this;
    }

    public InventoryItem clickAddOrRemoveButton() {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, addRemoveButton)).click();
        return this;
    }

    public String getItemName() {
        WebElement label = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, itemLabelButton));
        return label.getText();
    }

    public int getItemID() {
        return itemID;
    }
}
