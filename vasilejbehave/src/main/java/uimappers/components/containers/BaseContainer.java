package uimappers.components.containers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import uimappers.utils.WebDriverUtilities;

import static driverprovider.DriverInstance.getDriver;
import static uimappers.constants.TimeoutConstants.PAGE_LOADING_TIMEOUT;

/**
 * This class uses LoadableComponent for example purposes
 */
public class BaseContainer extends LoadableComponent<BaseContainer> {

    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//div[contains(@class,'main-container')]//div[@class='page-container']")
    protected WebElement bodyContainer;

    BaseContainer(){
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driverUtilities.waitForElementToBeVisible(bodyContainer, PAGE_LOADING_TIMEOUT);
    }


}
