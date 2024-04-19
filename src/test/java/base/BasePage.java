package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Base class for PageObjects
 */
public abstract class BasePage extends BaseWaitableObject{
    
    protected String pageURL;
    
    protected final static int TIMEOUT = 3;

    public BasePage(WebDriver driver) {
        super(driver);
        initializeWaiter(TIMEOUT);
    }

    /**
     * Get the PageObject URL
     * @return a String URL
     */
    public String getPageURL() {
        return pageURL;
    }

    /**
     * Get the container WebElement
     * @param containerBy the locator to find the container
     * @return a WebElement
     */
    protected WebElement getContainer(By containerBy) {
        return driver.findElement(containerBy);
    }
}
