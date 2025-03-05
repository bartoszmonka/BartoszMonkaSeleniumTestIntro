package driver;

import configuration.TestRunProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";

    private BrowserType browserType;

    private boolean isRemoteRun;

    public BrowserFactory(BrowserType browserType, boolean isRemoteRun) {
        this.browserType = browserType;
        this.isRemoteRun = isRemoteRun;
    }

    public WebDriver getBrowser() {

        if (isRemoteRun) {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            switch (browserType) {
                case CHROME:

                    ChromeOptions chromeOptions = new ChromeOptions();
                    desiredCapabilities.merge(chromeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case FIREFOX:

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    desiredCapabilities.merge(firefoxOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case EDGE:

                    EdgeOptions edgeOptions = new EdgeOptions();
                    desiredCapabilities.merge(edgeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }

        } else {

            switch (browserType) {
                case CHROME:
                    return new ChromeDriver();
                case FIREFOX:
                    return new FirefoxDriver();
                case EDGE:
                    return new EdgeDriver();
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }

        }
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
        RemoteWebDriver remoteWebDriver = null;

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(TestRunProperties.getGridUrl()), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: " + e.getMessage());
        }
        return remoteWebDriver;
    }
}