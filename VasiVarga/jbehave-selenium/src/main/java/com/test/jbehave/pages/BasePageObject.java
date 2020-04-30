package com.test.jbehave.pages;

import com.test.jbehave.utils.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePageObject {

    @FindBy(linkText = "Contul meu")
    WebElement myAccountLink;

    @FindBy(id = "searchac")
    WebElement searchTextBox;

    @FindBy(id = "cookie_agree")
    WebElement acceptCookies;

    public BasePageObject() {
        PageFactory.initElements(Driver.driver, this);

    }

    public PcGarageLoginSignUpPage goToMyAccount(){
        myAccountLink.click();
        return new PcGarageLoginSignUpPage();
    }

    public PcGarageSearchResultsPage searchForProduct(String product){
        type(searchTextBox,product + Keys.ENTER);
        return new PcGarageSearchResultsPage();
    }

    protected void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }


    public void acceptTheCookies() {
            waitAsecondOrTwoFor(acceptCookies);
            Actions actions = new Actions(Driver.driver);
            actions.moveToElement(acceptCookies).perform();
            acceptCookies.click();
    }

    protected void waitAsecondOrTwoFor(WebElement webElement) {
        try {
            new WebDriverWait(Driver.driver, 2).until(ExpectedConditions.visibilityOf(webElement));
        } catch (WebDriverException e) {
            System.out.println("/// ---- NotFound ---- ///");
        }
    }
}
