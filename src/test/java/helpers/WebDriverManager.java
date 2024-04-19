package helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Class for handling the WebDriver
 */
public class WebDriverManager {

    protected WebDriver driver;

    /**
     * Set the browser window size
     * @param driver the WebDriver to use
     * @param size maximized - fullscreen - minimized
     */
    public static void setWindowSize(WebDriver driver, String size){
        size = size.toLowerCase();

        if (size == "maximized") {
            driver.manage().window().maximize();
        }
        
        if (size == "fullscreen") {
            driver.manage().window().fullscreen();
        }

        if (size == "minimized") {
            driver.manage().window().minimize();
        }
    }

    /**
     * Set the browser window size
     * @param driver the WebDriver to use
     * @param x the horizontal size
     * @param y the vertical size
     */
    public static void setWindowSize(WebDriver driver, int x, int y) {
        driver.manage().window().setSize(new Dimension(x, y));
    }

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
