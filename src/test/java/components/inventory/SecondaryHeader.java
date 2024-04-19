package components.inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BaseComponent;

/**
 * Class for the Header of the Inventory Page
 */
public class SecondaryHeader extends BaseComponent{

    private By filterDropdown;
    private By filterResult;

    public SecondaryHeader(WebDriver driver, WebElement container) {
        super(driver, container);
        
        filterDropdown = By.cssSelector("span > select");
        filterResult = By.cssSelector("[data-test=\"active-option\"]"); 
    }
    
    /**
     * Select the sort filter with the given index
     * @param filterIndex the index of the sort option to use
     * @return this SecondaryHeader instance
     */
    public SecondaryHeader selectFilter(int filterIndex) {
        WebElement filterElement = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, filterDropdown));
        
        Select selectFilter = new Select(filterElement);
        selectFilter.selectByIndex(filterIndex);
        return this;
    }

    /**
     * Get the selected filter option text
     * @return the selected filter text
     */
    public String getSelectedFilterText() {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(filterResult)).getText();
    }
}
