package components.inventory;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseComponent;

public class InventoryListComponent extends BaseComponent {

    private ArrayList<InventoryItem> inventoryItems;
    private By itemContainer;

    public InventoryListComponent(WebDriver driver, WebElement container) {
        super(driver, container);

        itemContainer = By.cssSelector("data-test=\"inventory-item\"");

        initializeList();
    }

    private void initializeList() {
        inventoryItems = new ArrayList<InventoryItem>();
        
        int i = 0;

        for (WebElement webElement : container.findElements(itemContainer)) {    
            InventoryItem item = new InventoryItem(driver, webElement, i);

            inventoryItems.add(item);
        }
    }

    public ArrayList<InventoryItem> getItems() {
        return inventoryItems;
    }
    
    public InventoryItem getItemWithID(int id) {
        return inventoryItems.get(id);
    }
}
