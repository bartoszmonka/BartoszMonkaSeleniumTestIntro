package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class HeaderPage extends BasePage {

    @FindBy(css = "a[href='/logout']")
    private WebElement logOut;

    @FindBy(css = "i[class='fa fa-home'")
    private WebElement home;

    @FindBy(css = "i[class='material-icons card_travel'")
    private WebElement products;

    @FindBy(css = "i[class='fa fa-shopping-cart'")
    private WebElement cart;

    @FindBy(css = "i[class='fa fa-lock'")
    private WebElement signUp;

    @FindBy(css = "i[class='fa fa-trash-o'")
    private WebElement deleteAccount;


    @Step("Assert that element Log out is displayed")
    public void assertLogOutIsDisplayed() {
        log().info("Checking Log out is displayed");
        WaitForElement.waitUntilElementIsVisible(logOut);
        assertThat(logOut).isDisplayed();
    }

    @Step("Assert that Home icon is displayed")
    public HeaderPage assertHomeIsDisplayed() {
        log().info("Checking Home icon is displayed");
        WaitForElement.waitUntilElementIsVisible(home);
        assertThat(home).isDisplayed();
        return this;
    }

    @Step("Assert that Products icon is displayed")
    public HeaderPage assertProductsIsDisplayed() {
        log().info("Checking Products icon is displayed");
        WaitForElement.waitUntilElementIsVisible(products);
        assertThat(products).isDisplayed();
        return this;
    }

    @Step("Assert that Cart icon is displayed")
    public HeaderPage assertCartIsDisplayed() {
        log().info("Checking Cart icon is displayed");
        WaitForElement.waitUntilElementIsVisible(cart);
        assertThat(cart).isDisplayed();
        return this;
    }

    @Step("Assert that Sign Up icon is displayed")
    public HeaderPage assertSignUpIsDisplayed() {
        log().info("Checking Sign Up icon is displayed");
        WaitForElement.waitUntilElementIsVisible(signUp);
        assertThat(signUp).isDisplayed();
        return this;
    }

    @Step("Assert that Delete Account icon is displayed")
    public HeaderPage assertDeleteAccountIsDisplayed() {
        log().info("Checking Delete Account icon is displayed");
        WaitForElement.waitUntilElementIsVisible(deleteAccount);
        assertThat(deleteAccount).isDisplayed();
        return this;
    }
}