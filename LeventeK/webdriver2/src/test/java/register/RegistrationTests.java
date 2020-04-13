package register;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavigationBar;
import pages.RegistrationPage;
import pages.WebTablePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


import static org.testng.Assert.assertTrue;

public class RegistrationTests extends BaseTest {


    @Test
    public void testSuccessfulRegistration(){
        WebDriverWait explicitWait=new WebDriverWait(driver, 10);
        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        String email = "123whal@email.com";
        RegistrationPage registrationPage = homePage.clickSignUp(email);
        String ExpectedRegisterTitle = "Register";
        String ActualRegisterTitle = driver.getTitle();
        Assert.assertEquals(ExpectedRegisterTitle, ActualRegisterTitle);
        registrationPage.setFirstName("oalsd");
        registrationPage.setLastName("rrdsasarr");
        registrationPage.setAddress("Main street, nr25, Bigtown, Germany, 20041");
        registrationPage.setEmail(email);
        registrationPage.setPhoneNumber("0711424131");
        registrationPage.setGenderMale();
        registrationPage.setMoviesHobby();
        registrationPage.setHockeyHobby();
        registrationPage.selectFromSkillsDropDown("Java");
        registrationPage.selectFromCountryDropdown("Romania");
        registrationPage.selectFromYearDropdown("1989");
        registrationPage.selectFromMothDropdown("November");
        registrationPage.selectFromDayDropdown("22");
        registrationPage.setPassword("Test24");
        registrationPage.setConfirmPassword("Test24");
        WebTablePage webTablePage = registrationPage.clickSubmitButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section/div[1]/div/div[2]/h4[1]/b")));
//        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section/div[1]/div/div[2]/h4[1]/b")));
        webTablePage.getHeaderText().contains("Automation ");
        Assert.assertEquals(webTablePage.getCurrentURL(), "http://demo.automationtesting.in/WebTable.html" );
        Assert.assertEquals(driver.getTitle(), "Web Table");


    }


}
