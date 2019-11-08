package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementHelper;

public class HomePage {

    private WebDriver driver;
    private WebElementHelper helper;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        helper = new WebElementHelper(driver);
    }

    //if your action changes the page -> should return a handle of that page
    public LoginPage clickFormAuthentication() {
        helper.clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickDropDown() {
        helper.clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        helper.clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickHovers() {
        helper.clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        helper.clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        helper.clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts() {
        helper.clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload() {
        helper.clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        helper.clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public EntryAdPage clickEntryAd() {
        helper.clickLink("Entry Ad");
        return new EntryAdPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditor() {
        helper.clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickFrames() {
        helper.clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        helper.clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
}
