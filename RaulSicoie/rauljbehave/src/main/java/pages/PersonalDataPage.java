package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.utils.WebDriverUtilities;
import utilities.DataFromPropertyFile;
import utilities.constants.TimeConstants;
import utilities.readtables.ReadingTableFiles;
import utilities.scroll.Scroll;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class PersonalDataPage {

    @FindBy(xpath = "//button[@class='gui-btn gui-btn-escape btn-edit-details edit_details']")
    private WebElement editDataButton;

    @FindBy(xpath = "//div[@class='general-info-account-box account_box']")
    private WebElement dataContainer;

    //Forma adresare
    @FindBy(xpath = "//label[contains(text(),'Dl.')]")
    private WebElement maleButton;

    @FindBy(xpath = "//label[contains(text(),'Dna.')]")
    private WebElement femaleButton;

    //Nume Prenume
    @FindBy(xpath = "//input[@placeholder='ex: Popescu Alexandru']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@placeholder='ex: popalex3']")
    private WebElement userNickNameField;

    @FindBy(id = "mobilphone")
    private WebElement mobileField;

    //Data nasterii
    @FindBy(xpath = "//select[@name='ziua']")
    private WebElement dayOfBirth;

    @FindBy(xpath = "//select[@name='luna']")
    private WebElement monthOfBirth;

    @FindBy(xpath = "//select[@name='anul']")
    private WebElement yearOfBirth;

    //Nivel Educatie
    @FindBy(css = "#nivel_educatie")
    private WebElement educationLevel;

    @FindBy(xpath = "//button[@class='gui-btn gui-btn-loader btn-save-details']")
    private WebElement saveMyDataButton;

    @FindBy(xpath = "//div[@class='user-account page-section mrg-btm-md']//div[5]//button[1]")
    private WebElement addMyAddressButton;

    //adresa livrare form
    @FindBy(xpath = "//form[@class='gui-form form-address']")
    private WebElement addressDetailsForm;

    @FindBy(xpath = "//div[@class='gui-form-control']//input[@placeholder='ex: Popescu Alexandru']")
    private WebElement lastNameAndFirstNameField;

    @FindBy(id = "phone")
    private WebElement mobilePhoneField;

    @FindBy(css = "#region")
    private WebElement countyField;

    @FindBy(xpath = "//select[@name='locality']")
    private WebElement townField;

    @FindBy(xpath = "//input[@placeholder='ex: Strada, numar, bloc, scara, etaj, apartament']")
    private WebElement addressField;

    @FindBy(xpath = "//button[@class='gui-btn gui-btn-loader']")
    private WebElement saveAddressButton;

    @FindBy(xpath = "//a[@class='close-modal']")
    private WebElement closeAddressButton;

    @FindBy(xpath = "//span[@class='gui-btn gui-btn-escape btn-edit-address']")
    private WebElement modifyAddress;

    @FindBy(xpath = "//span[@id='select2-region-container']")
    private WebElement countyValue;

    @FindBy(xpath = "//span[contains(@id,'select2-locality-')]")
    private WebElement townValue;

    @FindBy(id = "emg-user-menu")
    private WebElement myAccount;

    @FindBy(linkText = "Log out")
    private WebElement logOutButton;

    private WebDriver driver;
    private DataFromPropertyFile propertyFile;
    private JavascriptExecutor js;
    private ReadingTableFiles readingTableFiles;
    private WebDriverUtilities driverUtilities;

    private HashMap<String, String> dataMap;
    private HashMap<String, String> siteData;

    PersonalDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        propertyFile = new DataFromPropertyFile();
        driverUtilities = new WebDriverUtilities();
        js = (JavascriptExecutor) driver;
        populateMap();
    }

    public void populateMap() {
        readingTableFiles = new ReadingTableFiles();
        dataMap = readingTableFiles.readDataTables(propertyFile);
    }

    public void populateEmagPage() throws IOException {

        driverUtilities.waitForElementToBeVisible(editDataButton, TimeConstants.SHORT_TIMEOUT);
        editDataButton.click();
        driverUtilities.waitForElementToBeVisible(dataContainer, TimeConstants.LONG_TIMEOUT);

        //set gender
        if (dataMap.get("user.gender").equals("male")) {
            driverUtilities.waitForElementToBeClickable(maleButton, TimeConstants.LONG_TIMEOUT);
            maleButton.click();
        } else {
            driverUtilities.waitForElementToBeClickable(femaleButton, TimeConstants.LONG_TIMEOUT);
            femaleButton.click();
        }

        //set name
        userNameField.clear();
        userNameField.sendKeys(dataMap.get("user.name"));

        //set nickname
        userNickNameField.clear();
        userNickNameField.sendKeys(dataMap.get("user.nickname"));

        //set mobile
        mobileField.clear();
        mobileField.sendKeys(dataMap.get("user.mobile"));

        //set birth date
        Select drpDay = new Select(dayOfBirth);
        String day = dataMap.get("user.birthdate").substring(0, 2);
        drpDay.selectByVisibleText(day);

        //set birth month
        Select drpMonth = new Select(monthOfBirth);
        String month = dataMap.get("user.birthdate").substring(3, 5);
        if (Integer.parseInt(month) >= 01 && Integer.parseInt(month) <= 12) {
            drpMonth.selectByVisibleText(month);
        } else {
            throw new IOException("Wrong birth date data!");
        }

        //set birth year
        Select drpYear = new Select(yearOfBirth);
        String year = dataMap.get("user.birthdate").substring(6, 10);
        drpYear.selectByVisibleText(year);

        //set education
        Select drpEducation = new Select(educationLevel);
        String education = dataMap.get("user.education");
        drpEducation.selectByVisibleText(education);

        saveMyDataButton.click();

        //scroll down to adresa livrare
        Scroll.scrollToElement(addMyAddressButton, driver);
        driverUtilities.waitForElementToBeClickable(addMyAddressButton, TimeConstants.SHORT_TIMEOUT);
        addMyAddressButton.click();
        driverUtilities.waitForElementToBeVisible(addressDetailsForm, TimeConstants.SHORT_TIMEOUT);

        //set Persoana de contact
        lastNameAndFirstNameField.sendKeys(dataMap.get("user.name"));
        mobilePhoneField.sendKeys(dataMap.get("user.mobile"));

        driverUtilities.waitForElementToBeClickable(countyField, TimeConstants.LONG_TIMEOUT);
        Select drpCounty = new Select(countyField);
        String county = dataMap.get("user.county");
        drpCounty.selectByVisibleText(county);

        driverUtilities.waitForElementToBeClickable(townField, TimeConstants.LONG_TIMEOUT);
        Select drpTown = new Select(townField);
        String town = dataMap.get("user.town");
        drpTown.selectByVisibleText(town);

        addressField.sendKeys(dataMap.get("user.address"));
        saveAddressButton.click();

        //if the same address exists already, close the window
        closeAddressButton.click();
    }


    public HashMap<String, String> getUserDataFromEmag() {
        siteData = new HashMap<>();
        String newMonth = null;

        Scroll.scrollToElement(editDataButton, driver);

        driverUtilities.waitForElementToBeVisible(editDataButton, TimeConstants.SHORT_TIMEOUT);
        editDataButton.click();

        driverUtilities.waitForElementToBeVisible(maleButton, TimeConstants.LONG_TIMEOUT);
        if (maleButton.isEnabled()) {
            siteData.put("Forma de adresare", maleButton.getText());
        } else if (femaleButton.isEnabled()) {
            siteData.put("Forma de adresare", femaleButton.getText());
        }

        siteData.put("Nume Prenume", userNameField.getAttribute("value").trim());
        siteData.put("Nickname", userNickNameField.getAttribute("value").trim());
        siteData.put("Telefon Mobil", mobileField.getAttribute("value").trim());

        //prelucrare birth month
        String monthOfBirthValue = monthOfBirth.getAttribute("value").trim();
        if (monthOfBirthValue.length() == 1) {
            newMonth = "0" + monthOfBirthValue;
        }
        siteData.put("Data nasterii", dayOfBirth.getAttribute("value").trim() + "-" +
                newMonth + "-" +
                yearOfBirth.getAttribute("value").trim());

        Scroll.scrollToElement(modifyAddress, driver);

        //Adresa livrare
        driverUtilities.waitForElementToBeClickable(modifyAddress, TimeConstants.SHORT_TIMEOUT);
        modifyAddress.click();
        driverUtilities.waitForElementToBeVisible(addressDetailsForm, TimeConstants.SHORT_TIMEOUT);

        //persons name from Address field
        siteData.put("Name Address Field", lastNameAndFirstNameField.getAttribute("value").trim());
        //persons phone number from Address field
        siteData.put("Mobile Address Field", mobilePhoneField.getAttribute("value").trim());
        //persons county from Address Field
        siteData.put("County", countyValue.getText().trim());
        //persons town from Address Field
        siteData.put("Town", townValue.getText().trim());
        //persons address from Address Field
        siteData.put("Address", addressField.getAttribute("value").trim());

        closeAddressButton.click();

        return siteData;
    }

    public void checkIfDataIsCorrect() {
        siteData = getUserDataFromEmag();
        //test for name
        assertEquals(dataMap.get("user.name"), siteData.get("Nume Prenume"));
        assertEquals(dataMap.get("user.name"), siteData.get("Name Address Field"));
        //test for nickname
        assertEquals(dataMap.get("user.nickname"), siteData.get("Nickname"));

        //test for phone number
        assertEquals(dataMap.get("user.mobile"), siteData.get("Telefon Mobil"));
        assertEquals(dataMap.get("user.mobile"), siteData.get("Mobile Address Field"));

        //test for town
        assertEquals(dataMap.get("user.town"), siteData.get("Town"));
        //test for county
        assertEquals(dataMap.get("user.county"), siteData.get("County"));
        //test for address
        assertEquals((dataMap.get("user.address")), siteData.get("Address"));

        //test for gender
        String addressingFormula = "";
        if (dataMap.get("user.gender").equals("male")) {
            addressingFormula = "Dl.";
        } else if (dataMap.get("user.gender").equals("female")) {
            addressingFormula = "Dna.";
        }
        assertEquals(addressingFormula, siteData.get("Forma de adresare"));

        //test for birth data
        assertEquals(dataMap.get("user.birthdate"), siteData.get("Data nasterii"));
    }

    public void logOut() {
        Actions action = new Actions(driver);
        action.moveToElement(myAccount).build().perform();
        driverUtilities.waitForElementToBeClickable(logOutButton, TimeConstants.LONG_TIMEOUT);
        logOutButton.click();
    }
}
