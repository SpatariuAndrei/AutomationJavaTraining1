package com.test.jbehave.pages;

import com.test.jbehave.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register extends Page {

    @FindBy(id = "r_name")
    private WebElement nameField;

    @FindBy (id = "r_password")
    private WebElement passwordField;

    @FindBy (id = "r_password_confirmation")
    private WebElement passwordConfirmationField;

    @FindBy (id = "agree_terms")
    private WebElement agreeTermsCheckBox;

    @FindBy (className = "auth-btn-primary")
    private WebElement continueButton;

    public void enterName(String name){
        type(nameField,name);
    }

    public void enterPassword(String pass){
        type(passwordField,pass);
    }

    public void enterPasswordConfirmation(String pass){
        type(passwordConfirmationField,pass);
    }

    public void checkAgreeTerms(){
        javaScriptClick(agreeTermsCheckBox);
    }

    public void clickContinueButton(){
        continueButton.click();

    }


}
