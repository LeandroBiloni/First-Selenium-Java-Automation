package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWaitableObject {
    
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    
    public BaseWaitableObject(WebDriver driver) {
        this.driver = driver;
    }

    protected void initializeWaiter(int waitTimeInSeconds) {
        webDriverWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(waitTimeInSeconds));
    }
}
