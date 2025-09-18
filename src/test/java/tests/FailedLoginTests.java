package tests;

import driver.manager.DriverUtils;
import io.github.cdimascio.dotenv.Dotenv;
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
        Dotenv dotenv = Dotenv.configure().filename(".env.test").load();
        String username = dotenv.get("FAILED_LOGIN_USERNAME");
        String password = dotenv.get("FAILED_LOGIN_PASSWORD");

        DriverUtils.navigateToPage(LOGIN_URL);
        new LoginPage()
                .typeIntoUserNameField(username)
                .typeIntoPasswordField(password)
                .clickOnLoginButton();
        new LoginPage()
                .assertThatWarningIsDisplayed("Your email or password is incorrect!");
    }
}
