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

    public LoginPage clickFormAuth() {
        helper.clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown() {
        helper.clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHovers() {
        helper.clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        helper.clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        helper.clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public HomePage navigateToHomePage() {
        driver.navigate().to("http://the-internet.herokuapp.com/");
        return new HomePage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        helper.clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public AlertsPage clickJavaScriptAlert() {
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

    public WYSIWYGEditorPage clickWYSIWYGEditor() {
        helper.clickLink("WYSIWYG Editor");
        return new WYSIWYGEditorPage(driver);
    }

    public FramesPage clickFrames() {
        helper.clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        helper.clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom() {
        helper.clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll() {
        helper.clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindowsPage() {
        helper.clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
}
