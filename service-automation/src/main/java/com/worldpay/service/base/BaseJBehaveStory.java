package com.worldpay.service.base;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.commons.configuration.CompositeConfiguration;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.PassingUponPendingStep;
import org.jbehave.core.failures.RethrowingFailure;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.AbsolutePathCalculator;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.FreemarkerViewGenerator;
import org.jbehave.core.reporters.PrintStreamStepdocReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.StepFinder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.worldpay.service.entities.SharedData;
import com.worldpay.service.util.EnvironmentUtil;
import com.worldpay.service.util.FileUtil;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import io.restassured.internal.RestAssuredResponseImpl;

@RunWith(JUnitReportingRunner.class)
public class BaseJBehaveStory extends JUnitStories {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseJBehaveStory.class);
    protected static final String STORY_TIMEOUT = "storyTimeout";
    protected static final int NUMBER_OF_THREADS = 1;
    private Configuration configuration;
    protected SharedData share = new SharedData();

    public BaseJBehaveStory() {
        super();
        configuration = new Configuration() {
        };
        configuration.useFailureStrategy(new RethrowingFailure()).useKeywords(new LocalizedKeywords(Locale.ENGLISH))
                .usePathCalculator(new AbsolutePathCalculator()).useParameterControls(new ParameterControls()).useParameterConverters(new ParameterConverters())
                .usePendingStepStrategy(new PassingUponPendingStep()).useStepdocReporter(new PrintStreamStepdocReporter())
                .useStepCollector(new MarkUnmatchedStepsAsPending()).useStepFinder(new StepFinder()).useStepFinder(new StepFinder())
                .useStepMonitor(new SilentStepMonitor()).useStepPatternParser(new RegexPrefixCapturingPatternParser())
                .useStepPatternParser(new RegexPrefixCapturingPatternParser()).useStoryControls(new StoryControls()).useStoryLoader(new LoadFromClasspath())
                .useStoryParser(new RegexStoryParser(configuration.keywords())).useStoryPathResolver(new UnderscoredCamelCaseResolver())
                .useStoryPathResolver(new UnderscoredCamelCaseResolver()).useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats()
                        .withFormats(Format.TXT, Format.CONSOLE, Format.HTML_TEMPLATE, Format.HTML, Format.XML, Format.XML_TEMPLATE))
                .useViewGenerator(new FreemarkerViewGenerator());

        EmbedderControls embedderControls = configuredEmbedder().embedderControls();
        embedderControls.doBatch(false).doGenerateViewAfterStories(true).doIgnoreFailureInStories(true).doIgnoreFailureInView(true).doSkip(false)
                .doVerboseFailures(false).doVerboseFiltering(false).useStoryTimeouts(FileUtil.readProp(EnvironmentUtil.GENERAL_PROPERTIES_PATH, STORY_TIMEOUT))
                .useThreads(NUMBER_OF_THREADS);

        share.setResponse(new RestAssuredResponseImpl());
        share.setTestData(new CompositeConfiguration());
        share.getTestData().setDelimiterParsingDisabled(true);

    }

    /**
     * JBehave configuration
     */
    @Override
    public Configuration configuration() {
        return configuration;

    }

    @Override
    protected List<String> storyPaths() {
        return Collections.emptyList();
    }

}
