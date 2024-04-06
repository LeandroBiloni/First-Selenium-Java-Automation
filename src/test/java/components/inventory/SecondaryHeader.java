package components.inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseComponent;

public class SecondaryHeader extends BaseComponent{

    private By filterDropdown;
    private By filterResult;

    public SecondaryHeader(WebDriver driver, WebElement container) {
        super(driver, container);
        
        filterDropdown = By.cssSelector("span > select");
        filterResult = By.cssSelector("[data-test=\"active-option\"]"); 
    }
    
    public SecondaryHeader selectFilter(int filterIndex) {
        WebElement filterElement = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, filterDropdown));
        
        Select selectFilter = new Select(filterElement);
        selectFilter.selectByIndex(filterIndex);

        WebElement filterResultElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(filterResult));

        Assert.assertTrue(filterResultElement.getText().contains("Price (high to low)"), "Filter didn't change to the 'Price (high to low)' option.");

        return this;
    }
}
