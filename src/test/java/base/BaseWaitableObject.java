package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for waiting to objects to load or being found
 */
public class BaseWaitableObject {
    
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    
    public BaseWaitableObject(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Initializes the WebDriverWait with the given time
     * @param waitTimeInSeconds time to wait for objects
     */
    protected void initializeWaiter(int waitTimeInSeconds) {
        webDriverWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(waitTimeInSeconds));
    }

    
}
