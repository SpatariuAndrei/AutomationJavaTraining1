package com.test.jbehave.tests;

import java.util.List;
import com.test.jbehave.utils.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import com.test.jbehave.steps.AddToCartSteps;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AddToCartStories extends StoryMapper {

//    public MyStories() {
//        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
//                .doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(60);
//    }

//    @Override
//    public Configuration configuration() {
//        Class<? extends Embeddable> embeddableClass = this.getClass();
//        // Start from default ParameterConverters instance
//        ParameterConverters parameterConverters = new ParameterConverters();
//        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
//        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
//        // add custom converters
//        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
//                new ExamplesTableConverter(examplesTableFactory));
//        return new MostUsefulConfiguration()
//                .useStoryLoader(new LoadFromClasspath(embeddableClass))
//                .useStoryParser(new RegexStoryParser(examplesTableFactory))
//                .useStoryReporterBuilder(new StoryReporterBuilder()
//                        .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
//                        .withDefaultFormats()
//                        .withFormats(CONSOLE, TXT, HTML, XML).withReporters(new AllureReporter()))
//                .useParameterConverters(parameterConverters);
//    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new AddToCartSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/add_to_cart.story", "**/excluded*.story");

    }

}