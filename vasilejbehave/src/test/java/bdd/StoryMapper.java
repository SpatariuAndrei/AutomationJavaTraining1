package bdd;

import driverprovider.DriverInstance;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import properties.PropertiesConfig;
import utilities.SharedData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static properties.PropertiesKeys.HOME_ADDRESS;

public abstract class StoryMapper extends JUnitStories {
    private static final String META_FILTER_SYSTEM_PROPERTY = "meta.filter";

    @Override
    public void addSteps(CandidateSteps... steps) {
        super.addSteps(steps);
        Embedder configuredEmbedder = configuredEmbedder();
        configuredEmbedder.useMetaFilters(getMetaFilters());
        EmbedderControls embedderControls = configuredEmbedder.embedderControls();
        embedderControls.useThreads(1).useStoryTimeoutInSecs(300).doIgnoreFailureInStories(true).ignoreFailureInView();
    }

    protected List<String> getMetaFilters() {
        String metaFilterProperty = System.getProperty(META_FILTER_SYSTEM_PROPERTY);
        List<String> properties = new LinkedList<String>();

        if (metaFilterProperty != null) {
            String[] metaFilterProperties = metaFilterProperty.split(",");
            properties = new LinkedList<String>(Arrays.asList(metaFilterProperties));
        }
        properties.add("-skip");

        return properties;
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(
                        new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.HTML, Format.CONSOLE)
                                .withRelativeDirectory("jbehave-report")
                );
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/*.story", "");
    }
}
