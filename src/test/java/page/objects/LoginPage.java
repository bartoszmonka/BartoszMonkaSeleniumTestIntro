package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "p[style=\"color: red;\"]")
    private WebElement messageLabel;

    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        log().info("Typed into User Name Field {}", username);
        return this;
    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed into Password Field {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public HeaderPage clickOnLoginButton() {
        loginButton.click();
        log().info("Clicked on Login Button");
        return new HeaderPage();
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public void assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
    }
}