package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseComponent;
import pages.CartPage;

public class HeaderComponent extends BaseComponent {

    private By menuButton;
    private By menuButtonsListContainer;
    private By cartButton;

    private MenuListComponent menuListComponent;

    public HeaderComponent(WebDriver driver, WebElement container) {
        super(driver, container);

        menuButton = By.id("react-burger-menu-btn");
        menuButtonsListContainer = By.cssSelector("div > nav");
        cartButton = By.id("shopping_cart_container");

        initMenuComponent();
    }

    private void initMenuComponent() {
        openMenu();
        menuListComponent = new MenuListComponent(driver, driver.findElement(menuButtonsListContainer));
        
        menuListComponent.closeMenuList();
    }

    public MenuListComponent getMenuListComponent(){
        return menuListComponent;
    }

    public MenuListComponent openMenu() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(menuButton)).click();
        
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(menuButtonsListContainer));

        Assert.assertTrue(driver.findElement(menuButtonsListContainer).isDisplayed(), "Menu didn't open");

        return menuListComponent;
    } 

    public HeaderComponent clickCartButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(cartButton)).click();
        return this;
    }
}
