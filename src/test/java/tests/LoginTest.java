package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogonPage;
import pages.InventoryPage;

public class LoginTest extends CommonConditions {    

    @Test(description = "Login with wrong credentials", enabled = false)
    public void wrongLogin() {
        login("user", "user");
        LogonPage logonPage = new LogonPage(driver);
        logonPage.assertLogonPage();
    }

    @Test(description = "Login with correct credentials", enabled = false)
    public void correctLogin() {
        login(correctUser, correctPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.assertPage();
    }    

    @Test(description = "Set Web Title to User Name field", enabled = false)
    public void titleToUserName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.putTitleInUserField();
    }
}
