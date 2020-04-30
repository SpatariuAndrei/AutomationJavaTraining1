package com.test.jbehave.pages;

import com.test.jbehave.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PcGarageCartPage extends BasePageObject {

    @FindBy(className = "cpm-products-container")
    List<WebElement> cartProductsList;

    public boolean isProductInCart(String pName){
        String cartProducts = Driver.driver.findElement(By.className("cpm-products-container")).getAttribute("innerHTML");
            if(cartProducts.contains(pName)) {
                return true;
            }
        return false;
    }

}
