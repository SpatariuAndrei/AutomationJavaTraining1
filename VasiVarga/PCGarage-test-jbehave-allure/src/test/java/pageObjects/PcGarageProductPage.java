package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.CustomLoadableComponent;
import setup.PageLoadHelper;
import utils.SharedData;

public class PcGarageProductPage extends CustomLoadableComponent<PcGarageProductPage> {

    SharedData sharedData;

    @FindBy(xpath = "//*[@id=\"ps-shop\"]/div[1]/button")
    WebElement addToCartButton;

    @FindBy(className = "p-name")
    WebElement productName;

    public PcGarageProductPage(SharedData sharedData) {
        this.sharedData=sharedData;
        PageFactory.initElements(sharedData.driver,this);
    }

    public PcGarageCartPage addToChart(){
        addToCartButton.click();
        return new PcGarageCartPage(sharedData);
    }



//    public boolean isCurrentProductPage(String text){
//        return productName.getAttribute("innerText").contains(text);
//    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().
                isElementIsVisible(By.xpath("//*[@id=\"ps-shop\"]/div[1]/button")).
                isElementIsClickable(By.xpath("//*[@id=\"ps-shop\"]/div[1]/button"));
    }

}