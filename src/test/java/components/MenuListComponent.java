package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseComponent;
import pages.AboutPage;
import pages.InventoryPage;
import pages.LoginPage;

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
    
    public MenuListComponent closeMenuList() {
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(closeMenuButton));
        webElement.click();
        Assert.assertFalse(driver.findElement(closeMenuButton).isDisplayed(), "Menu didn't close");
        return this;
    }

    public MenuListComponent clickAllItemsButton() {
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(allItemsButton));
        webElement.click();
        return this;
    }

    public MenuListComponent clickAboutButton() {
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(aboutButton));
        webElement.click();
        return this;
    }

    public MenuListComponent clickLogoutButton() {
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        webElement.click();
        return this;
    }
}
