package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.PageLoadHelper;
import utils.SharedData;

import java.util.List;

public class PcGarageCartPage extends LoadableComponent<PcGarageCartPage> {

    SharedData sharedData;

    @FindBy(className = "cpm-products-container")
    List<WebElement> cartProductsList;

    public PcGarageCartPage(SharedData sharedData) {
        this.sharedData=sharedData;
        PageFactory.initElements(sharedData.driver,this);
    }

    public boolean isProductInCart(String pName){
        String cartProducts = sharedData.driver.findElement(By.className("cpm-products-container")).getAttribute("innerHTML");
            if(cartProducts.contains(pName)) {
                return true;
            }
        return false;
    }

    @Override
    protected void load() {
        PageLoadHelper.isLoaded().
                isElementIsVisible(By.className("ce-show clearfix")).
                isElementIsClickable(By.className("ce-show clearfix"));
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
