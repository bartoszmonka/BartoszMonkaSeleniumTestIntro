package generic.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {

    private final Logger logger = LogManager.getLogger(AssertWebElement.class);

    public AssertWebElement(WebElement webElement) {
        super(webElement, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement) {
        return new AssertWebElement(webElement);
    }

    public AssertWebElement isDisplayed() {
        logger.info("Checking if element is displayed");
        isNotNull();

        if (!actual.isDisplayed()) {
            failWithMessage("Element was not displayed!");
        }
        logger.info("WebElement was displayed!");
        return this;
    }

    public void hasText(String expectedTextValue) {
        logger.info("Checking if WebElement has text: {}", expectedTextValue);
        isNotNull();

        String actualElementText = actual.getText();
        if (!actualElementText.equals(expectedTextValue)) {
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualElementText, expectedTextValue);
        }

        logger.info("WebElement had expected text!");
    }
}
