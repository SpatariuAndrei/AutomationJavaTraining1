package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {

    private WebDriver driver;
    @FindBy(id = "hot-spot")
    private WebElement box;

    ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void rightClickInBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    public String getPopUpText() {
        return driver.switchTo().alert().getText();
    }

    public void acceptPopUp() {
        driver.switchTo().alert().accept();
    }
}
