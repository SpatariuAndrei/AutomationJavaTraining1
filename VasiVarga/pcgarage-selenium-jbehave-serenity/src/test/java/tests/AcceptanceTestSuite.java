package tests;

import net.serenitybdd.jbehave.SerenityStories;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AcceptanceTestSuite extends SerenityStories {

    public AcceptanceTestSuite() {
        runSerenity().inASingleSession();
    }

}
