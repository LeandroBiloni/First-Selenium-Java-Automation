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

        menuButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/button");
        allItemsButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[1]");
        continueShoppingButton = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[1]");
        checkoutButton = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]");
        itemName = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div");

        removeButton = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/button");
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
