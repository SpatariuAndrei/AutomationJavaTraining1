
import PageClass.*;

import org.junit.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class EmagTest extends Selenium {

    static final Logger LOG = LoggerFactory.getLogger(EmagTest.class);

    private LoginPage login;
    private MainPage mainPage;
    private SearchPage searchPage;
    private CartPage cartPage;

    private Boolean failed;

    private static final String URL = "https://www.emag.ro/homepage?ref=emag_CMP-10858_revolutia-preturilor-iunie-2019";

    private List<Product> productList;

    @Before
    public void setUp() {
        failed = true;

        LOG.trace("productList initialized");
        productList = new LinkedList<Product>();

        LOG.trace("PageObjects initialized");
        mainPage = new MainPage(getDriver(), getWait());
        login = new LoginPage(getDriver(), getWait());
        searchPage = new SearchPage(getDriver(), getWait());
        cartPage = new CartPage(getDriver(), getWait());

        LOG.info("Opening emag.ro");
        getDriver().get(URL); //go to URL

        LOG.info("Log in to account");
        login.logIn(mainPage); //this logs you in
    }

    @After
    public void tearDown(){
        if(failed) {
            LOG.info("Taking screenshot");
            logger = new LogUtil();
            logger.takeScreenshot();
            logger.takeFullScreenshot(getDriver());
        }

        getDriver().get(URL);

        mainPage.goToCart();

        LOG.info("Clearing the cart");
        cartPage.clearCart();

        LOG.info("Logging out");
        login.logOut();
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

        for(Product p : productList){
            LOG.info(p.toString());
            Assert.assertEquals(Float.parseFloat(p.getProductNewPrice()), cartPage.getPrice(p.getProductName()), 0.001);
        }

        failed = false;
    }

    @Test
    public void emag1() {
        productList.clear();

        LOG.info("Searching for a product");
        mainPage.search("camera");

        productList.add(searchPage.addToCartOffer());

        mainPage.search("memorie");

        productList.add(searchPage.addToCartOffer());

        mainPage.goToCart();

        for(Product p : productList){
            LOG.info(p.toString());
            Assert.assertEquals(Float.parseFloat(p.getProductNewPrice()), cartPage.getPrice(p.getProductName()), 0.001);
        }

        failed = false;
    }

    @Test
    public void emag2() {
        productList.clear();

        LOG.info("Searching for a product");
        mainPage.search("laptop");

        productList.add(searchPage.addToCartOffer());

        mainPage.search("casti");

        productList.add(searchPage.addToCartNoOffer());

        mainPage.goToCart();

        for(Product p : productList){
            LOG.info(p.toString());
            Assert.assertEquals(Float.parseFloat(p.getProductNewPrice()), cartPage.getPrice(p.getProductName()), 0.001);
        }

        failed = false;
    }
}
