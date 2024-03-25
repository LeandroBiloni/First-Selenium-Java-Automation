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
        titleText = By.xpath("/html/body/div/div/div/div[1]/div[2]/span");
        filterDropdown = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
        filterResult = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/span");

        menuButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/button");
        allItemsButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[1]");
        aboutButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[2]");
        logoutButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[3]");
        resetAppButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[4]");
        closeMenuButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/button");

        cartButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a");

        addToCartButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button");
        
        inventoryItemLabelButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div");
        inventoryItemImageButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[1]/a/img");
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