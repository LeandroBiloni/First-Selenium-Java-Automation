package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

/**
 * Class for the Hamburger Menu
 */
public class MenuListComponent extends BaseComponent {

    private By closeMenuButton;
    private By allItemsButton;
    private By aboutButton;
    private By logoutButton;
    
    public MenuListComponent(WebDriver driver, WebElement container) {
        super(driver, container);

        closeMenuButton = By.id("react-burger-cross-btn");
        allItemsButton = By.id("inventory_sidebar_link");
        aboutButton = By.id("about_sidebar_link");
        logoutButton = By.id("logout_sidebar_link");
    }
    
    /**
     * Close the Hamburger menu
     * @return this MenuListComponent instance
     */
    public MenuListComponent closeMenuList() {
        logger.debug("Click Close Menu button");
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, closeMenuButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        return this;
    }

    /**
     * Click the All Items button
     * @return this MenuListComponent instance
     */
    public MenuListComponent clickAllItemsButton() {
        logger.debug("Click All Items button");
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, allItemsButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        return this;
    }

    /**
     * Click the About button
     * @return this MenuListComponent instance
     */
    public MenuListComponent clickAboutButton() {
        logger.debug("Click About button");
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, aboutButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        return this;
    }

    /**
     * Click the Logout button
     * @return this MenuListComponent instance
     */
    public MenuListComponent clickLogoutButton() {
        logger.debug("Click Logout button");
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, logoutButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        
        return this;
    }

    /**
     * Checks if the Hamburger menu is closed
     * @return True if the menu is closed. False otherwise
     */
    public boolean isMenuClosed() {
        boolean isClosed = webDriverWait.until(ExpectedConditions.invisibilityOf(container));
        logger.debug("Is menu closed: {}", isClosed);
        return isClosed;
    }
}
