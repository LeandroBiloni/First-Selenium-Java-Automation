package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import components.HeaderComponent;
import components.MenuListComponent;
import components.inventory.InventoryItem;
import components.inventory.InventoryListComponent;
import components.inventory.SecondaryHeaderComponent;

/**
 * Class for the Inventory page PageObject
 */
public class InventoryPage extends BasePage {
    
    private By headerContainer;
    private HeaderComponent headerComponent;
    private By inventoryListContainer;
    private InventoryListComponent inventoryListComponent; 
    private By secondaryHeaderContainer;
    private SecondaryHeaderComponent secondaryHeader;

    public InventoryPage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.saucedemo.com/inventory.html";

        headerContainer = By.cssSelector("div > div[data-test=\"primary-header\"]");
        secondaryHeaderContainer = By.cssSelector("[data-test=\"secondary-header\"]");
        initHeader();
        initSecondaryHeader();        
    }

    /**
     * Initializes the HeaderComponent
     * @return this InventoryPage instance
     */
    public InventoryPage initHeader() {
        logger.debug("Initialize Header Component");
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));
        return this;
    }

    /**
     * Initializes the SecondaryHeaderComponent
     * @return this InventoryPage instance
     */
    public InventoryPage initSecondaryHeader() {
        logger.debug("Initialize Secondary Header Component");
        secondaryHeader = new SecondaryHeaderComponent(driver, getContainer(secondaryHeaderContainer));
        return this;
    }

    /**
     * Select the sort filter with the given index
     * @param filterIndex the index of the sort option to use
     * @return this InventoryPage instance
     */
    public InventoryPage selectFilter(int filterIndex) {
        logger.debug("Select filter with index: {}", filterIndex);
        secondaryHeader.selectFilter(filterIndex);
        return this;
    }

    /**
     * Get the selected filter option text
     * @return the selected filter text
     */
    public String getSelectedFilterText() {
        logger.debug("Get selected filter");
        return secondaryHeader.getSelectedFilterText();
    }

    /**
     * Opens the Hamburger Menu
     * @return the MenuListComponent instance
     */
    public MenuListComponent openMenu() {
        logger.debug("Click Open Menu button");
        return headerComponent.openMenu();
    }

    /**
     * Checks if the Hamburger Menu is closed
     * @return True if closed. False otherwise
     */
    public boolean isMenuClosed() {
        logger.debug("Is menu closed");
        return headerComponent.isMenuClosed();
    }

    /**
     * Clicks the Cart button
     * @return a CartPage instance
     */
    public CartPage clickCartButton() {
        logger.debug("Click Cart button");
        headerComponent.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    /**
     * Clicks the Add/Remove button from an InventoryItem with the given id
     * @param id the id of the InventoryItem
     * @return this InventoryPage instance
     */
    public InventoryPage clickItemAddOrRemoveButtonWithID(int id) {
        logger.debug("Click Add/Remove button from Inventory Item with ID: {}", id);
        inventoryListComponent.getItemWithID(id).clickAddOrRemoveButton();
        return this;
    }

    /**
     * Clicks the Name label button from an InventoryItem with the given id
     * @param id the id of the InventoryItem
     * @return an ItemPage instance
     */
    public ItemPage clickItemLabelButtonWithID(int id) {
        logger.debug("Click Item Label button from Inventory Item with ID: {}", id);
        inventoryListComponent.getItemWithID(id).clickItemLabelButton();
        ItemPage itemPage = new ItemPage(driver);
        return itemPage;
    }

    /**
     * Clicks the Image button from an InventoryItem with the given id
     * @param id the id of the InventoryItem
     * @return an ItemPage instance
     */
    public ItemPage clickItemImageButtonWithID(int id) {
        logger.debug("Click Item Image button from Inventory Item with ID: {}", id);
        inventoryListComponent.getItemWithID(id).clickImageButton();
        ItemPage itemPage = new ItemPage(driver);
        return itemPage;
    }

    /**
     * Create the InventoryListComponent
     * @return an InventoryListComponent instance
     */
    public InventoryListComponent createInventoryList() {
        logger.debug("Create Inventory List Component", driver);
        inventoryListContainer = By.cssSelector("[data-test=\"inventory-container\"]");
        return inventoryListComponent = new InventoryListComponent(driver, getContainer(inventoryListContainer));
    }

    /**
     * Get the name of an InventoryItem with the given id
     * @param id the id of the InventoryItem
     * @return the name of the InventoryItem
     */
    public String getItemNameWithID(int id) {
        logger.debug("Get InventoryItem name with id: {}", id);
        return inventoryListComponent.getItemWithID(id).getItemName();
    }

    /**
     * Get a collection of all the InventoryItems
     * @return the InventoryItems found
     */
    public ArrayList<InventoryItem> getItems() {
        logger.debug("Get Inventory Items");
        return inventoryListComponent.getItems();
    }

    /**
     * Get the amount of InventoryItems
     * @return the InventoryItems amount
     */
    public int getItemsCount() {
        int count = getItems().size();
        logger.debug("Get InventoryItems count: {}", count);
        return count;
    }
}