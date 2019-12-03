package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.readtables.ReadingTableFiles;
import utilities.DataFromPropertyFile;

import java.util.HashMap;

public class PersonalDataPage {

    //TODO scroll to filds 1

    //Forma adresare
    @FindBy(xpath = "//label[contains(text(),'Dl.')]")
    private WebElement maleButton;

    @FindBy(xpath = "//label[contains(text(),'Dna.')]")
    private WebElement femaleButton;

    //Nume Prenume
    @FindBy(xpath = "//*[@id=\"detailsForm\"]/fieldset/div[2]/div/input")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id=\"detailsForm\"]/fieldset/div[3]/div/input")
    private WebElement userNickNameField;

    @FindBy(id = "//input[@id='mobilphone']")
    private WebElement mobileField;

    //Data nasterii
    @FindBy(xpath = "//span[@id='select2-ziua-8s-container']")
    private WebElement dayOfBirth;

    @FindBy(xpath = "//span[@id='select2-luna-6z-container']")
    private WebElement monthOfBirth;

    @FindBy(xpath = "//span[@id='select2-anul-fk-container']")
    private WebElement yearOfBirth;

    //Nivel Educatie
    @FindBy(xpath = "//span[@id='select2-nivel_educatie-container']")
    private WebElement educationLevel;

    @FindBy(xpath = "//button[@class='gui-btn gui-btn-loader btn-save-details']")
    private WebElement save1Buttom;

    //js.executeScript("window.scrollTo(0,200)");
    @FindBy(xpath = "//div[@class='user-account page-section mrg-btm-md']//div[5]//button[1]")
    private WebElement addMyDataButton;

    //adresa livrare form
    @FindBy(xpath = "//form[@class='gui-form form-address']")
    private WebElement addressDetailsForm;

    @FindBy(xpath = "//div[@class='gui-form-control -error']//input[@placeholder='ex: Popescu Alexandru']")
    private WebElement lastNameAndFirstNameField;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement mobilePhoneField;

    @FindBy(xpath = "//span[@id='select2-region-container']")
    private WebElement countyField;

    @FindBy(xpath = "//span[@id='select2-locality-mc-container']")
    private WebElement townField;

    @FindBy(xpath = "//input[@placeholder='ex: Strada, numar, bloc, scara, etaj, apartament']")
    private WebElement addressField;

    @FindBy(xpath = "//button[@class='gui-btn gui-btn-loader']")
    private WebElement saveAddressButton;

    private WebDriver driver;
    private DataFromPropertyFile propertyFile;
    private HashMap<String, String> dataMap;
    private JavascriptExecutor js;
    private ReadingTableFiles readingTableFiles;

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        propertyFile = new DataFromPropertyFile();
        js = (JavascriptExecutor) driver;
        populateMap();
    }

    public void populateMap() {
        readingTableFiles = new ReadingTableFiles();
        dataMap = readingTableFiles.readDataTables(propertyFile);
    }

    public void populateEmagPage() {

        //find gender
        if (dataMap.get("user.gender").equals("male")) {
            maleButton.click();
        } else {
            femaleButton.click();
        }

        //find name
        userNameField.sendKeys(dataMap.get("user.name"));

        //find nickname
        userNickNameField.sendKeys(dataMap.get("user.name").substring(0, 6));

        //find mobile
        mobileField.sendKeys(dataMap.get("user.mobile"));

        //find birth date
        dayOfBirth.click();
        dayOfBirth.sendKeys(dataMap.get("user.birthdate").substring(0, 2));
        dayOfBirth.submit();
    }


}
