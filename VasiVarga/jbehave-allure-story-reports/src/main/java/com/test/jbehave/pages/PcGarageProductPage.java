package com.test.jbehave.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PcGarageProductPage extends BasePageObject {

    @FindBy(xpath = "//*[@id=\"ps-shop\"]/div[1]/button")
    WebElement addToCartButton;

    @FindBy(className = "p-name")
    WebElement productName;

    public PcGarageCartPage addToChart(){
        addToCartButton.click();
        return new PcGarageCartPage();
    }
}