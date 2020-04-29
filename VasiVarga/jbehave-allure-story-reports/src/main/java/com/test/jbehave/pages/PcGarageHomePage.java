package com.test.jbehave.pages;

import com.test.jbehave.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PcGarageHomePage extends BasePageObject {

    @FindBy(linkText = "Contul meu")
    WebElement myAccountLink;

    @FindBy(id = "searchac")
    WebElement searchTextBox;

    @FindBy(id = "cookie_agree")
    WebElement acceptCookies;

    public void open(String url) {
        Driver.driver.get(url);
    }


    public boolean isElementDisplayed(WebElement element){
        try{
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void acceptCookies(){
        if(isElementDisplayed(acceptCookies))
            acceptCookies.click();
    }


    public PcGarageSearchResultsPage searchForProduct(String product){
        type(searchTextBox,product + Keys.ENTER);
        return new PcGarageSearchResultsPage();
    }

    public PcGarageLoginSignUpPage goToMyAccount(){
        myAccountLink.click();
        return new PcGarageLoginSignUpPage();
    }
}
