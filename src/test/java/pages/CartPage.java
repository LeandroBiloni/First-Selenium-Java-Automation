package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helpers.Helper;

public class CartPage {
    private WebDriver driver;

    private By menuButton;
    private By allItemsButton;
    private By continueShoppingButton;
    private By checkoutButton;
    private By itemName;

    private By removeButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;

        menuButton = By.id("react-burger-menu-btn");
        allItemsButton = By.id("inventory_sidebar_link");
        continueShoppingButton = By.id("continue-shopping");
        checkoutButton = By.id("checkout");
        itemName = By.cssSelector("div > a > [data-test=\"inventory-item-name\"]");

        removeButton = By.name("remove-sauce-labs-backpack");
    }

    public void openMenu() {
        driver.findElement(menuButton).click();

        Helper helper = new Helper();
        helper.waitForSeconds(3);
        Assert.assertTrue(driver.findElement(allItemsButton).isDisplayed(), "Menu didn't open");
    }

    public void clickAllItemsButton() {
        driver.findElement(allItemsButton).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

    public void assertSameItem(String name) {
        Assert.assertEquals(driver.findElement(itemName).getText(), name);
    }

    public void assertItemRemoved() {
        List<WebElement> elements = driver.findElements(itemName);

        Assert.assertEquals(elements.size(), 0);
    }
}
