package bdd;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.DisplayUrlSteps;

import java.util.Arrays;
import java.util.List;

public class TestStory extends JUnitStories {

    public TestStory() {
        this.configuredEmbedder().candidateSteps().add(new DisplayUrlSteps());
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryLoader(
                new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withFormats(Format.CONSOLE, Format.HTML)
                                .withRelativeDirectory("jbehave-report")
                );
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new DisplayUrlSteps());
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
    }

    @Override
    protected List<String> storyPaths() {
//        return new StoryFinder()
//                .findPaths(codeLocationFromClass(this.getClass()), "**/stories/*.story", "");
//
//        return new StoryFinder()
//              .findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), Arrays.asList(""));


        return Arrays.asList("stories/TestStory.story");
//        //C:\Work\cld_automation_community\RaulS\src\main\java\stories\TestStory.story
    }
}
