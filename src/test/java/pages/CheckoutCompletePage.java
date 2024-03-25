package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutCompletePage {
    
    private WebDriver driver;
    
    private By homeButton;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        
        homeButton = By.xpath("/html/body/div/div/div/div[2]/button");
    }

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
    }

    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }
}
