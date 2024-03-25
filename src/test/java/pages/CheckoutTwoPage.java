package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTwoPage {
    private WebDriver driver;
    
    public CheckoutTwoPage(WebDriver driver) {
        this.driver = driver;

    }

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }
}
