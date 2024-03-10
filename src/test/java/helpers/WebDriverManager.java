package helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {
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

    public static void setWindowSize(WebDriver driver, int x, int y) {
        driver.manage().window().setSize(new Dimension(x, y));
    }
}
