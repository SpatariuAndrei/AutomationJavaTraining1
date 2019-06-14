package api.apps.sdk.inflight.endava.com.payment.module.interfaces;

import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.classic.methods.Swipe;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PaymentComponentsAOS implements PaymentModule {

    public PaymentComponentsAOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Gestures gestures = new Gestures();

    /**
     * Elements for initiate module
     */

    @iOSXCUITFindBy(accessibility = "Payment")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Payment Module\")")
    private MobileElement paymentModule;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/checkbox_logging\")")
    private MobileElement enableLogging;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/checkbox_config_file\")")
    private MobileElement enableConfigFile;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_dialog_positive\")")
    private MobileElement confirmPaymentSetup;

    /**
     * Elements for fetching tariff list
     */

    @iOSXCUITFindBy(accessibility = "Fetch Tariffs")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_retrieve_tariffs_config\")")
    private MobileElement fetchCfgTariffList;

    @iOSXCUITFindBy(accessibility = "Fetch Tariffs")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_retrieve_tariffs_apikey\")")
    private MobileElement fetchApiTariffList;

//    @iOSXCUITFindBy(accessibility = "3.0€")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS[c] '3'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_buy\")")
    private MobileElement buyBtn;

    /**
     * Elements from insert payment data
     */

    @iOSXCUITFindBy(accessibility = "Skip")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/textview_personal_details\")")
    private MobileElement personalDetails;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeTextField")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/edittext_first_name\")")
    private MobileElement firstName;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]/XCUIElementTypeTextField")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/edittext_last_name\")")
    private MobileElement lastName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeTextField")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/edittext_country\")")
    public MobileElement countryCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeTextField")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/edittext_email\")")
    private MobileElement emailField;

    @iOSXCUITFindBy(accessibility = "Buy")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_pay_now\")")
    private MobileElement buyNowBtn;

    /**
     * Elements for WEB PAYMENT PAGE
     */

    @iOSXCUITFindBy(accessibility = "d Card type")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"select-1\")")
    MobileElement cardType;

    @iOSXCUITFindBy(accessibility = "ReloadButton")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Visa\")")
    MobileElement visaCard;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value MATCHES[c] 'Card Number'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"cardNumber\")")
    MobileElement cardNumberInput;

    @iOSXCUITFindBy(accessibility = "ReloadButton")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"select-2\")")
    MobileElement monthSelect;

    @iOSXCUITFindBy(accessibility = "ReloadButton")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"01\")")
    MobileElement monthSelection;

    @iOSXCUITFindBy(accessibility = "ReloadButton")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"select-3\")")
    MobileElement yearSelect;

    @iOSXCUITFindBy(accessibility = "ReloadButton")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"2022\")")
    MobileElement yearSelection;

    @iOSXCUITFindBy(accessibility = "ReloadButton")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"cccvc\")")
    MobileElement csvCode;


    @iOSXCUITFindBy(accessibility = "ReloadButton")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"submit\")")
    MobileElement payNow2;

    @Override
    public void initiateModule() {
        clickPaymentModule();
        enableLogging();
        enableCfgFile();
        confirmPaymentModuleSetup();
    }

    public void fetchTariffList() {
        fetchTarifWithConfigfile();
    }

    @Override
    public void fillUserData(String fname, String lname, String country, String email) throws IOException, ParseException {
        clickBuyAustrian();
        insertFirstName(fname);
        insertLastNamee(lname);
        insertCountry(country);
        insertEmail(email);
        buyNow();
    }

    @Override
    public void purchseWithCard(String cardNumber, String csv) throws IOException, ParseException {
        insertCardData(cardNumber, csv);
        MyLogger.log.info("Clicking on PayNow Button from Payment WebPage");
        gestures.clickOnMobileElement(payNow2);
    }

    public void clickPaymentModule() {
        try {
            MyLogger.log.info("Try to click on payment module");
            gestures.clickOnMobileElement(paymentModule);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on payment module label");
        }
    }

    public void enableLogging() {
        try {
            MyLogger.log.info("Try to click enable Logging");
            gestures.clickOnMobileElement(enableLogging);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on enable logging");
        }
    }

    public void enableCfgFile() {
        try {
            MyLogger.log.info("Try to click enable config file");
            gestures.clickOnMobileElement(enableConfigFile);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on enable config file");
        }
    }

    public void confirmPaymentModuleSetup() {
        try {
            MyLogger.log.info("Try to click on OK to confirm payment setup");
            gestures.clickOnMobileElement(confirmPaymentSetup);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on OK to confirm payment setup");
        }
    }

    public void fetchTarifWithConfigfile() {
        try {
            MyLogger.log.info("Trying to fetch tariff list with config file");
//            gestures.clickOnMobileElement(fetchCfgTariffList);
            gestures.clickOnMobileElement(fetchApiTariffList);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot fetch tariff list with config file");
        }
    }

    public void clickBuyAustrian() {
        try {
            MyLogger.log.info("Trying to click on buy btn for MESSAGE");
            gestures.clickOnMobileElement(buyBtn);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on buy btn for MESSAGE");
        }
    }

    public void insertFirstName(String firstname) {
        try {
            MyLogger.log.info("Send text to FirstName: " + firstname);
            gestures.sendText(firstName, firstname);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot text to FirstName: " + firstname);
        }
    }

    public void insertLastNamee(String lname) {
        try {
            MyLogger.log.info("Send text to LastName: " + lname);
            gestures.sendText(lastName, lname);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot text to LastName: " + lname);
        }
    }

    public void insertCountry(String country) {
        try {
            MyLogger.log.info("Send text to Country: " + country);
            gestures.sendText(countryCode, country);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot text to Country: " + country);
        }
    }

    public void insertEmail(String email) {
        try {
            MyLogger.log.info("Send text to Email: " + email);
            gestures.sendText(emailField, email);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot text to Email: " + email);
        }
    }

    public void buyNow() throws IOException, ParseException {
        try {
            MyLogger.log.info("Trying to click on PAY NOW btn");
            Swipe.swipeUpGeneral();
            gestures.clickOnMobileElement(buyNowBtn);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on PAY NOW btn");
        }
    }

    public void insertCardData(String cardNumber, String csv) throws IOException, ParseException {
        MyLogger.log.info("Inserting card number: " + cardNumber);
        gestures.clickOnMobileElement(cardType);
        gestures.clickOnMobileElement(visaCard);
        gestures.sendText(cardNumberInput, cardNumber);
        gestures.clickOnMobileElement(monthSelect);
        gestures.clickOnMobileElement(monthSelection);
        gestures.clickOnMobileElement(yearSelect);
        gestures.clickOnMobileElement(yearSelection);
        MyLogger.log.info("Inserting CSV number: " + csv);
        Swipe.swipeUp();
        gestures.sendText(csvCode, csv);
    }

}
