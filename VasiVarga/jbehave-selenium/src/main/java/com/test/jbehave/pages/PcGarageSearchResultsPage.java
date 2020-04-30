package com.test.jbehave.pages;

import com.test.jbehave.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class PcGarageSearchResultsPage extends BasePageObject {

    @FindBy(className = "breadcrumbs")
    WebElement searchResults;

    @FindBy(className = "product-box")
    List<WebElement> productBox;

    @FindBy(className = "pb-compare")
    List<WebElement> compareCheckbox;

    @FindBy(id = "compare_box")
    WebElement compareBox;

    public PcGarageProductPage selectProductByName(String name){
        WebElement element = Driver.driver.findElement(By.linkText(name));
        Actions actions = new Actions(Driver.driver);
        actions.moveToElement(element).perform();
        element.click();
        return new PcGarageProductPage();
    }

    public void addToComparationList(){
        for(WebElement e:productBox){
            e.findElement(By.tagName("input")).click();
        }
    }

    public PcGarageComparationPage clickCompareButton(){

        waitAsecondOrTwoFor(compareBox);

        Actions actions = new Actions(Driver.driver);
        actions.moveToElement(compareBox).perform();
        compareBox.findElement(By.tagName("a")).click();

        return new PcGarageComparationPage();
    }

    public boolean areProductsDisplayed(){
        return searchResults.isDisplayed();
    }

}
