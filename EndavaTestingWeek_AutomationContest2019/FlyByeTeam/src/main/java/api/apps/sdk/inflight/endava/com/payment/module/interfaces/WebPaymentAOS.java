package api.apps.sdk.inflight.endava.com.payment.module.interfaces;

import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.classic.methods.Swipe;
import core.classic.methods.Waiters;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class WebPaymentAOS {

    public WebPaymentAOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final Gestures gestures = new Gestures();

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

    public void purchaseWithCreditCard(String cardNumber, String csv) throws Exception {
        insertCardData(cardNumber, csv);
        MyLogger.log.info("Clicking on PayNow Button from Payment WebPage");
        gestures.clickOnMobileElement(payNow2);

    }

    public void insertCardData(String cardNumber, String csv) throws IOException, ParseException {
        MyLogger.log.info("Inserting card number: " + cardNumber);
        gestures.clickOnMobileElement(cardType);
        gestures.clickOnMobileElement(visaCard);
        gestures.sendText(cardNumberInput, cardNumber);
        Swipe.swipeUpGeneral();
        gestures.clickOnMobileElement(monthSelect);
        gestures.clickOnMobileElement(monthSelection);
        gestures.clickOnMobileElement(yearSelect);
        gestures.clickOnMobileElement(yearSelection);
        MyLogger.log.info("Inserting CSV number: " + csv);
        Swipe.swipeUpGeneral();
        gestures.sendText(csvCode, csv);
    }
}
