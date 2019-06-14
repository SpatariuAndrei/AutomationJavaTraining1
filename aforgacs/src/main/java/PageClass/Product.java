package PageClass;

public class Product {
    private String productName;
    private String productOldPrice;
    private String productNewPrice;
    private Boolean specialOffer;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String  getProductOldPrice() {
        return productOldPrice;
    }

    public void setProductOldPrice(String productOldPrice) {
        this.productOldPrice = productOldPrice;
    }

    public String getProductNewPrice() {
        return productNewPrice;
    }

    public void setProductNewPrice(String  productNewPrice) {
        this.productNewPrice = productNewPrice;
    }

    public Boolean isSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(Boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public Product(){
        productOldPrice = "";
        productNewPrice = "";
        productName ="";
        specialOffer = false;
    }

    @Override
    public String toString(){
        if(specialOffer)
            return productName + ": old price = " + productOldPrice + ", new price: = " + productNewPrice;

        return productName + ": price: = " + productNewPrice;

    }
}
