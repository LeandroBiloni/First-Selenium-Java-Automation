package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage extends BaseWaitableObject{
    
    protected String pageURL;
    
    protected final static int TIMEOUT = 3;

    public BasePage(WebDriver driver) {
        super(driver);
        initializeWaiter(TIMEOUT);
    }

    public String getPageURL() {
        return pageURL;
    }

    protected WebElement getContainer(By containerBy) {
        return driver.findElement(containerBy);
    }
}
