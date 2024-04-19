package components.inventory;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseComponent;

/**
 * Class for the list of Items in the Inventory Page
 */
public class InventoryListComponent extends BaseComponent {

    private ArrayList<InventoryItem> inventoryItems;
    private By itemContainer;

    public InventoryListComponent(WebDriver driver, WebElement container) {
        super(driver, container);

        itemContainer = By.cssSelector("[data-test=\"inventory-item\"]");

        initializeList();
    }

    /**
     * Initializes the InventoryList with all the items
     */
    private void initializeList() {
        inventoryItems = new ArrayList<InventoryItem>();
        
        int i = 0;

        for (WebElement webElement : container.findElements(itemContainer)) {    
            InventoryItem item = new InventoryItem(driver, webElement, i);

            inventoryItems.add(item);
        }
    }

    /**
     * Get all the items in the Inventory list
     * @return the items from the Inventory list
     */
    public ArrayList<InventoryItem> getItems() {
        return inventoryItems;
    }
    
    /**
     * Get an Item with the given ID
     * @param id the id of the Item
     * @return the item that corresponds to that ID
     */
    public InventoryItem getItemWithID(int id) {
        return inventoryItems.get(id);
    }
}
