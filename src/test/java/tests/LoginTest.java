package tests;

import org.testng.annotations.Test;

import pages.LogonPage;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends CommonConditions {    

    @Test(description = "Login with wrong credentials", enabled = true)
    public void wrongLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user", "pass");
        
        LogonPage logonPage = new LogonPage(driver);
        logonPage.assertPage();
    }

    @Test(description = "Login with correct credentials", enabled = true)
    public void correctLogin() {
        //login(correctUser, correctPassword);
        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage = loginPage.login(correctUser, correctPassword);
        inventoryPage.assertPage();
        // InventoryPage inventoryPage = new InventoryPage(driver);
        // inventoryPage.assertPage();
    }
}
