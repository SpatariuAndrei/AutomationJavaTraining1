package pages;

import org.openqa.selenium.WebDriver;
import utils.WindowManager;

public class HomePage {
    private WebDriver driver;
    private WindowManager windowManager;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        windowManager = new WindowManager(driver);
    }

    public LoginPage clickformAuthentication() {
        windowManager.clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown() {
        windowManager.clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        windowManager.clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickhoversPage() {
        windowManager.clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        windowManager.clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSliderPage() {
        windowManager.clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public JavaScriptAlertsPage clickJSAlertsPage() {
        windowManager.clickLink("JavaScript Alerts");
        return new JavaScriptAlertsPage(driver);
    }

    public FileUploadPage clickFileUploadPage() {
        windowManager.clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public EntryAdPage clickEntryAdPage() {
        windowManager.clickLink("Entry Ad");
        return new EntryAdPage(driver);
    }

    public ContextMenuPage clickContextMenuPage() {
        windowManager.clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public EditorPage clickEditorPage() {
        windowManager.clickLink("WYSIWYG Editor");
        return new EditorPage(driver);
    }

    public FramesPage clickFramesPage() {
        windowManager.clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingPage() {
        windowManager.clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDoomPage clickLargeAndDeepDoomPage() {
        windowManager.clickLink("Large & Deep DOM");
        return new LargeAndDeepDoomPage(driver);
    }

    public InfiniteScrollPage clickInfintieScrollPage() {
        windowManager.clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindow2Page clickMultipleWindowsPage() {
        windowManager.clickLink("Multiple Windows");
        return new MultipleWindow2Page(driver);
    }
}
