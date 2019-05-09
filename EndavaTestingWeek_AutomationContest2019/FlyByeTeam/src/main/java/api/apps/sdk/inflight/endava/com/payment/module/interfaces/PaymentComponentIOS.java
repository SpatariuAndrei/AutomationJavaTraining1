package api.apps.sdk.inflight.endava.com.payment.module.interfaces;

import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.classic.methods.MobileGestures;
import core.classic.methods.Waiters;
import core.helpers.ContextHandler;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PaymentComponentIOS extends PaymentComponentsAOS {

    public PaymentComponentIOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Gestures gestures = new Gestures();
    private final Waiters waiters = new Waiters();

    @iOSXCUITFindBy(accessibility = "Confirm Buy")
    private MobileElement confirmBuy;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypePickerWheel' AND value CONTAINS[c] 'InvalidCountry (AB)'")
    private MobileElement countryPicker;

    @iOSXCUITFindBy(accessibility = "Done")
    private MobileElement doneCountry;

    /**
     * ELEMENTS FROM WEBPAGE
     */

    private final By cardNumberInput = By.xpath("//*[@id=\"cardNumber\"]");
    private final By monthSelect = By.xpath("//*[@id=\"cardExpirationMonth\"]");
    private final By aprilMonth = By.xpath("//*[@id=\"cardExpirationMonth\"]/option[10]");
    private final By yearDroDown = By.xpath("//*[@id=\"cardExpirationYear\"]");
    private final By validYear = By.xpath("//*[@id=\"cardExpirationYear\"]/option[7]");
    private final By csvCode = By.xpath("//*[@id=\"cccvc\"]");
    private final By payNow2 = By.xpath("//*[@id=\"submit\"]");

    @Override
    public void initiateModule() {
        super.clickPaymentModule();
    }

    @Override
    public void fillUserData(String fname, String lname, String country, String email) throws IOException, ParseException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.clickBuyAustrian();
        clickConfirmBuy();
        super.insertEmail(email);
        super.insertFirstName(fname);
        super.insertLastNamee(lname);
        selectCountry();
        MobileGestures.selectPickerWheelValueMobile(countryPicker, "next");
        clickDoneCountry();
        super.buyNow();
    }

    @Override
    public void purchseWithCard(String cardNumber, String csv) throws IOException, ParseException {

        try {
            try {
                waiters.simulateWaiterInsteadOsThreadSleep(countryPicker, 12);
            } catch (WebDriverException e) {
                //do nothing
            }
            ContextHandler.switchToWebview();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        MyLogger.log.info("Inserting card number: " + cardNumber);
        this.gestures.sendTextWithoutClear(this.cardNumberInput, cardNumber);
        this.gestures.clickOn(this.monthSelect);
        this.gestures.clickOn(this.aprilMonth);
        this.gestures.clickOn(this.yearDroDown);
        this.gestures.clickOn(this.validYear);
        MyLogger.log.info("Inserting CSV number: " + csv);
        this.gestures.sendTextWithoutClear(this.csvCode, csv);


        MyLogger.log.info("Clicking on PayNow Button from Payment WebPage");
        gestures.clickOn(payNow2);

        MyLogger.log.info("Switch to NATIVE context");
        Drivers.getMobileDriver().context("NATIVE_APP");
    }

    public void clickConfirmBuy() {
        try {
            MyLogger.log.info("Try to click on confirm buy");
            gestures.clickOnMobileElement(confirmBuy);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on confirm buy");
        }
    }

    public void selectCountry() {
        try {
            MyLogger.log.info("Try to select country");
            gestures.clickOnMobileElement(countryCode);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot select country");
        }
    }

    public void clickDoneCountry() {
        try {
            MyLogger.log.info("Try to click done country");
            gestures.clickOnMobileElement(doneCountry);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click done country");
        }
    }


}
