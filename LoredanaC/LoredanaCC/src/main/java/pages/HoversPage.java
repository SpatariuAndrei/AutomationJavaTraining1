package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HoversPage {

    private WebDriver driver;
    private By boxCaption = By.className("figcaption");
    @FindBy(className = "figure")
    private List<WebElement> figure;

    HoversPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FigureCaption hoverOverFigure(int index) {
        WebElement fig = figure.get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(fig).perform();

        return new FigureCaption(fig.findElement(boxCaption));
    }

    public class FigureCaption {

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getTitle() {
            return caption.findElement(header).getText();
        }

        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }
}
