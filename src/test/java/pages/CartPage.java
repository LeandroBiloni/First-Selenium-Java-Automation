package pages;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import components.HeaderComponent;
import components.MenuListComponent;
import components.cart.CartFooter;
import components.cart.CartItem;
import components.cart.CartItemListComponent;

/**
 * Class for the Cart page PageObject
 */
public class CartPage extends BasePage{
    
    private By headerContainer;
    private HeaderComponent headerComponent;
    private By cartFooterContainer;
    private CartFooter cartFooter;
    private By cartItemsContainer;
    private CartItemListComponent cartItemListComponent;
    

    public CartPage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.saucedemo.com/cart.html";

        headerContainer = By.cssSelector("div > div[data-test=\"primary-header\"]");
        initHeader();
        
        cartFooterContainer = By.cssSelector("div > div > div > div[class=\"cart_footer\"]");
        cartFooter = new CartFooter(driver, getContainer(cartFooterContainer));

        cartItemsContainer = By.cssSelector("[data-test=\"cart-list\"]");
        initCartItemsComponent();
    }    

    /**
     * Initializes the HeaderComponent
     * @return this CartPage instance
     */
    public CartPage initHeader() {
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));
        return this;
    }

    /**
     * Initializes the CartItemListComponent
     * @return this CartPage instance
     */
    public CartPage initCartItemsComponent() {
        cartItemListComponent = new CartItemListComponent(driver, getContainer(cartItemsContainer));
        return this;
    }

    /**
     * Opens the Hamburger menu
     * @return a MenuListComponent instance
     */
    public MenuListComponent openMenu() {
        return headerComponent.openMenu();
    }

    /**
     * Clicks the Continue Shopping button
     * @return an InventoryPage instance
     */
    public InventoryPage clickContinueShoppingButton() {
        cartFooter.clickContinueShoppingButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    /**
     * Click the Checkout button
     * @return a CheckoutOnePage instance
     */
    public CheckoutOnePage clickCheckoutButton() {
        cartFooter.clickCheckoutButton();
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        return checkoutOnePage;
    }

    /**
     * Click the Remove button from the CartItem with the given index
     * @param index the index of the Item to remove
     * @return this CartPage instance
     */
    public CartPage clickRemoveButtonFWithIndex(int index) {
        cartItemListComponent.getItemWithIndex(index).clickRemoveButton();
        return this;
    }

    /**
     * Checks if the CartItem with the given name is present in the cart
     * @param name the name of the CartItem
     * @return True if the CartItem is present. False otherwise
     */
    public boolean isItemInCart(String name) {
        cartItemListComponent.initializeList();

        ArrayList<CartItem> items = cartItemListComponent.getItems();

        boolean exists = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName() == name) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    /**
     * Get the CartItem with the given index
     * @param index the index of the CartItem
     * @return the found CartItem
     */
    public CartItem getCartItemWithIndex(int index) {
        return cartItemListComponent.getItemWithIndex(index);
    }
}
