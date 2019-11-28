package bdd.steps.setup;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.steps.Steps;
import properties.PropertiesConfig;
import uimappers.pages.EmagHomePage;
import bdd.utilities.SharedData;

import static properties.PropertiesKeys.*;

public class StoryBasicsSteps extends Steps {
    private SharedData sharedData;

    public StoryBasicsSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    /**
     * Hooks
     */
    @BeforeStory
    public void setup() {
        sharedData.driver = DriverInstance.getDriver();
        sharedData.driver.get(PropertiesConfig.getProperty(HOME_URL));
        sharedData.homePage = new EmagHomePage();

        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
        //set email
        String emailAddress = PropertiesConfig.getProperty(EMAG_EMAIL_ADDRESS);
        sharedData.loginPage.setLoginInputField("email", emailAddress);
        sharedData.loginPage.clickContinueValidPassword("Continua");
        //set password
        String passwordValue = PropertiesConfig.getProperty(EMAG_PASSWORD);
        sharedData.loginPage.setLoginInputField("password", passwordValue);
        sharedData.userHomePage = sharedData.loginPage.clickContinueValidPassword("Continua");
    }

    @BeforeScenario
    public void setScenario(){

    }

    @AfterScenario()
    public void tearDownScenario(){}

    @AfterStory
    public void tearDown(){
        sharedData.driver.quit();
    }

}
