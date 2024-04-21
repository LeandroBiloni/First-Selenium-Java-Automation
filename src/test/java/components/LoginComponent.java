package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

/**
 * Class for the Login section in the Login Page
 */
public class LoginComponent extends BaseComponent {

    private By userField;
    private By passwordField;
    private By loginButton;

    public LoginComponent(WebDriver driver, WebElement container) {
        super(driver, container);

        userField = By.id("user-name");
        passwordField = By.id("password");
        loginButton = By.id("login-button");  
    }
    
    /**
     * Set the text for the Username field
     * @param username the text to write
     * @return this LoginComponent instance
     */
    public LoginComponent fillUsernameField(String username) {
        logger.debug("Enter Username: {}", username);
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, userField));
        element.sendKeys(username);
        return this;
    }

    /**
     * Set the text for the Password field
     * @param password the text to write
     * @return this LoginComponent instance
     */
    public LoginComponent fillPasswordField(String password) {
        logger.debug("Enter Password: {}", password);
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, passwordField));
        element.sendKeys(password);
        return this;
    }

    /**
     * Clicks the Login button
     * @return this LoginComponent instance
     */
    public LoginComponent clickLoginButton() {
        logger.debug("Click Login button");
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, loginButton));
        element.click();
        return this;
    }
}
