package com.test.jbehave.pages;

import com.test.jbehave.base.Driver;
import com.test.jbehave.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class SearchResult extends Page {

    @FindBy(css = ".title-phrasing.title-phrasing-sm")
    WebElement numberOfResults;

    @FindBy(className = "yeahIWantThisProduct")
    WebElement addToCartButton;

    @FindBy(className ="modal-header" )
    WebElement produsAdaugatCuSuccessMessage;

    public int getNumberOfProducts(){
        return numberOfResults == null ? 0 :  Integer.parseInt(numberOfResults.getText().split(" ")[0]);
    }

    public void addFirstItemToCart() {
        addToCartButton.click();
        waitVisibilityOfWebElement(produsAdaugatCuSuccessMessage,5);
    }

}
