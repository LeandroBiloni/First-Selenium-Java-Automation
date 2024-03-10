package tests;

import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.LoginPage;
import pages.LogonPage;
import pages.ShopPage;

public class LoginTest extends CommonConditions {    

    @Test(description = "Wrong Login")
    public void wrongLogin() {
        WebDriverManager.setWindowSize(driver, "maximized");
        // driver.switchTo().window(tabs.get(1)).navigate().to("http://www.youtube.com");
        // driver.switchTo().window(tabs.get(0));
        
        login("user", "user");
        LogonPage logonPage = new LogonPage(driver);
        logonPage.assertLogonPage();
    }

    @Test(description = "Login with correct credentials")
    public void correctLogin() {
        WebDriverManager.setWindowSize(driver, "maximized");

        login("standard_user", "secret_sauce");
        ShopPage shopPage = new ShopPage(driver);
        shopPage.assertPage();
    }    

    @Test(description = "Set Web Title to User Name field")
    public void titleToUserName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.putTitleInUserField();
    }
}
