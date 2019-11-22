package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.FavoritesPage;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class FavoritePageEndingStory extends StoryBase {

    private DataFromPropertyFile propertyFile;


    public FavoritePageEndingStory(SharedData sharedData) {
        super(sharedData);
        propertyFile = new DataFromPropertyFile();
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
