package driver;

public enum BrowserType {

    FIREFOX("firefox"), CHROME("chrome"), EDGE("microsoftedge");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}