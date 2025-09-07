package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class ConsentPopupPage extends BasePage {

    @FindBy(css = "p.fc-button-label")
    private static WebElement consentButton;

    @Step("Click Consent button using FindBy annotation")
    public void handleConsent() {
        try {
            WaitForElement.waitUntilElementIsVisible(consentButton);
            if (consentButton.isDisplayed()) {
                consentButton.click();
                log().info("Consent button clicked");
            }
        } catch (Exception e) {
            log().info("Consent popup not found, continuing normally");
        }
    }
}
