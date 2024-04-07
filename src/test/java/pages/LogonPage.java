package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BasePage;

public class LogonPage extends BasePage{
    private By titleText;
    
    public LogonPage(WebDriver driver) {
        super(driver);
        titleText = By.cssSelector("div > h3");
    }    

    public void assertPage() {
        WebElement errorElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(titleText));
        Assert.assertTrue(errorElement.isDisplayed());
    }
}