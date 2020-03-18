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
import static org.testng.AssertJUnit.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Severity(SeverityLevel.BLOCKER)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Steps to log in using correct user email and password" +
            " check information - MY ACCOUNT is displayed after, and click sign out")

    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserEmailField();
        loginPage.typeIntoPasswordField();
        loginPage.clickOnLoginButton();
        loginPage.signOutClick();
        loginPage.checkCorrectSignOut();
    }
}

