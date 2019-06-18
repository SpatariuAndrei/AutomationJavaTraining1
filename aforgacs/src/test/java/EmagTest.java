
import PageClass.*;

import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class EmagTest extends Selenium {

    static final Logger LOG = LoggerFactory.getLogger(EmagTest.class);

//    private WebDriver driver;
    private WebDriverWait wait;

    private static LogUtil logger;

    private LoginPage login;
    private MainPage mainPage;
    private SearchPage searchPage;
    private CartPage cartPage;

    private List<Product> productList;

    @BeforeClass
    public static void here(){
        System.out.println("emag beforreClass");
    }

    @Before
    public void setUp() {

        LOG.trace("Wait initialized");
        wait = new WebDriverWait(getDriver(), 15);

        LOG.trace("productList initialized");
        productList = new LinkedList<Product>();

        LOG.trace("PageObjects initialized");
        mainPage = new MainPage(getDriver(), wait);
        login = new LoginPage(getDriver(), wait);
        searchPage = new SearchPage(getDriver(), wait);
        cartPage = new CartPage(getDriver(), wait);

        LOG.info("Opening emag.ro");
        getDriver().get("https://www.emag.ro/homepage?ref=emag_CMP-10858_revolutia-preturilor-iunie-2019"); //go to URL

        LOG.info("Log in to account");
        login.logIn(mainPage); //this logs you in

//        LOG.info("Clearing the cart");
//        mainPage.goToCart();
//        cartPage.clearCart();
//
//        driver.get("https://www.emag.ro");
    }

    @After
    public void tearDown(){
        logger = new LogUtil();
        logger.takeScreenshot();
        getDriver().get("https://www.emag.ro/homepage?ref=emag_CMP-10858_revolutia-preturilor-iunie-2019");

        mainPage.goToCart();

        LOG.info("Clearing the cart");
        cartPage.clearCart();

        LOG.info("Logging out");
        login.logOut();
//
//        LOG.info("Driver quit");
//        driver.quit();
    }

    @Test
    public void emag0() {
        productList.clear();

        LOG.info("Searching for a product");
        mainPage.search("skullcandy");

        productList.add(searchPage.addToCart("Venue"));

        mainPage.search("tv");

        productList.add(searchPage.addToCartNoOffer());

        mainPage.goToCart();

        LOG.info(productList.get(0).toString());
        LOG.info(productList.get(1).toString());

        Assert.assertEquals(Float.parseFloat(productList.get(0).getProductNewPrice()), cartPage.getPrice(0), 0.001);

        Assert.assertEquals(Float.parseFloat(productList.get(1).getProductNewPrice()), cartPage.getPrice(1), 0.001);

    }

    @Test
    public void emag1() {
        productList.clear();

        LOG.info("Searching for a product");
        mainPage.search("camera");

        productList.add(searchPage.addToCartOffer());

        mainPage.search("pc");

        productList.add(searchPage.addToCartOffer());

        mainPage.goToCart();

        LOG.info(productList.get(0).toString());
        LOG.info(productList.get(1).toString());
        System.out.println(cartPage.getPrice(0));
        System.out.println(cartPage.getPrice(1));

        Assert.assertEquals(Float.parseFloat(productList.get(0).getProductNewPrice()), cartPage.getPrice(0), 0.001);

        Assert.assertEquals(Float.parseFloat(productList.get(1).getProductNewPrice()), cartPage.getPrice(1), 0.001);
    }

    @Test
    public void emag2() {
        productList.clear();

        LOG.info("Searching for a product");
        mainPage.search("laptop");

        productList.add(searchPage.addToCartOffer());

        mainPage.search("masina de spalat");

        productList.add(searchPage.addToCartNoOffer());

        mainPage.goToCart();

        LOG.info(productList.get(0).toString());
        LOG.info(productList.get(1).toString());

        Assert.assertEquals(Float.parseFloat(productList.get(0).getProductNewPrice()), cartPage.getPrice(0), 0.001);

        Assert.assertEquals(Float.parseFloat(productList.get(1).getProductNewPrice()), cartPage.getPrice(1), 0.001);
    }
}
