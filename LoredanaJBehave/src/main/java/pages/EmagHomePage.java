package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.*;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class EmagHomePage extends LoadableComponent<EmagHomePage> {

    //*********Page Variables*********
    private SharedData sharedData;
    private DataFromPropertyFile dataFromPropertyFile;
    private WebDriverUtilities webDriverUtilities;
    //*********Web Elements*********
    @FindBy(xpath = "//span[contains(text(),'Contul meu')]")
    private WebElement myAccount;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-emag btn-sm']")
    private WebElement enterInMyAccount;
    @FindBy(xpath = "div[@class='user-avatar user-avatar-ub']//div[@class='picture']")
    private WebElement profilePic;
    @FindBy(xpath = "//p[@class='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='searchboxTrigger']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@class='ns-wrap-top-right']")
    private WebElement notificationFrame;
    @FindBy(xpath = "//a[@class='btn btn-sm btn-default']")
    private WebElement registerButton;

    @FindBy(xpath = "//button[@class='gui-btn gui-btn-escape btn-edit-details edit_details']")
    private WebElement editPersonalDataButton;
    @FindBy(xpath = "//label[contains(text(),'Dl.')]")
    private WebElement dlButton;
    @FindBy(xpath = "//label[contains(text(),'Dna.')]")
    private WebElement dnaButton;
    @FindBy(xpath = "//input[@placeholder='ex: popalex3']")
    private WebElement nicknameField;
    @FindBy(xpath = "//input[@placeholder='ex: Popescu Alexandru']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@id='mobilphone']")
    private WebElement mobileField;
    @FindBy(xpath = "//div[5]//div[1]//input[1]")
    private WebElement fixField;
    @FindBy(xpath = "//span[@id='select2-nivel_educatie-container']")
    private WebElement educationLevel;
    @FindBy(xpath = "//button[@class='gui-btn gui-btn-loader btn-save-details']")
    private WebElement saveButton;

    @FindBy(xpath = "(//*[contains(@class,'gui-label details-display')])[1]")
    private WebElement genderText;
    @FindBy(xpath = "(//*[contains(@class,'gui-label details-display')])[2]")
    private WebElement nameText;
    @FindBy(xpath = "(//*[contains(@class,'gui-label details-display')])[3]")
    private WebElement nicknameText;
    @FindBy(xpath = "(//*[contains(@class,'gui-label details-display')])[4]")
    private WebElement phoneText;
    @FindBy(xpath = "(//*[contains(@class,'gui-label details-display')])[5]")
    private WebElement fixText;
    @FindBy(xpath = "(//*[contains(@class,'gui-label details-display')])[6]")
    private WebElement dateText;
    @FindBy(xpath = "(//*[contains(@class,'gui-label details-display')])[7]")
    private WebElement educationLevelText;
    private By dropdownOptions = By.xpath("//*[@class='select2-results__option']");

    //*********Constructor*********
    public EmagHomePage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        dataFromPropertyFile = new DataFromPropertyFile();
        webDriverUtilities = new WebDriverUtilities(sharedData);
    }

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        this.sharedData.driver.get(dataFromPropertyFile.getBaseURL());
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("EmagHomePage is not loaded!", sharedData.driver.getCurrentUrl().contains(dataFromPropertyFile.getBaseURL()));
    }

    //*********Methods*********
    public LoginPage navigateToLoginPage() {
        sharedData.loginPage = clickOnMyAccount();
        return sharedData.loginPage;
    }

    public LoginPage clickOnMyAccount() {
        enterInMyAccount.click();
        return new LoginPage(sharedData);
    }

    public void clickOnProfile() {
        webDriverUtilities.waitForElementToBeVisible(myAccount, Constants.TIMEOUT);
        myAccount.click();
    }

    public void moveOverProfilePicture() {
        webDriverUtilities.moveOverElement(profilePic);
    }

    public String getStatus() {
        return webDriverUtilities.getText(name);
    }

    public ProductResultsPage searchProduct(String product) {
        webDriverUtilities.waitForElementToBeClickable(searchBar, Constants.TIMEOUT);
        searchBar.clear();
        searchBar.sendKeys(product, Keys.ENTER);
        return new ProductResultsPage(sharedData);
    }

    public String getNotificationText() {
        webDriverUtilities.waitForElementToBeVisible(notificationFrame, Constants.TIMEOUT);
        return webDriverUtilities.getText(notificationFrame);
    }

    public void editPersonalData() {
        webDriverUtilities.waitForElementToBeClickable(editPersonalDataButton, Constants.TIMEOUT);
        editPersonalDataButton.click();
    }

    public boolean isFixFieldCompleted() {
        webDriverUtilities.waitForElementToBeVisible(fixText,Constants.TIMEOUT);
        return webDriverUtilities.isFieldCompleted(fixText);
    }

    public boolean isNameFieldCompleted() {
        webDriverUtilities.waitForElementToBeVisible(nameText,Constants.TIMEOUT);
        return webDriverUtilities.isFieldCompleted(nameText);
    }

    public boolean isNickNameFieldCompleted() {
        webDriverUtilities.waitForElementToBeVisible(nicknameText,Constants.TIMEOUT);
        return webDriverUtilities.isFieldCompleted(nicknameText);
    }

    public boolean isDlButtonPressed() {
        webDriverUtilities.waitForElementToBeVisible(genderText,Constants.TIMEOUT);
        return genderText.getText().equals("Dl.");
    }

    public boolean isDnaButtonPressed() {
        webDriverUtilities.waitForElementToBeVisible(genderText,Constants.TIMEOUT);
        return genderText.getText().equals("Dna.");
        }

    public boolean isDropdownOptionSelected(String option) {
        webDriverUtilities.waitForElementToBeVisible(educationLevelText,Constants.TIMEOUT);
        return educationLevelText.getText().equals(option);
    }

    public void saveChanges() {
        webDriverUtilities.waitForElementToBeClickable(saveButton,Constants.TIMEOUT);
        saveButton.click();
    }

    public void setFixField(String no) {
        webDriverUtilities.waitForElementToBeVisible(fixField, Constants.TIMEOUT);
        fixField.clear();
        webDriverUtilities.setText(fixField,no);
    }

    public void setNameField(String name) {
        webDriverUtilities.waitForElementToBeVisible(nameField, Constants.TIMEOUT);
        nameField.clear();
        webDriverUtilities.setText(nameField,name);
    }

    public void setNickNameField(String name) {
        webDriverUtilities.waitForElementToBeVisible(nicknameField, Constants.TIMEOUT);
        nicknameField.clear();
        webDriverUtilities.setText(nicknameField,name);
    }

    public void setMobileField(String mobile) {
        webDriverUtilities.waitForElementToBeVisible(mobileField, Constants.TIMEOUT);
        mobileField.clear();
        webDriverUtilities.setText(mobileField,mobile);
    }

    public void clickOnDlButton() {
        webDriverUtilities.waitForElementToBeClickable(dlButton, Constants.TIMEOUT);
        dlButton.click();
    }

    public void clickOnDnaButton() {
        webDriverUtilities.waitForElementToBeClickable(dnaButton, Constants.TIMEOUT);
        dnaButton.click();
    }

    public String selectDropdownOption(int index) {
        educationLevel.click();
        List<WebElement> options = educationLevel.findElements(dropdownOptions);
        webDriverUtilities.waitForElementToBeClickable(options.get(index), Constants.TIMEOUT);
        String selectedOptions = options.get(index).getText();
        options.get(index).click();
        return selectedOptions;
    }
}
