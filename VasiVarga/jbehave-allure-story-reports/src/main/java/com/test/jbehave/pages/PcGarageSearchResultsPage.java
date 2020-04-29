package com.test.jbehave.pages;

import com.test.jbehave.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class PcGarageSearchResultsPage extends BasePageObject {

    @FindBy(className = "pb-name")
    List<WebElement> productsByName;

    @FindBy(id = "searchac")
    WebElement searchTextBox;

    @FindBy(id = "cookie_agree")
    WebElement acceptCookies;

    @FindBy(className = "breadcrumbs")
    WebElement searchResults;

    @FindBy(className = "product-box")
    List<WebElement> productBox;

    @FindBy(className = "pb-compare")
    List<WebElement> compareCheckbox;

//    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/ul/li[1]/a[1]")
//    WebElement compareBtn;

//    public PcGarageSearchResultsPage(){
//        PageFactory.initElements(Driver.driver,this);
//        acceptCookies();
//    }

    public void listProducts(){
        for(WebElement e : productBox){
            System.out.println(e.getText());
        }
    }

    public PcGarageProductPage selectProductByName(String name){
        acceptCookies();
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

        WebElement compareBtn = Driver.driver.findElement(By.xpath("//*[@id=\"compare_box\"]/ul/li[1]/a[1]"));
        compareBtn.click();
//        WebElement compareBtn = Driver.driver.findElement(By.linkText("Compara acum"));
//        compareBtn.click();

//        WebElement compareOptions = Driver.driver.findElement(By.xpath("//*[@id=\"compare_box\"]/ul/li[1]/a[1]"));
//        By compareBtn = By.xpath("//*[@id=\"compare_box\"]/ul/li[1]/a[1]");
//        waitExplicitlyWebElement(compareOptions,1);
//        compareOptions.click();
//        if (isElementPresent(compareBtn))
//            Driver.driver.findElement(compareBtn).click();
       // compareOptions.click();
    }

    public boolean areProductsDisplayed(){
        return searchResults.isDisplayed();
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
}
