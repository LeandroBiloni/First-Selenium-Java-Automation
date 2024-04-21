package components.cart;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseComponent;

/**
 * Class for the list of Items in the Cart Page
 */
public class CartItemListComponent extends BaseComponent{

    private ArrayList<CartItem> cartItems;
    private By itemContainer;

    public CartItemListComponent(WebDriver driver, WebElement container) {
        super(driver, container);
        
        itemContainer = By.cssSelector("[data-test=\"inventory-item\"]");

        initializeList();
    }

    /**
     * Initializes the CartList with all the items
     */
    public void initializeList() {
        logger.debug("Initialize CartItems list");
        cartItems = new ArrayList<CartItem>();

        for (WebElement webElement : container.findElements(itemContainer)) {    
            CartItem item = new CartItem(driver, webElement);
            logger.debug("Adding CartItem: {}", item.getItemName());

            cartItems.add(item);
        }
    }
    
    /**
     * Get all the items in the Cart list
     * @return the items from the Cart list
     */
    public ArrayList<CartItem> getCartItems() {
        logger.debug("Get Cart Items");
        return cartItems;
    }
    
    /**
     * Get an Item from the Cart list with the given index
     * @param index the index of the Item
     * @return the item that corresponds to that index
     */
    public CartItem getCartItemWithIndex(int index) {
        CartItem item = cartItems.get(index);
        logger.debug("Get CartItem '{}'' with index '{}'", item.getItemName(), index);

        return item;
    }
}
