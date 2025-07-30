package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "userId")
    WebElement userIdInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement loginButton;

    @FindBy(css = ".password-toggle")
    WebElement eyeIcon;

    @FindBy(css = ".error-message")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void setUserId(String userId) {
        userIdInput.sendKeys(userId);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void togglePasswordVisibility() {
        eyeIcon.click();
    }

    public boolean isPasswordMasked() {
        return passwordInput.getAttribute("type").equals("password");
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean arePageElementsPresent() {
        return userIdInput.isDisplayed() &&
               passwordInput.isDisplayed() &&
               loginButton.isDisplayed() &&
               eyeIcon.isDisplayed();
    }
}
