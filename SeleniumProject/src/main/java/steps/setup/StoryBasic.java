package steps.setup;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.utils.PageFactoryUtils;
import utilities.SharedData;

public class StoryBasic extends BaseSteps {

    public StoryBasic(SharedData share) {
        super(share);
    }

    @BeforeStory
    public void setup() {
        share.driver = share.selenium.getCachedWebDriver();
        share.pageFactoryUtils = new PageFactoryUtils(share.driver);
    }

    @AfterStory
    public void teardown() {
        share.selenium.quitDriver();
    }

    @AfterScenario
    public void afterScenario() {
        CartPage cartPage = PageFactory.initElements(share.driver, CartPage.class);
        String cartURL = "https://www.emag.ro/cart/products?ref=cart";
        if (!(share.driver.getCurrentUrl().equals(cartURL))) {
            share.driver.navigate().to(cartURL);
        }
        try {
            cartPage.getContainer();                            //If container is not found it means there are no elements in cart, so we quit the page
            for (WebElement item : cartPage.getItmes()) {       //And if container is found we delete all products with the foreach structure in the left side;
                item.findElement(By.xpath(".//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']")).click();
            }
        } catch (Exception e) {

        }
        cartPage.logOut();
    }

}
