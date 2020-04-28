package tests;

import net.serenitybdd.jbehave.SerenityStory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import utils.DriverInstance;
import utils.SharedData;

public class BaseStory extends SerenityStory {

    protected SharedData sharedData = new SharedData();

    public BaseStory(){
        sharedData.driver = DriverInstance.getDriver();
    }


    @Override
    public Configuration configuration() {
        if (super.hasConfiguration()) {
            return super.configuration();
        }
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats().withFormats(Format.CONSOLE)
                );
    }
}
