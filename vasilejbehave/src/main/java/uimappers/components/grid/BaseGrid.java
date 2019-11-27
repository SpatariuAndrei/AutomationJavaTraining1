package uimappers.components.grid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import uimappers.utils.WebDriverUtilities;

import static driverprovider.DriverInstance.getDriver;
import static uimappers.constants.TimeoutConstants.DEFAULT_TIMEOUT;

/**
 * This class uses LoadableComponent for example purposes
 */
public class BaseGrid extends LoadableComponent<BaseGrid> {
    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//div[@id='card_grid']")
    protected WebElement gridContainer;

    @FindBy(xpath = "//div[contains(@class,'card-item')]")
    protected WebElement cardItem;


    public BaseGrid(){
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driverUtilities.waitForElementToBeVisible(gridContainer, DEFAULT_TIMEOUT);
    }
}
