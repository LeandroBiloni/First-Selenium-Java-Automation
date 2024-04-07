package components.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

public class CartFooter extends BaseComponent{

    private By continueShoppingButton;
    private By checkoutButton;

    public CartFooter(WebDriver driver, WebElement container) {
        super(driver, container);
        
        continueShoppingButton = By.id("continue-shopping");
        checkoutButton = By.id("checkout");
    }

    public CartFooter clickContinueShoppingButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(continueShoppingButton)).click();

        return this;
    }

    public CartFooter clickCheckoutButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(checkoutButton)).click();

        return this;
    }
}
