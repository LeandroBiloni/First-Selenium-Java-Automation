package components.cart;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseComponent;

public class CartItemListComponent extends BaseComponent{

    private ArrayList<CartItem> cartItems;
    private By itemContainer;

    public CartItemListComponent(WebDriver driver, WebElement container) {
        super(driver, container);
        
        itemContainer = By.cssSelector("[data-test=\"inventory-item\"]");

        initializeList();
    }

    public void initializeList() {
        cartItems = new ArrayList<CartItem>();

        for (WebElement webElement : container.findElements(itemContainer)) {    
            CartItem item = new CartItem(driver, webElement);
            cartItems.add(item);
        }
    }
    
    public ArrayList<CartItem> getItems() {
        return cartItems;
    }
    
    public CartItem getItemWithIndex(int index) {
        return cartItems.get(index);
    }
}
