package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

/**
 * Class for the Header
 */
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

    /**
     * Initializes the MenuListComponent
     */
    private void initMenuComponent() {
        logger.debug("Initialize Menu Component");

        logger.debug("Open Menu List");
        openMenu();

        logger.debug("Create new MenuListComponent instance");
        menuListComponent = new MenuListComponent(driver, driver.findElement(menuButtonsListContainer));
        
        logger.debug("Close Menu List");
        menuListComponent.closeMenuList();
    }

    /**
     * Opens the Hamburger Menu
     * @return the MenuListComponent instance
     */
    public MenuListComponent openMenu() {
        logger.debug("Click Open Menu button");
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, menuButton)).click();
        return menuListComponent;
    } 

    /**
     * Checks if the Hamburger Menu is closed
     * @return True if closed. False otherwise
     */
    public boolean isMenuClosed() {
        boolean isClosed = menuListComponent.isMenuClosed();
        logger.debug("Is menu closed: {}", isClosed);
        return isClosed;
    }

    /**
     * Clicks the Cart button
     * @return this HeaderComponent instance
     */
    public HeaderComponent clickCartButton() {
        logger.debug("Click Cart button");
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, cartButton)).click();
        return this;
    }
}
