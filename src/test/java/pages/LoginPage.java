package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import components.LoginComponent;

/**
 * Class for the Login page PageObject
 */
public class LoginPage extends BasePage {
    private By loginContainer;

    private LoginComponent loginComponent;

    public LoginPage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.saucedemo.com/";
        
        loginContainer = By.id("login_button_container");
        loginComponent = new LoginComponent(driver, getContainer(loginContainer));
    }

    /**
     * Performs the Login process with the given Username and Password
     * @param user the Username to login with
     * @param pass the Password to login with
     * @return an InventoryPage instance
     */
    public InventoryPage login(String user, String pass) {
        loginComponent.fillUsernameField(user)
            .fillPasswordField(pass)
            .clickLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;     
    }
}

