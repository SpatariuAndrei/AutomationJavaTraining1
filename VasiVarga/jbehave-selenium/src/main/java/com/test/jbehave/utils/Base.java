package com.test.jbehave.utils;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.steps.Steps;

public class Base extends Steps {
    @BeforeScenario
    public void initialization(){
        Driver.init();
        Driver.driver.manage().window().maximize();
    }

    @AfterScenario
    public void cleanup(){
            Driver.tearDown();
        }
}
