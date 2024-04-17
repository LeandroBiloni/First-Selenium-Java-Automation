package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends WebDriverManager {    

    protected final String correctUser = "standard_user";
    protected final String correctPassword = "secret_sauce";

    @Test(description = "Login with wrong credentials", enabled = false)
    public void wrongLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user", "pass");
    }

    @Test(description = "Login with correct credentials", enabled = true)
    public void correctLogin() {
        //Act
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(correctUser, correctPassword);

        InventoryPage inventoryPage = new InventoryPage(driver);
        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getPageURL());
    }
}
