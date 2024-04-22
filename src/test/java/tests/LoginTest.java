package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.TestReports;
import helpers.WebDriverManager;
import pages.InventoryPage;
import pages.LoginPage;

/**
 * Class for the Login page Tests
 */
public class LoginTest extends WebDriverManager {    

    protected final String correctUser = "standard_user";
    protected final String correctPassword = "secret_sauce";

    /**
     * Test to login with wrong credentials
     */
    @Test(description = "Login with wrong credentials", enabled = false)
    public void wrongLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user", "pass");
    }

    /**
     * Test to login with correct credentials
     */
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
