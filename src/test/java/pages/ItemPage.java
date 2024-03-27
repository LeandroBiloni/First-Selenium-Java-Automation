package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ItemPage {
    private WebDriver driver;

    private By backToProductsButton;
    private By addToCarttButton;
    private By removeFromCartButton;
    private By itemLabel;

    private By cartButton;

    public ItemPage(WebDriver driver) {
        this.driver = driver;

        backToProductsButton = By.id("back-to-products");
        addToCarttButton = By.id("add-to-cart");
        removeFromCartButton = By.id("remove");
        itemLabel = By.cssSelector("div > [data-test=\"inventory-item-name\"]");

        cartButton = By.id("shopping_cart_container");
    }

    public void assertPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory-item.html?id"));
    }

    public void clickBackToProductsButton() {
        driver.findElement(backToProductsButton).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCarttButton).click();
    }

    public void clickRemoveFromCartButton() {
        driver.findElement(removeFromCartButton).click();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void compareItem(String name) {
        Assert.assertEquals(driver.findElement(itemLabel).getText(), name);
    }
}
