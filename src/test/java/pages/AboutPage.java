package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class AboutPage extends BasePage{
    
    public AboutPage(WebDriver driver) {
        super(driver);
        pageURL = "https://saucelabs.com/";
    }
}
