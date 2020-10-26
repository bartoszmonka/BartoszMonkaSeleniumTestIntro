package page;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import waits.WaitForElement;

import java.text.SimpleDateFormat;
import java.sql.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class NewUserPage {
    private Logger logger = LogManager.getLogger(NewUserPage.class);
    SimpleDateFormat spf2 = new SimpleDateFormat("HHmmss");
    String HHmmss = spf2.format(new Date(System.currentTimeMillis()));
    String userEmail = "new.user.sa" + HHmmss + "@gmail.com";
    String userPass = "Good4Up455";
    String firstName = "Jan";
    String lastName = "Matejko";
    String addressLineOne = "Research Triangle Park";
    String cityName = "Columbia";
    String zipCode = "10004";
    String mobilePhoneNumber ="(347) 466-7432";

    @FindBy(id = "email_create")
    private WebElement emailNew;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = "#customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement zip;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(css = "div [class='logout']")
    private WebElement signOut;


    public NewUserPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Type into User Name Field")
    public void enterNewEmail() {
        WaitForElement.waitUntilElementIsVisible(emailNew);
        emailNew.sendKeys(userEmail);
        logger.info("Typed into user email Name Field {} ", userEmail);
    }

    @Step("Click create Account Button")
    public void clickCreateAccountButton() {
        WaitForElement.waitUntilElementIsVisible(createAccountButton);
        createAccountButton.click();
        logger.info("create Account Button click");
    }

    @Step("send first name")
    public void sendFirstName() {
        WaitForElement.waitUntilElementIsVisible(customerFirstName);
        customerFirstName.sendKeys(firstName);
        logger.info("in personal information send first name{} ", firstName);
    }

    @Step("send last name")
    public void sendLastName() {
        //WaitForElement.waitUntilElementIsVisible(customerLastName);
        customerLastName.sendKeys(lastName);
        logger.info("in personal information send last name{} ", lastName);
    }

    @Step("send password")
    public void sendPassword() {
        //WaitForElement.waitUntilElementIsVisible(password);
        password.sendKeys(userPass);
        logger.info("in personal information send password{} ", userPass);
    }

    @Step("send adres")
    public void sendAddress() {
        address.sendKeys(addressLineOne);
        logger.info("YOUR ADDRESS send adres line 1 {} ", addressLineOne);
    }

    @Step("send city")
    public void sendCity() {
        city.sendKeys(cityName);
        logger.info("in YOUR ADDRESS send city name {} ", cityName);
    }

    @Step("choose State")
    public void chooseState(){
        WebElement stateWebElement = state;
        Select stateDropDown = new Select(stateWebElement);
        stateDropDown.selectByValue("5");
        logger.info("in YOUR ADDRESS select State ");
    }

    @Step("send zip code")
    public void sendZipCode() {
        zip.sendKeys(zipCode);
        logger.info("in YOUR ADDRESS send zip code {} ", zip);
    }

    @Step("choose country")
    public void chooseCountry(){
        WebElement countryWebElement = country;
        Select countryDropDown = new Select(countryWebElement);
        countryDropDown.selectByValue("21");
        logger.info("in YOUR ADDRESS select country");
    }

    @Step("send mobile phone number")
    public void sendMobilePhoneNumber() {
        mobilePhone.sendKeys(mobilePhoneNumber);
        logger.info("in YOUR ADDRESS send mobile phone number{} ", mobilePhoneNumber);
    }

    @Step("Click create Account Button")
    public void clickRegisterButton() {
        registerButton.click();
        logger.info("Register Button click");
    }

    @Step("check correct register")
    public void checkCorrectRegister(){
    String signName = signOut.getText();
    AssertJUnit.assertEquals(signName, "Sign out");
        logger.info("assert Equals correct {} ", signName);
    }


}