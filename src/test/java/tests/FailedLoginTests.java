package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.testng.listeners.RetryAnalyzer;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {

    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The steps of this test is using not proper user email and password" +
            " check if warning message Authentication failed is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoWrongUserEmailNameField();
        loginPage.typeIntoWrongUserPasswordField();
        loginPage.clickOnLoginButton();
        loginPage.getAuthenticationMessage();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The steps of this test is using Invalid user email and not proper password" +
            " check if warning message Invalid email address is displayed")
    public void asUserTryToLogInWithInvalidEmailAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoInvalidUserEmailNameField();
        loginPage.typeIntoWrongUserPasswordField();
        loginPage.clickOnLoginButton();
        loginPage.getInvalidEmailMessage();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The steps of this test is using proper user email and not proper password" +
            " check if warning message Authentication failed is displayed")
    public void asUserTryToLogInWithCorrectLoginAndWrongPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserEmailField();
        loginPage.typeIntoWrongUserPasswordField();
        loginPage.clickOnLoginButton();
        loginPage.getAuthenticationMessage();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The steps of this test is using proper user email and empty password field" +
            " check if warning message Password is required is displayed")
    public void asUserTryToLogInWithCorrectLoginAndEmptyPasswordField() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserEmailField();
        loginPage.typeIntoEmptyFieldUserPassword();
        loginPage.clickOnLoginButton();
        loginPage.getPasswordIsRequiredMessage();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The steps of this test is using empty field email and password" +
            " check if warning message An email address required is displayed")
    public void asUserTryToLogInWithEmptyEmailFieldAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserEmailEmptyField();
        loginPage.typeIntoPasswordField();
        loginPage.clickOnLoginButton();
        loginPage.getEmailAddressIsRequiredMessage();
    }

}