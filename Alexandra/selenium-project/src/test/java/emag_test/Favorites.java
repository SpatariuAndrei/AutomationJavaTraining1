package emag_test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Favorites {

    WebDriver driver;

    @FindBy (xpath = "//*[@id='my_wishlist']/span[2]")
    WebElement favs;

    @FindBy (xpath = "//a[@class='row-wishlist-name']")
    WebElement favsButton;

    @FindBy(xpath = "//table[@class='wishlist-box']")
    WebElement favContainer;

    @FindBy(xpath = "//a[@class='emg-fluid-user-section emg-fluid-cart-btn emg-fluid-last']")
    WebElement cartInfo;


    public Favorites(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    private static String changePrice(String str){
        String strin = str.replaceAll("\\.", "");
        return strin;
    }

    public void clickFavs(){
        favs.click();
    }

    public void clickFavsCategories(){
        favsButton.click();
    }

    public void clickCart(){
        cartInfo.click();
    }

    public String getTitle(int id){
        return favContainer.findElement(By.xpath(".//div[@class='product-title']/h2/a")).getText();
    }

    public String getPrice(int id){
        String price = favContainer.findElement(By.xpath(".//span[@class='money-int']")).getText();
        price=changePrice(price);
        price=price.concat(".");
        price=price.concat(favContainer.findElement(By.xpath(".//sup[@class='money-decimal']")).getText());
        return price;
    }

    public void buyItem(int id){
        try{
            favContainer.findElement(By.xpath(".//button[@class='pho-btn btn btn-primary btn-emag gtm_c6829q']")).click();
        }
        catch(Exception e){
            System.out.printf("Index out of bounds error");
        }
    }


}
