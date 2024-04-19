package helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Class to take screenshots of the browser
 */
public class Screenshoter {
    
    /**
     * Take a screenshot of the current browser screen
     * @param fileName the name to save the file
     * @param driver the WebDriver from which the screenshot will be taken
     */
    public static void takeScreenshot(String fileName, WebDriver driver) {
        File myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        FileUtils.copyFile(myScreenshot, new File(fileName + "_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
