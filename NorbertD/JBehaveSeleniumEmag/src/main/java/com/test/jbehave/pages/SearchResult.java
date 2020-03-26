package com.test.jbehave.pages;

import com.test.jbehave.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Thread.sleep;

public class SearchResult extends Page {

    @FindBy(css = ".title-phrasing.title-phrasing-sm")
    private WebElement numberOfResults;

    @FindBy(className = "yeahIWantThisProduct")
    private WebElement addToCartButton;

    @FindBy(className ="modal-header" )
    private WebElement productSuccessfullyAddedMessage;

    public int getNumberOfProducts(){
        return numberOfResults == null ? 0 :  Integer.parseInt(numberOfResults.getText().split(" ")[0]);
    }

    public void addFirstItemToCart() {
        addToCartButton.click();
        waitVisibilityOfWebElement(productSuccessfullyAddedMessage,5);
    }

}
