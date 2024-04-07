package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helpers.Screenshoter;
import helpers.WebDriverManager;

public class CommonConditions {
    protected WebDriver driver;
    protected final String correctUser = "standard_user";
    protected final String correctPassword = "secret_sauce";
    //private ArrayList<String> tabs;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        WebDriverManager.setWindowSize(driver, "maximized");
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
}
