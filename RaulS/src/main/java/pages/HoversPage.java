package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoversPage {

    private WebDriver driver;
    @FindBy(className = "figure")
    private List<WebElement> figureBox;
    @FindBy(className = "figcaption")
    private WebElement boxCaption;

    protected HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = figureBox.get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement((WebElement) figureBox).perform();

        return new FigureCaption(boxCaption);
    }

    public class FigureCaption {

        private WebElement caption;

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }
    }
}
