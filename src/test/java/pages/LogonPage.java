package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BasePage;

public class LogonPage extends BasePage{
    private WebDriver driver;
    private By titleText;
    
    public LogonPage(WebDriver driver) {
        super(driver);
        titleText = By.cssSelector("div > h3");
    }    

    public void assertPage() {
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Epic sadface: Username"));
    }
}