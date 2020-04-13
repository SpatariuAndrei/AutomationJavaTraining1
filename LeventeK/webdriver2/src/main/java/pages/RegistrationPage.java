package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RegistrationPage{

    private WebDriver driver;
    private By firstNameField = By.cssSelector("[ng-model='FirstName']");
    private By lastNameField = By.cssSelector("[ng-model='LastName']");
    private By addressField = By.cssSelector("[ng-model='Adress']");
    private By emailField = By.cssSelector("[ng-model='EmailAdress']");
    private By phoneField = By.cssSelector("[ng-model='Phone']");
    private By genderMaleRadioButton = By.cssSelector("[value^='Male']");
    private By genderFeMaleRadioButton = By.cssSelector("[value^='FeMale']");
    private By cricketCheckBox = By.id("checkbox1");
    private By moviesCheckBox = By.id("checkbox2");
    private By hockeyCheckbox = By.id("checkbox3");
    private By skillsDropdown = By.id("Skills");
    private By countryDropdown = By.id("countries");
    private By yearDropdown = By.id("yearbox");
    private By monthDropdown = By.cssSelector("[ng-model='monthbox']");
    private By dayDropdown = By.id("daybox");
    private By passwordField = By.id("firstpassword");
    private By confirmPasswordField = By.id("secondpassword");
    private By submitButton = By.id("submitbtn");


    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    /**
     * @param email Only accepts String in valid email formats
     */
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * @param phoneNumber Only accepts input type int of size 10 INT(10)
     */
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void setGenderMale(){
        driver.findElement(genderMaleRadioButton).click();
    }

    public void setGenderFeMale(){
        driver.findElement(genderFeMaleRadioButton).click();
    }

    public void setCricketHobby(){
        driver.findElement(cricketCheckBox).click();
    }

    public void setMoviesHobby(){
        driver.findElement(moviesCheckBox).click();
    }

    public void setHockeyHobby(){
        driver.findElement(hockeyCheckbox).click();
    }


    public void selectFromSkillsDropDown(String option){
        findDropDownElement(skillsDropdown).selectByVisibleText(option);

    }


    public void selectFromCountryDropdown(String option){
        findDropDownElement(countryDropdown).selectByVisibleText(option);
    }

    /**
     * @param option 1916-2015
     */
    public void selectFromYearDropdown(String option){
        findDropDownElement(yearDropdown).selectByVisibleText(option);
    }

    public void selectFromMothDropdown(String option){
        findDropDownElement(monthDropdown).selectByVisibleText(option);
    }

    /**
     * @param option 1-31
     */
    public void selectFromDayDropdown(String option){
        findDropDownElement(dayDropdown).selectByVisibleText(option);
    }

    /**
     * @param password minimum length=6, must contain an UPPERCASE,a lowercase and a number
     */
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * @param password has to be identical to password field
     */
    public void setConfirmPassword(String password){
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public WebTablePage clickSubmitButton(){
        driver.findElement(submitButton).click();

        return new WebTablePage(driver);
    }



    public List<String> getSelectedOptions(By dropdown){
        List<WebElement> selectedElements = findDropDownElement(dropdown).getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(By dropdown){
        return new Select(driver.findElement(dropdown));
    }
}
