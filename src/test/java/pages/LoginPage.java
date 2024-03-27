package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    private By userField;
    private By passwordField;
    private By loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver; 
        userField = By.id("user-name");
        passwordField = By.id("password");
        loginButton = By.id("login-button");    
    }

    public void login(String user, String pass) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
        
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));       
    }

    public void putTitleInUserField() {
        driver.findElement(userField).sendKeys(driver.getTitle());
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}

