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
        loginPage.getWarningMessage();
    }

}
