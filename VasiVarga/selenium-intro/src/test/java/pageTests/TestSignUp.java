package pageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.SignUpPage;
import pages.WebTablePage;
import setUpTest.SetUp;

public class TestSignUp extends SetUp {

    private WebDriver driver;

    @Test
    public void runTest() {

        SignUpPage signUp = homePage.clickSkipButton();

        signUp.setFirstName("Vasi");
        signUp.setLastName("Varga");
        signUp.setAddress("Buftea 12");
        signUp.setEmail("vasi.vrg@testmail.com");
        signUp.setPhone("0722222222");
        signUp.clickMaleRadioBtn();
        signUp.selectCheckBox("Movies");
        signUp.selectFromLanguageDropdown("Romanian");
        signUp.selectFromLanguageDropdown("English");
        signUp.selectFromSkillsDropdown("Software");
        signUp.selectFromFirstCountryDropdown("Romania");
        signUp.selectFromSecondCountryDropdown("Denmark");
        signUp.selectDobYearDropdown("1995");
        signUp.selectDobMonthDropdown("February");
        signUp.selectDobDayDropdown("2");
        signUp.setPassword("Password1");
        signUp.setConfirmPassword("Password1");

        WebTablePage webTablePage = signUp.clickSubmitButton();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > section > div:nth-child(1) > div > div:nth-child(2) > h4:nth-child(1)"))));
        String ExpectedURL = "http://demo.automationtesting.in/WebTable.html";
        String CurrentUrl = driver.getCurrentUrl();

        try {
            Assert.assertEquals(ExpectedURL,CurrentUrl);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

    }





    public static void main(String[] args) throws InterruptedException {
        TestSignUp testSignUp = new TestSignUp();
        testSignUp.runTest();
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }


}
