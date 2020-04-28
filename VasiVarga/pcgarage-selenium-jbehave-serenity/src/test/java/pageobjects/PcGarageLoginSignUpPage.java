package pageobjects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.CustomLoadableComponent;
import setup.PageLoadHelper;
import utils.SharedData;
import utils.SharedMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PcGarageLoginSignUpPage extends CustomLoadableComponent<PcGarageLoginSignUpPage> {

    SharedData sharedData;
    SharedMethods sharedMethods;

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;

    @FindBy(id = "searchac")
    WebElement searchTextBox;

    @FindBy(id = "email")
    WebElement signInEmail;

    @FindBy(id = "password")
    WebElement signInPass;

    @FindBy(xpath = "//*[@id=\"login\"]/div/div/button")
    WebElement signInButton;

    @FindBy(id = "newfirstname")
    WebElement newFirstName;

    @FindBy(id = "newlastname")
    WebElement newLastName;

    @FindBy(id = "telephone")
    WebElement telephone;

    @FindBy(id = "newemail")
    WebElement newEmail;

    @FindBy(id = "newpassword")
    WebElement newPassword;

    @FindBy(id = "newpasswordretype")
    WebElement newPasswordRetype;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "confidentialitate")
    WebElement GDPRCheckbox;

    @FindBy(xpath="//*[@id=\"register\"]/div/div/button")
    WebElement registerButton;

    String fNameText,lNameText,phoneText,emailText,passText,passRetypeText;

    public PcGarageLoginSignUpPage(SharedData sharedData) {
        this.sharedData=sharedData;
        PageFactory.initElements(sharedData.driver,this);
        sharedMethods = new SharedMethods(sharedData);
    }

    public void signUp() throws IOException {

        readDataFromExcel();

        sharedMethods.type(this.newFirstName,fNameText);
        sharedMethods.type(this.newLastName,lNameText);
        sharedMethods.type(this.telephone,phoneText);
        sharedMethods.type(this.newEmail,emailText);
        sharedMethods.type(this.newPassword,passText);
        sharedMethods.type(this.newPasswordRetype,passRetypeText);
        newsletterCheckbox.click();
        GDPRCheckbox.click();
        registerButton.click();
    }

        private void readDataFromExcel() throws IOException {

        File src=new File("C:\\Users\\Vvarga\\IdeaProjects\\Selenium-Serenity-Junit-Template-master\\data\\registrationData.xlsx");
        FileInputStream file = new FileInputStream(src);

        workbook = new XSSFWorkbook(file);

        sheet= workbook.getSheetAt(0);

        cell = sheet.getRow(1).getCell(0);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        fNameText = cell.getStringCellValue();

        cell = sheet.getRow(1).getCell(1);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        lNameText = cell.getStringCellValue();

        cell = sheet.getRow(1).getCell(2);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        phoneText = cell.getStringCellValue();

        cell = sheet.getRow(1).getCell(3);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        emailText = cell.getStringCellValue();

        cell = sheet.getRow(1).getCell(4);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        passText = cell.getStringCellValue();

        cell = sheet.getRow(1).getCell(5);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        passRetypeText = cell.getStringCellValue();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().
                isElementIsVisible(By.className("large-submit")).
                isElementIsVisible(By.className("large-submit"));
    }

    public boolean isErrorTextDisplayed(){
        if(sharedData.driver.findElement(By.className("error-text")).isDisplayed())
            return true;
        return false;
    }

}
