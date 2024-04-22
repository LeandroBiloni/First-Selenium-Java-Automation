package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import components.LoginComponent;
import helpers.TestReports;

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
        TestReports.reportInfo("Login in with Username '" + user + "' and Password '" + pass +"'");
        loginComponent.fillUsernameField(user)
            .fillPasswordField(pass)
            .clickLoginButton();

        TestReports.reportInfo("Clicking Log In");
        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;     
    }
}

