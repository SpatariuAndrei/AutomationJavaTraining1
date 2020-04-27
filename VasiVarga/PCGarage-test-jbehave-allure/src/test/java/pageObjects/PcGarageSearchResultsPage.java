package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.CustomLoadableComponent;
import setup.PageLoadHelper;
import utils.SharedData;
import utils.SharedMethods;

import java.util.List;


public class PcGarageSearchResultsPage extends CustomLoadableComponent<PcGarageSearchResultsPage> {

    SharedData sharedData;
    SharedMethods sharedMethods;

    @FindBy(className = "pb-name")
    List<WebElement> productsByName;

    @FindBy(className = "breadcrumbs")
    WebElement searchResults;

    @FindBy(className = "product-box")
    List<WebElement> productBox;

    @FindBy(className = "pb-compare")
    List<WebElement> compareCheckbox;

    public PcGarageSearchResultsPage(SharedData sharedData){
        this.sharedData=sharedData;
        PageFactory.initElements(sharedData.driver,this);
        acceptCookies();
    }

    public void listProducts(){
        for(WebElement e : productBox){
            System.out.println(e.getText());
        }
    }

//    public void listProducts(){
//        for(WebElement e : productsByName){
//            System.out.println(e.findElement(By.tagName("a")).getText());
//        }
//    }

    public PcGarageProductPage selectProductByName(String name){
        WebElement element = sharedData.driver.findElement(By.linkText(name));
        Actions actions = new Actions(sharedData.driver);
        actions.moveToElement(element).perform();
        element.click();
        return new PcGarageProductPage(sharedData);
    }

    public void addToComparationList(){
        for(WebElement e:productBox){
            e.findElement(By.tagName("input")).click();
        }
        WebElement compareOptions = sharedData.driver.findElement(By.xpath("//*[@id=\"compare_box\"]/ul/li[1]/a[1]"));
        compareOptions.click();
    }

    public boolean areProductsDisplayed(){
        return searchResults.isDisplayed();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().
                isElementIsVisible(By.xpath("//*[@id=\"listing-right\"]/div[3]/div[1]/div/div[3]/div[2]/a")).
                isElementIsClickable(By.xpath("//*[@id=\"listing-right\"]/div[3]/div[1]/div/div[3]/div[2]/a"));
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
