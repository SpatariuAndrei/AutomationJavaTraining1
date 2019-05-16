package Tests;

import Help.ShareData;
import Steps.AccountSteps;
import Steps.BrowserBasics;
import Steps.HomeSteps;
import Steps.LoginSteps;
import Steps.RegistrationSteps;
import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;
import org.junit.runner.RunWith;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnitReportingRunner.class)
public class RegistrationTest extends JUnitStories {

    ShareData share = new ShareData();

    public RegistrationTest() throws Exception {
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new BrowserBasics(share));
        stepFileList.add(new HomeSteps(share));
        stepFileList.add(new LoginSteps(share));
        stepFileList.add(new RegistrationSteps(share));
        stepFileList.add(new AccountSteps(share));

        return new InstanceStepsFactory(configuration(), stepFileList);
    }

    protected List<String> storyPaths() {
        return new StoryFinder().
                findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()),
                        Arrays.asList("**/RegistrationTest.story"),
                        Arrays.asList(""));

    }
}
