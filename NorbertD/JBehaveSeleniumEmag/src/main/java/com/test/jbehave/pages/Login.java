package com.test.jbehave.pages;

import com.test.jbehave.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Page {

    @FindBy ( id = "email")
    private WebElement emailField;

    @FindBy ( id = "password")
    private WebElement passwordField;

    @FindBy (className = "auth-btn-primary")
    private WebElement continueButton;

    public void enterEmail(String email){
        type(emailField,email);
    }

    public void enterPassword(String password){
        waitVisibilityOfWebElement(passwordField,5);
        type(passwordField,password);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

}
