//assert that after the purchase and clicking the cart button, the cart page is displayed
package emag_test;
//Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/*
de adaugat in cos un produs (metode getNume, getPret, getPretRedus) TELEVIZOR
comparat pret pagina principala, pret pagina produs, pret cos sa fie identice

extra: comparat preturile de la reduceri (cmplicat) (din xpaths la price(int,decimal,currency))

mai adaugam un produs (metode getNume, getPret, getPretRedus) SISTEM AUDIO
verificam preturile
caldulam subtotalul si vedem daca e corect (metoda getPretTotal)

!!! in console la chrome: xpath: $x('//*[@class="line-item-title main-product-title"]')
                                $x('//*[@class="line-item-title main-product-title" and contains(text(),"audio")]/ancestor::div[@class="line-item main-product"]')
 */




/*

3 teste

1: adauga produs fara reducere in cos si compara preturile si titlurile
2: adauga produs cu reducere in cos si compara preturile si titlurile
3: adauga 2 prod (1 redus, 1 simplu) si compara suma in cos

metoda de stergere a tuturor produselor din cos

SCOP: curatarea si gruparea codului pt citire mai buna
!!!: in clasa buy_fifa.java sa ramana doar numele metodelor din celelalte pageObjects
            scop: readability & encapsulation
*/


/*

la testul cu discount sa verific daca produsul are discount
assert uri pe obiecte de tip Product

mai grupat, facute metode pentru toate actiunile in clasele de webPages pt a ramane cat mai putin si usor de inteles cod in teste

logback
screenshots
 */

public class buy_fifa {

    private static final Logger logger = LoggerFactory.getLogger(buy_fifa.class);

    private WebDriver driver;

    private Map<String, Object> vars;
    JavascriptExecutor js;

    Home homePage;
    Product productPage;
    Cart cartPage;
    Login loginPage;
    Favorites favoritesPage;
    WebDriverWait wait1;


    /*
    @BeforeClass
    @AfterClass
    pt a rula ceva inainte de a se crea clasa (ex: conex BD)
     */

    @Before
    public void setUp() throws InterruptedException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("unexpectedAlertBehaviour", "ignore");


        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        loginPage = new Login(driver);
        homePage = new Home(driver);
        productPage = new Product(driver);
        cartPage = new Cart(driver);
        favoritesPage = new Favorites(driver);
        wait1 = new WebDriverWait(driver, 10);


        driver.get("https://www.emag.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.findElement(By.id("my_account")).click();

        loginPage.LoginUser("aledobrean@gmail.com", "Mustar20");

    }

    @After
    public void tearDown() throws IOException {
/*
        File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("C:\\webdrivers\\screen1"));*/
        if (loginPage.isLoggedIn()) {

            driver.get("https://www.emag.ro/cart/products?ref=cart");
            int index = cartPage.productList.size() - 1;
            while (index >= 0) {
                cartPage.deleteAProduct(index);
                index--;
            }
        }
        driver.quit();
    }


    @Test
    public void twoProductsTest() throws NoSuchElementException, WebDriverException, InterruptedException {

        ProductInfo firstProduct=new ProductInfo();
        firstProduct.setTitle(homePage.getFirstProductName());
        firstProduct.setPrice(homePage.getNewPriceFinal("Huawei P20"));
        firstProduct.setOldPrice(homePage.getOldPriceFinal("Huawei P20"));

        homePage.firstProductClick();

        productPage.addToCart();

        productPage.closePurchaseWindow();

        homePage.cartClick();

        ProductInfo cartProduct=new ProductInfo();
        cartProduct.setTitle(cartPage.getProductName(0));
        cartProduct.setPrice(cartPage.getFinalNewPriceString("Huawei P20"));
        cartProduct.setOldPrice(cartPage.getFinalOldPriceString("Huawei P20"));

        String sumaProducts = cartPage.getCartSum();

        float sumaTotCalculata = cartPage.getSumOfPrices();
        String suma = Float.toString(sumaTotCalculata);

        logger.info("Compare home page details with cart details");
        assertThat(suma, is(sumaProducts));
        //assertThat(firstProduct, is(cartProduct));
    }

    @Test
    public void oneProductDiscountTest() throws InterruptedException {

        String priceHome = homePage.getNewPriceFinal("Huawei P20");
        String priceOldHome = homePage.getOldPriceFinal("Huawei P20");
        String productNameHomePage = homePage.getFirstProductName();

        homePage.firstPhoneDetails.click();

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.elementToBeClickable(productPage.addToCart));

        productPage.addToCart.click();

        wait1.until(ExpectedConditions.visibilityOf(productPage.closePurchaseWindow));

        //close window
        productPage.closePurchaseWindow.click();

        //go to cart
        //Thread.sleep(500);
        wait1.until(ExpectedConditions.visibilityOf(homePage.cartInfo));
        wait1.until(ExpectedConditions.elementToBeClickable(homePage.cartInfo));
        homePage.cartInfo.click();

        String priceCartPage = cartPage.getFinalNewPriceString("Huawei P20");
        String priceOldCartPage = cartPage.getFinalOldPriceString("Huawei P20");
        String productNameCartPage = cartPage.getProductName(0);

        assertThat(priceCartPage, is(priceHome));
        assertThat(priceOldCartPage, is(priceOldHome));
        assertThat(productNameCartPage, is(productNameHomePage));

    }

    @Test
    public void productWithoutDiscountTest() throws InterruptedException {

        //Thread.sleep(500);

        favoritesPage.clickFavs();
        favoritesPage.clickFavsCategories();

        String favTitle = favoritesPage.getTitle(0);
        String favPrice = favoritesPage.getPrice(0);

        favoritesPage.buyItem(0);
        favoritesPage.clickCart();

        String cartPrice = cartPage.getFinalNewPriceString("Assassin");
        String cartTitle = cartPage.getProductName(0);

        assertThat(favPrice, is(cartPrice));
        assertThat(favTitle, is(cartTitle));
    }
}
