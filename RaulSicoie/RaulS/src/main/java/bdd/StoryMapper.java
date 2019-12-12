package bdd;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;

import java.util.Arrays;
import java.util.List;

public class StoryMapper extends JUnitStories {

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
    protected List<String> storyPaths() {
        return Arrays.asList("stories/*.story");
    }
}
