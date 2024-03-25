package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    @FindBy(how=How.NAME, using = "user-name")
    private WebElement userFieldElement;
    //private By userField;
    @FindBy(how=How.NAME, using = "password")
    private WebElement passwordFieldElement;
    //private By passwordField;
    @FindBy(how=How.NAME, using = "login-button")
    private WebElement loginButtonElement;
    //private By loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver; 
        //userField = By.name("user-name");
        //passwordField = By.name("password");
        //loginButton = By.name("login-button");    
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        userFieldElement.sendKeys(user);
        passwordFieldElement.sendKeys(pass);
        loginButtonElement.click();
        //driver.findElement(userField).sendKeys(user);
        //driver.findElement(passwordField).sendKeys(pass);
        //driver.findElement(loginButton).click();
        
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));       
    }

    public void putTitleInUserField() {
        userFieldElement.sendKeys(driver.getTitle());
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }

    public void assertPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}

