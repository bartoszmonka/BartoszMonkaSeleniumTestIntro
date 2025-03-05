package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase {

    @TmsLink("TC ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("This test verifies to log in using not proper username and password" +
            " and check if warning message Your email or password is incorrect!")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        new LoginPage()
                .typeIntoUserNameField("admin@automation.com")
                .typeIntoPasswordField("admin123")
                .clickOnLoginButton();
        new LoginPage()
                .assertThatWarningIsDisplayed("Your email or password is incorrect!");
    }
}