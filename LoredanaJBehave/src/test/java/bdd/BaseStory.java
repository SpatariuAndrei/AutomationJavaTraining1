package bdd;

import driverprovider.DriverInstance;
import utils.SharedData;

public class BaseStory extends StoryMapper {
    protected SharedData sharedData = new SharedData();

    public BaseStory() {
        sharedData.driver = DriverInstance.getDriver();
    }
}