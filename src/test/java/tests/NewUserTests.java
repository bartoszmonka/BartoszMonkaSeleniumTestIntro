package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.LoginPage;
import page.NewUserPage;
import utils.testng.listeners.RetryAnalyzer;

import static navigation.ApplicationURLs.LOGIN_URL;

public class NewUserTests extends TestBase {

    @Severity(SeverityLevel.BLOCKER)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Steps to add new user")

    public void asNewUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        NewUserPage newUserPage = new NewUserPage();
        newUserPage.enterNewEmail();
        newUserPage.clickCreateAccountButton();
        newUserPage.sendFirstName();
        newUserPage.sendLastName();
        newUserPage.sendPassword();
        newUserPage.sendAddress();
        newUserPage.sendCity();
        newUserPage.chooseState();
        newUserPage.sendZipCode();
        newUserPage.chooseCountry();
        newUserPage.sendMobilePhoneNumber();
        newUserPage.clickRegisterButton();
        newUserPage.checkCorrectRegister();
 
        LoginPage loginPage = new LoginPage();
        loginPage.signOutClick();
        loginPage.checkCorrectSignOut();
    }
}

