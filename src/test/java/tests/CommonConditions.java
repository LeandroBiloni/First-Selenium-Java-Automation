package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helpers.Screenshoter;
import pages.LoginPage;

public class CommonConditions {
    protected WebDriver driver;
    //private ArrayList<String> tabs;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        System.out.println("El test " + result.getMethod().getDescription() + " resultó: " + result.getStatus());
        if(!result.isSuccess()){
            Screenshoter.takeScreenshot("Error", driver);
        }
        driver.close();
    }

    protected void login (String user, String pass) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);
    }
}
