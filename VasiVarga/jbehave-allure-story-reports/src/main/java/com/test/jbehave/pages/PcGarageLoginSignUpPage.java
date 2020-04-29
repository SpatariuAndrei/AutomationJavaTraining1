package com.test.jbehave.pages;
import com.test.jbehave.utils.Driver;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class PcGarageLoginSignUpPage extends BasePageObject {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;

    @FindBy(linkText = "Contul meu")
    WebElement myAccountLink;

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


    public void signUp() throws IOException, InvalidFormatException {

        readDataFromExcel();

        type(this.newFirstName,fNameText);
        type(this.newLastName,lNameText);
        type(this.telephone,phoneText);
        type(this.newEmail,emailText);
        type(this.newPassword,passText);
        type(this.newPasswordRetype,passRetypeText);
        newsletterCheckbox.click();
        GDPRCheckbox.click();
        registerButton.click();
    }

        private void readDataFromExcel() throws IOException, InvalidFormatException {

        File src=new File("C:\\Users\\Vvarga\\IdeaProjects\\jbehave-allure-story-reports\\registrationData.xlsx");
        FileInputStream file = new FileInputStream(src);

        workbook = new XSSFWorkbook(src);

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

    public boolean isErrorTextDisplayed(){
        if(Driver.driver.findElement(By.className("error-text")).isDisplayed())
            return true;
        return false;
    }

}
