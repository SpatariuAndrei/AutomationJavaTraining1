package uimappers.pages;

import uimappers.components.forms.BaseForm;
import uimappers.components.forms.CheckboxStatus;
import uimappers.components.forms.SocialMediaLoginForm;
import uimappers.utils.WebDriverUtilities;

public class LoginPage {

    private BaseForm loginForm;
    private SocialMediaLoginForm socialMediaLoginForm;
    private WebDriverUtilities driverUtilities;

    public LoginPage() {
        loginForm = new BaseForm();
        socialMediaLoginForm = new SocialMediaLoginForm();
        driverUtilities = new WebDriverUtilities();
    }

    public void setLoginInputField(String emailFieldName, String emailValue) {
        loginForm.setFieldValue(emailFieldName, emailValue);
    }

    public UserHomePage clickContinueValidPassword(String buttonName) {
        loginForm.clickButton(buttonName);
        return new UserHomePage();
    }

    public void clickContinueInvalidPassword(String buttonName) {
        loginForm.clickButton(buttonName);
    }

    public boolean verifyIfErrorMessageAppears(String errorMessage) {
        return loginForm.isWideErrorMessageDisplayed(errorMessage);
    }

    public void checkboxStatusChange(CheckboxStatus status, String checboxId) {
        loginForm.setCheckboxStatus(status.getCheckboxStatus(), checboxId);
    }

    public String getValueFromEmailField(String emailField) {
        return loginForm.getFieldValue(emailField);
    }

    public void clickOnSocialPlatformLink(String socialPlatform) {
        loginForm.clickOnFormLink(socialPlatform);
    }

    public void setGoogleEmailAccount(String googleEmailAccount) {
        socialMediaLoginForm.googleEmailAccount(googleEmailAccount);
    }

    public void pressNextButtonGooglePassword() {
        socialMediaLoginForm.pressNextGoogleButtonForPassword();
    }

    public void setGooglePassword(String googlePassword) {
        socialMediaLoginForm.googlePassword(googlePassword);
    }

    public UserHomePage pressNextButtonGoogleLogin() {
        return socialMediaLoginForm.pressNextGoogleLogin();
    }
}
