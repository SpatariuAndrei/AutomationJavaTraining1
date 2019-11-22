package steps.setup;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.FavoritesPage;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class StoryBase extends BaseSteps {

    private DataFromPropertyFile propertyFile;

    public StoryBase(SharedData sharedData) {
        super(sharedData);
        propertyFile = new DataFromPropertyFile();
    }

    @BeforeStory
    public void setup() {
        sharedData.driver = new Browser().driverInitialization();
    }

    //@AfterStory
    public void teardown() {
        sharedData.driver.quit();
    }

    @AfterScenario
    public void afterScenario() {
        FavoritesPage favoritesPage = PageFactory.initElements(sharedData.driver, FavoritesPage.class);
        if (!(sharedData.driver.getCurrentUrl().equals(propertyFile.getEmagFavoritesPage()))) {
            sharedData.driver.navigate().to(propertyFile.getEmagFavoritesPage());
        }

        try {
            favoritesPage.getContainer();
            for (WebElement item : favoritesPage.getItems()) {
                item.findElement(By.cssSelector("button.remove-from-favorites")).click();
            }
        } catch (Exception e) {

        }
        favoritesPage.logOut();
    }
}
