package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v120.domstorage.model.Item;

import base.BasePage;
import components.HeaderComponent;
import components.MenuListComponent;
import components.inventory.InventoryItem;
import components.inventory.InventoryListComponent;
import components.inventory.SecondaryHeader;

public class InventoryPage extends BasePage {
    
    private By headerContainer;
    private HeaderComponent headerComponent;
    private By inventoryListContainer;
    private InventoryListComponent inventoryListComponent; 
    private By secondaryHeaderContainer;
    private SecondaryHeader secondaryHeader;

    public InventoryPage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.saucedemo.com/inventory.html";

        headerContainer = By.cssSelector("div > div[data-test=\"primary-header\"]");
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));

        inventoryListContainer = By.cssSelector("[data-test=\"inventory-container\"]");
        inventoryListComponent = new InventoryListComponent(driver, getContainer(inventoryListContainer));

        secondaryHeaderContainer = By.cssSelector("[data-test=\"secondary-header\"]");
        secondaryHeader = new SecondaryHeader(driver, getContainer(secondaryHeaderContainer));
    }
    
    public InventoryPage selectFilter(int filterIndex) {
        secondaryHeader.selectFilter(filterIndex);
        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    public MenuListComponent openMenu() {
        return headerComponent.openMenu();
    }

    public CartPage clickCartButton() {
        headerComponent.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public ItemPage clickItemAddOrRemoveButtonWithID(int id) {
        inventoryListComponent.getItemWithID(id).clickAddOrRemoveButton();
        ItemPage itemPage = new ItemPage(driver);
        return itemPage;
    }

    public ItemPage clickItemLabelButtonWithID(int id) {
        inventoryListComponent.getItemWithID(id).clickItemLabelButton();
        ItemPage itemPage = new ItemPage(driver);
        return itemPage;
    }

    public ItemPage clickItemImageButtonWithID(int id) {
        inventoryListComponent.getItemWithID(id).clickImageButton();
        ItemPage itemPage = new ItemPage(driver);
        return itemPage;
    }

    public String getItemNameWithID(int id) {
        return inventoryListComponent.getItemWithID(id).getItemName();
    }

    public ArrayList<InventoryItem> getItems() {
        return inventoryListComponent.getItems();
    }
    public int getItemsCount() {
        return getItems().size();
    }
}