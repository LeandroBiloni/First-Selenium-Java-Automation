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
public class SecondaryHeaderComponent extends BaseComponent{

    private By filterDropdown;
    private By filterResult;

    public SecondaryHeaderComponent(WebDriver driver, WebElement container) {
        super(driver, container);
        
        filterDropdown = By.cssSelector("span > select");
        filterResult = By.cssSelector("[data-test=\"active-option\"]"); 
    }
    
    /**
     * Select the sort filter with the given index
     * @param filterIndex the index of the sort option to use
     * @return this SecondaryHeader instance
     */
    public SecondaryHeaderComponent selectFilter(int filterIndex) {
        logger.debug("Select filter with index: {}", filterIndex);
        
        WebElement filterElement = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, filterDropdown));
        
        Select selectFilter = new Select(filterElement);
        selectFilter.selectByIndex(filterIndex);
        
        logger.debug("Selected filter: {}", getSelectedFilterText());
        return this;
    }

    /**
     * Get the selected filter option text
     * @return the selected filter text
     */
    public String getSelectedFilterText() {
        String selectedFilter = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, filterResult)).getText();

        logger.debug("Get selected filter: {}", selectedFilter);
        return selectedFilter;
    }
}
