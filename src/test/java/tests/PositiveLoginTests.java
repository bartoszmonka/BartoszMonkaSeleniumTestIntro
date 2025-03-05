package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTests extends TestBase {

    @TmsLink("TC ID-2")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("This test verifies the login functionality by entering a valid username and password," +
            " and check if the logout option is displayed after successful login.")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        new LoginPage()
                .typeIntoUserNameField("vjlhmoidwyruiiibmf@ytnhy.com")
                .typeIntoPasswordField("darg#42Df@")
                .clickOnLoginButton()
                .assertLogOutIsDisplayed();
    }
}
