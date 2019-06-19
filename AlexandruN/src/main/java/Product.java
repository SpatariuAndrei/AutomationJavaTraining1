import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Product {

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String s){
        this.oldPrice=s;
    }
    public void setOldPrice(WebElement e) {

        String bigPrice=e.findElement(By.xpath(".//p[@class='product-old-price']/s")).getText().substring(0,5);
        String smallPrice = e.findElement(By.xpath(".//p/s/sup")).getText();
        this.oldPrice = ""+bigPrice+","+smallPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(WebElement e) {
        String bigPrice=e.findElement(By.xpath(".//p[@class='product-new-price']")).getText().substring(0,5);
        String smallPrice=e.findElement(By.xpath(".//p[@class='product-new-price']/sup")).getText();

        this.newPrice =""+bigPrice+","+smallPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String oldPrice;
    private String newPrice;
    private  String title;


    public void setCartOldPrice(WebElement e) {

        String bigPrice = e.findElement(By.xpath(".//span[@class='money-int']")).getText();
        String smallPrice = e.findElement(By.xpath(".//sup[@class='money-decimal']")).getText();
        this.oldPrice = ""+bigPrice+","+smallPrice;
    }



    public void setCartNewPrice(WebElement e) {
        String bigPrice=e.findElement(By.xpath(".//span[@class='money-int']")).getText();
        String smallPrice=e.findElement(By.xpath(".//sup[@class='money-decimal']")).getText();

        this.newPrice =""+bigPrice+","+smallPrice;
    }


}
