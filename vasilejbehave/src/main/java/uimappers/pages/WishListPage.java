package uimappers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static driverprovider.DriverInstance.getDriver;

public class WishListPage {

    private static String PRODUCT_NAME_XPATH = "//div[contains(@class,'product-card-account')]//h2//span[text()='%s']";


    public WishListPage() {

    }

    public boolean checkIfProductIsPresent(String productName) {
        String productXpath = String.format(PRODUCT_NAME_XPATH, productName);
        WebElement element = getDriver().findElement(By.xpath(productXpath));

        return element.isDisplayed();
    }
}
