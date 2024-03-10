package tests;

import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.ShopPage;

public class ShopTest extends CommonConditions {
    @Test(description = "Change the shop filter")
    public void filterChange() {
        WebDriverManager.setWindowSize(driver, "maximized");

        login("standard_user", "secret_sauce");
        ShopPage shopPage = new ShopPage(driver);
        shopPage.selectFilter(3);
    }    
}
