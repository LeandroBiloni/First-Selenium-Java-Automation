package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShopPage {
    private WebDriver driver;
    private By titleText;
    private By filterDropdown;
    private By filterResult;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        titleText = By.xpath("/html/body/div/div/div/div[1]/div[2]/span");
        filterDropdown = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
        filterResult = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/span");
    }

    public void assertPage() {
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Products"));
    }
    
    public void selectFilter(int filterIndex) {
        WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
        WebElement filterElement = wait.until(ExpectedConditions.presenceOfElementLocated(filterDropdown));
        
        Select selectFilter = new Select(filterElement);
        //Select selectFilter = new Select(driver.findElement(filterDropdown));
        selectFilter.selectByIndex(filterIndex);

        WebElement filterResultElement = wait.until(ExpectedConditions.presenceOfElementLocated(filterResult));

        Assert.assertTrue(filterResultElement.getText().contains("Price (high to low)"));
        //Assert.assertTrue(driver.findElement(filterResult).getText().contains("Price (high to low)"));
    }
}