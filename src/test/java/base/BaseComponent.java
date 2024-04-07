package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseComponent extends BaseWaitableObject{

    protected WebElement container;

    protected final static int TIMEOUT = 3;
    
    public BaseComponent(WebDriver driver, WebElement container) {
        super(driver);

        this.container = container;
        initializeWaiter(TIMEOUT);
    }
}
