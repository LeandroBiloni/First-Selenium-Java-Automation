package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), pageURL);
    }

    protected WebElement getContainer(By containerBy) {
        return driver.findElement(containerBy);
    }
}
