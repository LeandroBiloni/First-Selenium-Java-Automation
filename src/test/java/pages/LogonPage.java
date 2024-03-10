package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogonPage {
    private WebDriver driver;
    private By titleText;
    
    public LogonPage(WebDriver driver) {
        this.driver = driver;
        titleText = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3");
    }    

    public void assertLogonPage() {
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Epic sadface: Username"));
    }
}