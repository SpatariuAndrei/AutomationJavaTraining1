package tests;

import bdd.setup.StoryMapper;
import steps.AddTwoElementsSteps;
import steps.setup.StoryBasic;
import steps.EmagNormalProductSteps;
import steps.EmagReducedProductSteps;

public class RunSuite extends StoryMapper {

    public RunSuite() {
        addSteps(new StoryBasic(share), new AddTwoElementsSteps(share), new EmagNormalProductSteps(share), new EmagReducedProductSteps(share));
    }

}
