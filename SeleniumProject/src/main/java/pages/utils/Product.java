package pages.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {

    public void setOldPrice(WebElement e) {

        String bigPrice=e.findElement(By.xpath(".//p[@class='product-old-price']/s")).getText().substring(0,5);
        String smallPrice = e.findElement(By.xpath(".//p/s/sup")).getText();
        this.stringOldPrice = ""+bigPrice+","+smallPrice;
    }

    public String getNewPrice() {
        return stringNewPrice;
    }

    public void setNewPrice(WebElement e) {
        String bigPrice=e.findElement(By.xpath(".//p[@class='product-new-price']")).getText().substring(0,5);
        String smallPrice=e.findElement(By.xpath(".//p[@class='product-new-price']/sup")).getText();

        this.stringNewPrice =""+bigPrice+","+smallPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String stringOldPrice;
    private String stringNewPrice;
    private  String title;


    public void setCartOldPrice(WebElement e) {

        String bigPrice = e.findElement(By.xpath(".//span[@class='money-int']")).getText();
        String smallPrice = e.findElement(By.xpath(".//sup[@class='money-decimal']")).getText();
        this.stringOldPrice = ""+bigPrice+","+smallPrice;
    }



    public void setCartNewPrice(WebElement e) {
        String bigPrice=e.findElement(By.xpath(".//span[@class='money-int']")).getText();
        String smallPrice=e.findElement(By.xpath(".//sup[@class='money-decimal']")).getText();

        this.stringNewPrice =""+bigPrice+","+smallPrice;
    }
    public float floatNewPrice() {
        String finalPrice="";
        String[] tokens=this.stringNewPrice.split(",");
        String[] tokensInt=tokens[0].split("\\.");
        for(String s:tokensInt){
            finalPrice=finalPrice+s;
        }
        finalPrice=finalPrice+"."+tokens[1];
        float a=Float.parseFloat(finalPrice);
        return a;
    }
    public float floatOldPrice(){

        String finalPrice="";
        String[] tokens=this.stringOldPrice.split(",");
        String[] tokensInt=tokens[0].split("\\.");
        for(String s:tokensInt){
            finalPrice=finalPrice+s;
        }
        finalPrice=finalPrice+"."+tokens[1];
        float a=Float.parseFloat(finalPrice);
        return a;
    }    public String getStringOldPrice() {
        return stringOldPrice;
    }

    public void setStringOldPrice(String s){
        this.stringOldPrice =s;
    }




}
