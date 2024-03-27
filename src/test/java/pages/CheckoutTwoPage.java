package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTwoPage {
    private WebDriver driver;
    
    private By cancelButton;
    private By finishButton;
    private By itemLabel;

    public CheckoutTwoPage(WebDriver driver) {
        this.driver = driver;
        
        cancelButton = By.id("cancel");
        finishButton = By.id("finish");
        itemLabel = By.cssSelector("div > a > [data-test=\"inventory-item-name\"]");
    }

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public void assertItemAdded(String name) {
        Assert.assertEquals(driver.findElement(itemLabel).getText(), name);
    }
}
