package page;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import waits.WaitForElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPage {
    private Logger logger = LogManager.getLogger(LoginPage.class);
    String userEmail ="testMail88@gmail.com";
    String userPassword ="JanGate";
    String userWrongEmail ="wrongpwd42@gmail.com";
    String userWrongPassword ="WrongWrong";

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

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
    private WebElement signOut;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Type into User Name Field {username}")
    public void typeIntoUserNameField() {
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.sendKeys(userEmail);
        logger.info("Typed into User Name Field {}", userEmail);
    }

    @Step("Type into Password Field {password}")
    public void typeIntoPasswordField() {
        passwordField.clear();
        passwordField.sendKeys(userPassword);
        logger.info("Typed into Password Field {}", userPassword);
    }

    @Step("Type into User Name Field {username}")
    public void typeIntoWrongUserEmailNameField() {
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.sendKeys(userWrongEmail);
        logger.info("Typed into User Name Field {}", userWrongEmail);
    }

    @Step("Type into Password Field {password}")
    public void typeIntoWrongUserPasswordField() {
        passwordField.clear();
        passwordField.sendKeys(userWrongPassword);
        logger.info("Typed into Password Field {}", userWrongPassword);
    }

    @Step("Click on Login Button")
    public void clickOnLoginButton() {
        signInButton.click();
        logger.info("Clicked on Login Button");
    }

    @Step("Getting warning message from Login Page")
    public void getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        logger.info("Returned warning message was: {}", warningText);
        AssertJUnit.assertEquals(warningText, "Authentication failed.");
    }

    @Step("Getting MY ACCOUNT information from Login Page")
    public void getMyAccount() {
        WaitForElement.waitUntilElementIsVisible(myAccountLabel);
        String myAccountText = myAccountLabel.getText();
        logger.info("Returned MY ACCOUNT: {}", myAccountText);
        assertEquals(myAccountText, "MY ACCOUNT");
    }
    @Step("Click Sign Out from Login Page")
    public void signOutClick(){
        signOut.click();
        logger.info("Click Sign Out");
    }
    @Step("Check Sign In Button is Displayed in page")
    public void checkCorrectSignOut(){
        WaitForElement.waitUntilElementIsVisible(signInButton);
        assertTrue(signInButton.isDisplayed());
        logger.info("sign In Button is Displayed");
    }

}