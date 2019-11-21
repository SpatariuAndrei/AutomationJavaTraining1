package bdd;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.*;
import properties.PropertiesConfig;
import uimappers.pages.EmagHomePage;
import utilities.SharedData;

import static properties.PropertiesKeys.HOME_ADDRESS;

public class BaseStory extends StoryMapper {
    protected SharedData share = new SharedData();

    public BaseStory(){
        share.driver = DriverInstance.getDriver();
        share.driver.get(PropertiesConfig.getProperty(HOME_ADDRESS));
        share.homePage = new EmagHomePage(share);
    }
}