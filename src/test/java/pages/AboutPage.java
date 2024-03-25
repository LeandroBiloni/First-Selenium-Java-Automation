package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AboutPage {
    private WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    } 

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
    }
}
