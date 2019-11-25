package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class AddProductToCartEndingStory extends StoryBase {

    private DataFromPropertyFile propertyFile;

    public AddProductToCartEndingStory(SharedData sharedData) {
        super(sharedData);
        propertyFile = new DataFromPropertyFile();
    }

    @AfterScenario
    public void afterScenario() {
        CartPage cartPage = PageFactory.initElements(sharedData.driver, CartPage.class);
        if (!(sharedData.driver.getCurrentUrl().equals(propertyFile.getEmagCartPage()))) {
            sharedData.driver.navigate().to(propertyFile.getEmagCartPage());
        }

        try {
            cartPage.getContainer();
            for (WebElement item : cartPage.getItems()) {
                item.findElement(By.xpath("//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']")).click();
            }
        } catch (Exception e) {

        }
        cartPage.logOut();
    }
}
