package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By signUpEmailField = By.id("email");
    private By submitButton = By.cssSelector("#enterimg");
    private By signInButton = By.id("btn1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage clickSignUp(String email){
        driver.findElement(signUpEmailField).sendKeys(email);
        driver.findElement(submitButton).click();
        return new RegistrationPage(driver);
    }

    public void hoverSwitchTo(){
        driver.findElement(signUpEmailField).sendKeys("Whatever@whatever.com");
        driver.findElement(submitButton).click();
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.hover(navigationBar.getNavBar_SwitchTo());
    }

    public WindowPage clickWindowsPage(){
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.hoverAndClickWidowPage(navigationBar.getNavBar_SwitchTo_Windows(),navigationBar.getNavBar_SwitchTo_Windows());
        return new WindowPage(driver);
    }

    public LogInPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new LogInPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }








}
