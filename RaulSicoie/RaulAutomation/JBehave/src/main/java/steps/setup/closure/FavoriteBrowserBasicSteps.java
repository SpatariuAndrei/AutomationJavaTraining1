package steps.setup.closure;

import org.jbehave.core.annotations.AfterStory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.FavoritesPage;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class FavoriteBrowserBasicSteps extends StoryBase {

    private DataFromPropertyFile propertyFile;
    private SharedData sharedData;

    public FavoriteBrowserBasicSteps(SharedData sharedData) {
        super(sharedData);
        this.sharedData = sharedData;
        propertyFile = new DataFromPropertyFile();
    }

    @AfterStory
    public void afterStory() {
        FavoritesPage favoritesPage = PageFactory.initElements(sharedData.driver, FavoritesPage.class);
        if (!(sharedData.driver.getCurrentUrl().equals(propertyFile.getEmagFavoritesPage()))) {
            sharedData.driver.navigate().to(propertyFile.getEmagFavoritesPage());
        }

        try {
            for (WebElement item : favoritesPage.getItems()) {
                item.findElement(By.cssSelector("button.remove-from-favorites")).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        favoritesPage.logOut();
    }

}
