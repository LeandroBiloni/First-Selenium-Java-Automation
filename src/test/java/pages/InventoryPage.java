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
import helpers.TestReports;

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
        TestReports.reportInfo("Initializing Header");
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));
        return this;
    }

    /**
     * Initializes the SecondaryHeaderComponent
     * @return this InventoryPage instance
     */
    public InventoryPage initSecondaryHeader() {
        TestReports.reportInfo("Initializing Secondary Header");
        secondaryHeader = new SecondaryHeaderComponent(driver, getContainer(secondaryHeaderContainer));
        return this;
    }

    /**
     * Select the sort filter with the given index
     * @param filterIndex the index of the sort option to use
     * @return this InventoryPage instance
     */
    public InventoryPage selectFilter(int filterIndex) {
        TestReports.reportInfo("Selecting filter with index: " + filterIndex);
        secondaryHeader.selectFilter(filterIndex);
        return this;
    }

    /**
     * Get the selected filter option text
     * @return the selected filter text
     */
    public String getSelectedFilterText() {
        String filterText = secondaryHeader.getSelectedFilterText();
        TestReports.reportInfo("Getting Selected Filter Text: " + filterText);
        return filterText;
    }

    /**
     * Opens the Hamburger Menu
     * @return the MenuListComponent instance
     */
    public MenuListComponent openMenu() {
        TestReports.reportInfo("Clicking Open Menu");
        return headerComponent.openMenu();
    }

    /**
     * Checks if the Hamburger Menu is closed
     * @return True if closed. False otherwise
     */
    public boolean isMenuClosed() {
        TestReports.reportInfo("Checking if Menu is closed");

        boolean isClosed = false;

        try {
            isClosed = headerComponent.isMenuClosed();
        } catch (Exception e) {
            TestReports.reportError(e.getMessage());
        }
        TestReports.reportInfo("Menu is closed: " + isClosed);
        return isClosed;
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
     * Clicks the Add/Remove button from an InventoryItem with the given id
     * @param id the id of the InventoryItem
     * @return this InventoryPage instance
     */
    public InventoryPage clickItemAddOrRemoveButtonWithID(int id) {
        TestReports.reportInfo("Clicking Add/Remove on Item with id: " + id);
        inventoryListComponent.getItemWithID(id).clickAddOrRemoveButton();
        return this;
    }

    /**
     * Clicks the Name label button from an InventoryItem with the given id
     * @param id the id of the InventoryItem
     * @return an ItemPage instance
     */
    public ItemPage clickItemLabelButtonWithID(int id) {
        TestReports.reportInfo("Click Item Label button from Inventory Item with ID:" + id);
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
        TestReports.reportInfo("Click Item Image button from Inventory Item with ID: " + id);
        inventoryListComponent.getItemWithID(id).clickImageButton();
        ItemPage itemPage = new ItemPage(driver);
        return itemPage;
    }

    /**
     * Create the InventoryListComponent
     * @return an InventoryListComponent instance
     */
    public InventoryListComponent createInventoryList() {
        TestReports.reportInfo("Creating Inventory Items List");
        inventoryListContainer = By.cssSelector("[data-test=\"inventory-container\"]");
        return inventoryListComponent = new InventoryListComponent(driver, getContainer(inventoryListContainer));
    }

    /**
     * Get the name of an InventoryItem with the given id
     * @param id the id of the InventoryItem
     * @return the name of the InventoryItem
     */
    public String getItemNameWithID(int id) {
        TestReports.reportInfo("Get InventoryItem name with id: " + id);
        return inventoryListComponent.getItemWithID(id).getItemName();
    }

    /**
     * Get a collection of all the InventoryItems
     * @return the InventoryItems found
     */
    public ArrayList<InventoryItem> getItems() {
        TestReports.reportInfo("Get Inventory Items");
        return inventoryListComponent.getItems();
    }

    /**
     * Get the amount of InventoryItems
     * @return the InventoryItems amount
     */
    public int getItemsCount() {
        int count = getItems().size();
        TestReports.reportInfo("Get InventoryItems count: " + count);
        return count;
    }
}