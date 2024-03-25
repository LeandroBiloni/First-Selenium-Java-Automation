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
        
        cancelButton = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[1]");
        finishButton = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]");
        itemLabel = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div");
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
