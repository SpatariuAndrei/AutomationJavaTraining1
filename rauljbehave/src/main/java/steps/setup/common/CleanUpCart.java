//package steps.setup.common;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import pages.CartPage;
//import utilities.DataFromPropertyFile;
//import utilities.SharedData;
//
//public class CleanUpCart {
//
//    public static void clean(SharedData sharedData, DataFromPropertyFile propertyFile ){
//        CartPage cartPage = PageFactory.initElements(sharedData.driver, CartPage.class);
//        if (!(sharedData.driver.getCurrentUrl().equals(propertyFile.getEmagCartPage()))) {
//            sharedData.driver.navigate().to(propertyFile.getEmagCartPage());
//        }
//
//        try {
//            cartPage.getContainer();
//            for (WebElement item : cartPage.getItems()) {
//                item.findElement(By.xpath("//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']")).click();
//            }
//        } catch (Exception e) {
//
//        }
//        cartPage.logOut();
//    }
//}
