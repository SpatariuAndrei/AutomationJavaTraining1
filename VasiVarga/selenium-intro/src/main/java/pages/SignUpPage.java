package pages;

import navBar.DropdownMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage {

    private WebDriver driver;

    private By firstNameField = By.cssSelector("[ng-model='FirstName']");
    private By lastNameField = By.cssSelector("[ng-model='LastName']");
    private By addressField = By.cssSelector("[ng-model='Adress']");
    private By emailField = By.cssSelector("[ng-model='EmailAdress']");
    private By phoneField = By.cssSelector("[ng-model='Phone']");
    private By maleRadioBtn = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input");
    private By femaleRadioBtn = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input");

    private By[] hobbiesCheckBox = new By[]{By.id("checkbox1"),By.id("checkbox2"),By.id("checkbox3")};

    private By languageDropDown = By.id("msdd");

    private By skillsDropDown = By.id("Skills");
    private By countryDropDown = By.id("countries");
    private By selectCountryComboBox = By.cssSelector("#basicBootstrapForm > div:nth-child(10) > div > span > span.selection > span");
    private By dobYearDropDown = By.cssSelector("[ng-model='yearbox']");
    private By dobMonthDropDown = By.cssSelector("[ng-model='monthbox']");
    private By dobDayDropDown = By.cssSelector("[ng-model='daybox']");
    private By passwordField = By.cssSelector("[ng-model='Password']");
    private By confirmPasswordField = By.cssSelector("[ng-model='CPassword']");
    private By submitButton = By.id("submitbtn");

    private By dropdowns = By.className("dropdown");
    private By dropdownItems= By.className("dropdown-menu");

    public SignUpPage(WebDriver driver){
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

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPhone(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickMaleRadioBtn(){
        driver.findElement(maleRadioBtn).click();
    }

    public void clickFemaleRadioBtn(){
        driver.findElement(femaleRadioBtn).click();
    }

    public void selectCheckBox(String value){
        for(int i=0 ; i<hobbiesCheckBox.length ; i++){
            WebElement elem = (driver.findElement(hobbiesCheckBox[i]));
            System.out.println(elem.getText());
            if(elem.getAttribute("value").contains(value))
                driver.findElement(hobbiesCheckBox[i]).click();
        }
    }

    public void selectFromLanguageDropdown(String option){
        driver.findElement(languageDropDown).click();

        WebElement listOptions = driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul"));
        List<WebElement> options = listOptions.findElements(By.tagName("li"));
        for (int i = 0; i < options.size(); i++)
            if(options.get(i).getText().equals(option))
                options.get(i).click();

    }

    private Select findDropdownElement(By element){
        return new Select(driver.findElement(element));
    }

    public void selectFromSkillsDropdown(String option){
        findDropdownElement(skillsDropDown).selectByVisibleText(option);
    }

    public void selectFromFirstCountryDropdown(String option){
        findDropdownElement(countryDropDown).selectByVisibleText(option);
    }

    public void selectFromSecondCountryDropdown(String option){
        driver.findElement(selectCountryComboBox).click();
        driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys(option);
        driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys(Keys.ENTER);
    }

    public void selectDobYearDropdown(String option){
        findDropdownElement(dobYearDropDown).selectByVisibleText(option);
    }

    public void selectDobMonthDropdown(String option){
        findDropdownElement(dobMonthDropDown).selectByVisibleText(option);
    }

    public void selectDobDayDropdown(String option){
        findDropdownElement(dobDayDropDown).selectByVisibleText(option);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword){
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public WebTablePage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new WebTablePage(driver);
    }


    public DropdownMenu hoverOverMenuItem(String menuToHoverOn){

        List<WebElement> dropDownMenuLists = driver.findElements(dropdowns);

        WebElement elementToHoverOn=null;

        for(WebElement e: dropDownMenuLists)

            if (e.getText().equals(menuToHoverOn))
            {
                Actions actions = new Actions(driver);
                actions.moveToElement(e).perform();
                elementToHoverOn=e;
                break;
            }

        return new DropdownMenu(elementToHoverOn.findElement(dropdownItems));
    }



}
