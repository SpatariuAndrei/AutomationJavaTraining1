package api.apps.sdk.inflight.endava.com.payment.module.interfaces;

import api.drivers.Drivers;
import core.classic.methods.Waiters;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import junit.framework.Assert;
import okhttp3.*;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class M3handlerPayment {

    public M3handlerPayment() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();

    /**
     * Elements for getting M3Connect Username and Password
     */

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] 'Username'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/textview_username\")")
    MobileElement username;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] 'Password'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/textview_password\")")
    MobileElement password;

    public Response createSession() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .followRedirects(false)
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "authorization=api_key%3D494cad35-4c43-4f79-a564-98b9481b52ac&with-scene-config=true&undefined=");
        Request request = new Request.Builder()
                .url("https://portal.inflight-wifi.com/wbs/api/v1/create-session/")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache,no-cache")
                .addHeader("postman-token", "2d7d4ef1-b3aa-1931-d867-0dc6718b9a52")
                .addHeader("Postman-Token", "068c1ea0-c17c-4e85-b4ef-e1d9a007b97d")
                .build();
        Response response = client.newCall(request).execute();
        MyLogger.log.info("Verifying that Create Session was successfull: " + response.toString());
        Assert.assertTrue("Create Session was not successfull on M3", response.toString().contains("code=200"));
        return response;
    }

    public Response getLoginWithReceivedM3Cred(String paymentType) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .followRedirects(false)
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "authorization=session%3D" + getSessionId() + "&login%5Busername%5D=" + getUsername(paymentType) + "&login%5Bpassword%5D=" + getPassword(paymentType) + "&undefined=");
        Request request = new Request.Builder()
                .url("https://portal.inflight-wifi.com/wbs/api/v1/login/voucher/")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "6913e715-6f78-4ec2-8bbe-58dd82a5c6ca")
                .build();
        Response response = client.newCall(request).execute();
        MyLogger.log.info("Verifying that Login was successfull: " + response.toString());
        Assert.assertTrue("Login was not successfull on M3", response.toString().contains("code=200"));
        return response;
    }

    public void validateM3SuccessLogin(String paymentType) throws IOException {
        Assert.assertTrue("Login was not successfull on M3", loggedInMessageFromM3(paymentType).contains("UNKNOWN"));

    }

    public String getSessionId() throws IOException {
        String m3sessionid = createSession().body().string().substring(12, 38);
        MyLogger.log.info("Session ID is: " + m3sessionid);
        return m3sessionid;
    }

    public String getUsername(String paymentType) throws FileNotFoundException {
        waiters.waitForElementVIsibility(username);
        if (runningSetup().getPlatformName().equalsIgnoreCase("android") || paymentType.equalsIgnoreCase("directPay")) {
            String m3user = username.getText().replace("Username:", "");
            String finalm3user = m3user.replaceAll("\\s+", "");
            MyLogger.log.info("USERMAIL is: '" + finalm3user + "'");
            return finalm3user;
        } else {
            waiters.waitForElementVIsibility(username);
            String m3user = username.getText().substring(80, 89);
            MyLogger.log.info("USERMAIL is: '" + m3user + "'");
            return m3user;
        }
    }

    public String getPassword(String paymentType) throws FileNotFoundException {
        waiters.waitForElementVIsibility(password);
        if (runningSetup().getPlatformName().equalsIgnoreCase("android") || paymentType.equalsIgnoreCase("directPay")) {
            String m3password = password.getText().replace("Password:", "");
            String finalm3password = m3password.replaceAll("\\s+", "");
            MyLogger.log.info("PASSWORD is: '" + finalm3password + "'");
            return finalm3password;
        } else {
            String m3password = username.getText().substring(99, 104);
            MyLogger.log.info("PASSWORD is: '" + m3password + "'");
            return m3password;
        }
    }

    public String loggedInMessageFromM3(String paymentType) throws IOException {
        String m3loggedinresponse = null;
        m3loggedinresponse = getLoginWithReceivedM3Cred(paymentType).body().string();
        MyLogger.log.info(m3loggedinresponse);
        return m3loggedinresponse;
    }

}
