package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseComponent;

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
    
    public LoginComponent fillUsernameField(String username) {
        //WebElement element = container.findElement(userField);
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, userField));
        element.sendKeys(username);
        return this;
    }

    public LoginComponent fillPasswordField(String password) {
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, passwordField));
        element.sendKeys(password);
        return this;
    }

    public LoginComponent clickLoginButton() {
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(container, loginButton));
        element.click();
        return this;
    }
}
