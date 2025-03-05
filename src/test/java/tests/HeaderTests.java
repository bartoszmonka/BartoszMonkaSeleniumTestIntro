package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.HeaderPage;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static navigation.ApplicationURLs.MAIN_URL;

public class HeaderTests extends TestBase {

    @TmsLink("TC ID-3")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("This test verifies the visibility of the navigation bar elements before and after logging in.")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(MAIN_URL);
        new HeaderPage()
                .assertHomeIsDisplayed()
                .assertProductsIsDisplayed()
                .assertCartIsDisplayed()
                .assertSignUpIsDisplayed();

        DriverUtils.navigateToPage(LOGIN_URL);
        new LoginPage()
                .typeIntoUserNameField("vjlhmoidwyruiiibmf@ytnhy.com")
                .typeIntoPasswordField("darg#42Df@")
                .clickOnLoginButton();

        new HeaderPage()
                .assertHomeIsDisplayed()
                .assertProductsIsDisplayed()
                .assertCartIsDisplayed()
                .assertDeleteAccountIsDisplayed()
                .assertLogOutIsDisplayed();
    }
}