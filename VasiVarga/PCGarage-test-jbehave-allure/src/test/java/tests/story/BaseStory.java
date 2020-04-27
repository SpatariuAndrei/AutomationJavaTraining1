package tests.story;

import net.serenitybdd.jbehave.SerenityStory;
import org.jbehave.core.embedder.Embedder;
import utils.DriverInstance;
import utils.SharedData;

public class BaseStory extends SerenityStory {

    protected SharedData sharedData = new SharedData();

    public BaseStory(){
        sharedData.driver = DriverInstance.getDriver();
    }

    @Override
    public Embedder configuredEmbedder() {
        Embedder embedder = super.configuredEmbedder();
        embedder.embedderControls().doGenerateViewAfterStories(false);
        return embedder;
    }

}
