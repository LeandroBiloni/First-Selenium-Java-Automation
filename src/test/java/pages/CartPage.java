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
import helpers.TestReports;

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
        TestReports.reportInfo("Initialize Header");  
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));
        return this;
    }

    /**
     * Initializes the CartItemListComponent
     * @return this CartPage instance
     */
    public CartPage initCartItemsComponent() {
        TestReports.reportInfo("Initialize Cart Items List");  
        cartItemListComponent = new CartItemListComponent(driver, getContainer(cartItemsContainer));
        return this;
    }

    /**
     * Opens the Hamburger menu
     * @return a MenuListComponent instance
     */
    public MenuListComponent openMenu() {
        TestReports.reportInfo("Open Menu");
        return headerComponent.openMenu();
    }

    /**
     * Clicks the Continue Shopping button
     * @return an InventoryPage instance
     */
    public InventoryPage clickContinueShoppingButton() {
        TestReports.reportInfo("Click Continue Shopping");
        cartFooter.clickContinueShoppingButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    /**
     * Click the Checkout button
     * @return a CheckoutOnePage instance
     */
    public CheckoutOnePage clickCheckoutButton() {
        TestReports.reportInfo("Click Checkout");
        cartFooter.clickCheckoutButton();
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        return checkoutOnePage;
    }

    /**
     * Click the Remove button from the CartItem with the given index
     * @param index the index of the Item to remove
     * @return this CartPage instance
     */
    public CartPage clickRemoveButtonWithIndex(int index) {
        TestReports.reportInfo("Click Remove button from Cart Item with index: " + index);

        try {
            cartItemListComponent.getCartItemWithIndex(index).clickRemoveButton();    
        } catch (Exception e) {
            TestReports.reportError(e.getMessage());
        }
        
        return this;
    }

    /**
     * Checks if the CartItem with the given name is present in the cart
     * @param name the name of the CartItem
     * @return True if the CartItem is present. False otherwise
     */
    public boolean isItemInCart(String name) {
        TestReports.reportInfo("Checking if item with name '" + name +"' is in cart");
        cartItemListComponent.initializeList();

        boolean exists = false;
        try {
            ArrayList<CartItem> items = cartItemListComponent.getCartItems();
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItemName() == name) {
                    exists = true;
                    break;
                }
            }
        } catch (Exception e) {
            TestReports.reportError(e.getMessage());
        }
        TestReports.reportInfo("Item '" + name + "' is present: " + exists);
        return exists;
    }

    /**
     * Get the CartItem with the given index
     * @param index the index of the CartItem
     * @return the found CartItem
     */
    public CartItem getCartItemWithIndex(int index) {
        TestReports.reportInfo("Get Cart Item with index: " + index);
        try {
            CartItem cartItem = cartItemListComponent.getCartItemWithIndex(index);
            return cartItem;
        } catch (Exception e) {
            TestReports.reportError(e.getMessage());
            TestReports.reportError("Cart Item is not present");
        }
        
        return null;
    }
}
