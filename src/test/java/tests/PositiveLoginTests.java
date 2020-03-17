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

public class PositiveLoginTests extends TestBase {

    @Severity(SeverityLevel.BLOCKER)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if information - MY ACCOUNT is displayed after")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("testMail88@gmail.com")
                .typeIntoPasswordField("JanGate")
                .clickOnLoginButton();

        String myAccountText = loginPage.getMyAccount();
        assertEquals(myAccountText, "MY ACCOUNT");
    }

}

