package pages;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BasePage;
import components.HeaderComponent;
import components.MenuListComponent;
import components.cart.CartFooter;
import components.cart.CartItem;
import components.cart.CartItemListComponent;

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

    public CartPage initHeader() {
        headerComponent = new HeaderComponent(driver, getContainer(headerContainer));
        return this;
    }

    public CartPage initCartItemsComponent() {
        cartItemListComponent = new CartItemListComponent(driver, getContainer(cartItemsContainer));
        return this;
    }

    public MenuListComponent openMenu() {
        return headerComponent.openMenu();
    }

    public InventoryPage clickContinueShoppingButton() {
        cartFooter.clickContinueShoppingButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    public CheckoutOnePage clickCheckoutButton() {
        cartFooter.clickCheckoutButton();
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        return checkoutOnePage;
    }

    public CartPage clickRemoveButtonFWithIndex(int index) {
        cartItemListComponent.getItemWithIndex(index).clickRemoveButton();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public void assertItemRemoved(String name) {
        cartItemListComponent.initializeList();

        ArrayList<CartItem> items = cartItemListComponent.getItems();

        boolean exists = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName() == name) {
                exists = true;
                break;
            }
        }

        Assert.assertFalse(exists, "Item " + name + " was not removed!");
    }

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

    public CartItem getCartItemWithIndex(int index) {
        return cartItemListComponent.getItemWithIndex(index);
    }
}
