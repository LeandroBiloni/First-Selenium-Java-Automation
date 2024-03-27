package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import helpers.Helper;

public class InventoryPage {
    private WebDriver driver;
    private By titleText;
    private By filterDropdown;
    private By filterResult;
    
    private By menuButton;
    private By allItemsButton;
    private By aboutButton;
    private By logoutButton;
    private By resetAppButton;
    private By closeMenuButton;
    
    private By cartButton;

    private By addToCartButton;

    private By inventoryItemLabelButton;
    private By inventoryItemImageButton;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        titleText = By.cssSelector("div > span[data-test=\"title\"]");
        filterDropdown = By.cssSelector("div > span > select");
        filterResult = By.cssSelector("div > span > [data-test=\"active-option\"]");

        menuButton = By.id("react-burger-menu-btn");
        allItemsButton = By.id("inventory_sidebar_link");
        aboutButton = By.id("about_sidebar_link");
        logoutButton = By.id("logout_sidebar_link");
        resetAppButton = By.id("reset_sidebar_link");
        closeMenuButton = By.id("react-burger-cross-btn");

        cartButton = By.id("shopping_cart_container");

        addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
        
        inventoryItemLabelButton = By.id("item_4_title_link");
        inventoryItemImageButton = By.id("item_4_img_link");
    }

    public void assertPage() {
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Products"));
    }
    
    public void selectFilter(int filterIndex) {
        WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
        WebElement filterElement = wait.until(ExpectedConditions.presenceOfElementLocated(filterDropdown));
        
        Select selectFilter = new Select(filterElement);
        //Select selectFilter = new Select(driver.findElement(filterDropdown));
        selectFilter.selectByIndex(filterIndex);

        WebElement filterResultElement = wait.until(ExpectedConditions.presenceOfElementLocated(filterResult));

        Assert.assertTrue(filterResultElement.getText().contains("Price (high to low)"), "Filter didn't change to the 'Price (high to low)' option.");
        //Assert.assertTrue(driver.findElement(filterResult).getText().contains("Price (high to low)"));
    }

    public void openMenu() {
        driver.findElement(menuButton).click();

        Helper helper = new Helper();
        helper.waitForSeconds(3);
        Assert.assertTrue(driver.findElement(aboutButton).isDisplayed(), "Menu didn't open");
    }

    public void closeMenu(){
        driver.findElement(closeMenuButton).click();

        Helper helper = new Helper();
        helper.waitForSeconds(3);
        Assert.assertFalse(driver.findElement(closeMenuButton).isDisplayed(), "Menu didn't close");
    }

    public void clickAllItemsButton() {
        driver.findElement(allItemsButton).click();
    }

    public void clickAboutButton() {
        driver.findElement(aboutButton).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickItemLabelButton() {
        driver.findElement(inventoryItemLabelButton).click();
    }

    public void clickItemImageButton() {
        driver.findElement(inventoryItemImageButton).click();
    }

    public String getItemName() {
        return driver.findElement(inventoryItemLabelButton).getText();
    }
}