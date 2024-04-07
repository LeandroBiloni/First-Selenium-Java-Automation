package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BasePage;
import components.LoginComponent;

public class LoginPage extends BasePage {
    private By loginContainer;

    private LoginComponent loginComponent;

    public LoginPage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.saucedemo.com/";
        
        loginContainer = By.id("login_button_container");
        loginComponent = new LoginComponent(driver, getContainer(loginContainer));
    }

    public InventoryPage login(String user, String pass) {
        loginComponent.fillUsernameField(user)
            .fillPasswordField(pass)
            .clickLoginButton();

            // if (loginComponent.isErrorDisplayed()) {
            //     assertWrongLogin();
            // }
    
            InventoryPage inventoryPage = new InventoryPage(driver);
            return inventoryPage;
        // driver.findElement(userField).sendKeys(user);
        // driver.findElement(passwordField).sendKeys(pass);
        // driver.findElement(loginButton).click();
        
        //driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));       
    }

    private void assertWrongLogin()  {
        Assert.assertTrue(loginComponent.isErrorDisplayed());
    }
}

