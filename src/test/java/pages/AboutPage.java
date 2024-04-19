package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;

/**
 * Class for the About page PageObject
 */
public class AboutPage extends BasePage{
    
    public AboutPage(WebDriver driver) {
        super(driver);
        pageURL = "https://saucelabs.com/";
    }
}
