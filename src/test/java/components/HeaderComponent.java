package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseComponent;

public class HeaderComponent extends BaseComponent {

    private By menuButton;
    private By menuButtonsListContainer;
    private By cartButton;

    private MenuListComponent menuListComponent;

    public HeaderComponent(WebDriver driver, WebElement container) {
        super(driver, container);

        menuButton = By.id("react-burger-menu-btn");
        menuButtonsListContainer = By.cssSelector("div[class=\"bm-menu-wrap\"]");
        cartButton = By.id("shopping_cart_container");

        initMenuComponent();
    }

    private void initMenuComponent() {
        openMenu();
        menuListComponent = new MenuListComponent(driver, driver.findElement(menuButtonsListContainer));
        
        menuListComponent.closeMenuList();
    }

    public MenuListComponent openMenu() {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, menuButton)).click();
        
        WebElement menuList = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, menuButtonsListContainer));

        Assert.assertTrue(menuList.isDisplayed(), "Menu didn't open");

        return menuListComponent;
    } 

    public boolean isMenuOpen() {
        return menuListComponent.isMenuClosed();
    }

    public HeaderComponent clickCartButton() {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, cartButton)).click();
        return this;
    }
}
