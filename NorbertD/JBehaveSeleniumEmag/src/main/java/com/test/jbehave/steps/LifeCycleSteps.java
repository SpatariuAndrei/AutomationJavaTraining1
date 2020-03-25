package com.test.jbehave.steps;

import com.test.jbehave.base.Driver;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriverException;

import java.util.Set;

public class LifeCycleSteps {

    @BeforeScenario
    public void initialization(){
        Driver.init();
    }

    @AfterScenario
    public void cleanup(){
            Driver.tearDown();
    }

    @BeforeStories
    public void runBeforeAllStories() {
        try {
            // do something
            // ie. delete cookies
            System.out.println("You can run something here before executing all the stories!\n\n");
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllCookies() {
        try {
            System.out.println("\nDeleting all the cookies!");
            Set<Cookie> cookies = Driver.driver.manage().getCookies();
            for (Cookie c : cookies) {
                System.out.println("\tCookie: " + c.getName());
            }
            Driver.driver.manage().deleteAllCookies();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }
}
