package components.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

/**
 * Component class for the Footer of the CartPage
 */
public class CartFooter extends BaseComponent{

    private By continueShoppingButton;
    private By checkoutButton;

    public CartFooter(WebDriver driver, WebElement container) {
        super(driver, container);
        
        continueShoppingButton = By.id("continue-shopping");
        checkoutButton = By.id("checkout");
    }

    /**
     * Clicks the Continue Shopping button
     * @return this CartFooter instance
     */
    public CartFooter clickContinueShoppingButton() {
        logger.debug("Click Continue Shopping button");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(continueShoppingButton)).click();

        return this;
    }

    /**
     * Clicks the Checkout button
     * @return this CartFooter instance
     */
    public CartFooter clickCheckoutButton() {
        logger.debug("Click Checkout button");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(checkoutButton)).click();

        return this;
    }
}
