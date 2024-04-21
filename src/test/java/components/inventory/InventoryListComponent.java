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
        logger.debug("Initialize Inventory List");

        inventoryItems = new ArrayList<InventoryItem>();
        
        int i = 0;

        for (WebElement webElement : container.findElements(itemContainer)) {    
            InventoryItem item = new InventoryItem(driver, webElement, i);

            logger.debug("Adding Item: {}", item.getItemName());
            inventoryItems.add(item);
        }
    }

    /**
     * Get all the items in the Inventory list
     * @return the items from the Inventory list
     */
    public ArrayList<InventoryItem> getItems() {
        logger.debug("Get Inventory Items");
        return inventoryItems;
    }
    
    /**
     * Get an Item with the given ID
     * @param id the id of the Item
     * @return the item that corresponds to that ID
     */
    public InventoryItem getItemWithID(int id) {
        InventoryItem item = inventoryItems.get(id);
        logger.debug("Get Item '{}' with ID '{}'", item.getItemName(), id);
        return item;
    }
}
