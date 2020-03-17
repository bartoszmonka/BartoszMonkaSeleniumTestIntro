package page;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {
    private Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
    private WebElement messageLabel;

    @FindBy(css = "#center_column > h1")
    private WebElement myAccountLabel;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLoginButton() {
        signInButton.click();
        logger.info("Clicked on Login Button");
    }

    @Step("Getting warning message from Login Page")
    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        logger.info("Returned warning message was: {}", warningText);
        return warningText;
    }

    @Step("Getting MY ACCOUNT information from Login Page")
    public String getMyAccount() {
        WaitForElement.waitUntilElementIsVisible(myAccountLabel);
        String myAccountText = myAccountLabel.getText();
        logger.info("Returned MY ACCOUNT: {}", myAccountText);
        return myAccountText;
    }

}