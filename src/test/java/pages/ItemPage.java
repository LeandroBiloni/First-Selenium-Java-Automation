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

        backToProductsButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/div/button");
        addToCarttButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/button");
        removeFromCartButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/button");
        itemLabel = By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[1]");

        cartButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a");
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
