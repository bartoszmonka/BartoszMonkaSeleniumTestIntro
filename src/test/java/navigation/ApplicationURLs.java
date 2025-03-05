package navigation;

import configuration.AppProperties;

public class ApplicationURLs {
    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String MAIN_URL = APPLICATION_URL;
    public static final String LOGIN_URL = APPLICATION_URL + "login";
}