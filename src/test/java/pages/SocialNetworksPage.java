package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SocialNetworksPage {
    private WebDriver driver;

    public SocialNetworksPage(WebDriver driver) {
        this.driver = driver;
    } 

    public void assertTwitterPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/saucelabs");
    }

    public void assertFacebookPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");
    }

    public void assertLinkedInPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");
    }
}
