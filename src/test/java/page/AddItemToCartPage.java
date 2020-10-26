package page;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import waits.WaitForElement;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AddItemToCartPage {
    private Logger logger = LogManager.getLogger(LoginPage.class);
    String emptyField ="";

    @FindBy(css = ".available-now")
    private WebElement itemStatus;

    public AddItemToCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("check Item status - In Stock")
    public void checkItemIsInStock() {
        WaitForElement.waitUntilElementIsVisible(itemStatus);
        String status = itemStatus.getText();
        logger.info("Status Item is {}", status);
        AssertJUnit.assertEquals(status, "In stock");
    }

}