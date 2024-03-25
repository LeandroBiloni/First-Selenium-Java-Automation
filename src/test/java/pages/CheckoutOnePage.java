package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutOnePage {
 
    private WebDriver driver;

    public CheckoutOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }
}
