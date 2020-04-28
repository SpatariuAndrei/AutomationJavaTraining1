package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.CustomLoadableComponent;
import setup.PageLoadHelper;
import utils.SharedData;
import utils.SharedMethods;

public class PcGarageHomePage extends CustomLoadableComponent<PcGarageHomePage> {

    SharedData sharedData;
    SharedMethods sharedMethods;


    public PcGarageHomePage (SharedData sharedData) {
        sharedData.driver.get("https://pcgarage.ro");
        this.sharedData=sharedData;
        PageFactory.initElements(sharedData.driver,this);
        sharedData.driver.manage().window().maximize();
        sharedMethods = new SharedMethods(sharedData);
        acceptCookies();
    }



    @Override
    protected void load() {
        this.sharedData.driver.get("https://pcgarage.ro");
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

    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().
                isElementIsVisible(By.linkText("Contul meu")).
                isElementIsClickable(By.linkText("Contul meu"));
    }

    public PcGarageSearchResultsPage searchForProduct(String product){
        sharedMethods.type(searchTextBox,product + Keys.ENTER);
        return new PcGarageSearchResultsPage(sharedData);
    }

    public PcGarageLoginSignUpPage goToMyAccount(){
        myAccountLink.click();
        return new PcGarageLoginSignUpPage(sharedData);
    }


}
