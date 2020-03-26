package com.test.jbehave.pages;

import com.test.jbehave.base.Driver;
import com.test.jbehave.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Cart  extends Page {

    private String CART_URL = "https://www.emag.ro/cart/products?ref=cart";

    @FindBy(css = ".line-item.main-product")
    private List<WebElement> products;

    @FindBy( className = "btn-remove-product")
    private WebElement deleteButton;

    @FindBy ( className = "title")
    private WebElement theCartIsEmptyTextMessage;

    public void go() {
        Driver.driver.get(CART_URL);
    }

    public int getNrOfItemsInCart(){
        return products == null ? 0 : products.size();
    }

    public void deleteFirstItemInCart(){
        deleteButton.click();
        waitVisibilityOfWebElement(theCartIsEmptyTextMessage,5);
    }
}
