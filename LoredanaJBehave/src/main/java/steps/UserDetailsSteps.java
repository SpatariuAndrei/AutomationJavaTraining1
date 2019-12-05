package steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import utils.*;

import java.io.IOException;
import java.util.LinkedHashMap;

import static org.testng.Assert.assertTrue;

public class UserDetailsSteps extends Steps {

    private SharedData sharedData;
    private WebDriverUtilities webDriverUtilities;
    private LinkedHashMap<String,String> map;
    private String selectedOption;

    public UserDetailsSteps(SharedData sharedData) {
        this.sharedData = sharedData;
        webDriverUtilities = new WebDriverUtilities(sharedData);
    }

    @Given("I navigate to my personal data page to edit data")
    public void givenINavigateToMyPersonalDataPage() {
        sharedData.homePage.moveOverProfilePicture();
        sharedData.homePage.clickOnProfile();
        sharedData.homePage.editPersonalData();
    }

    @Given("I stream my test data: $data")
    public void givenIStreamMyTestData(String data) throws IOException {
        String filePath = System.getProperty("user.dir") + data;
        map = webDriverUtilities.getDataFromFile(filePath);
    }

    @Given("I populate my account with data")
    public void givenIPopulateMyAccountWithData() {
        if(map.get("user.gender").equals("male"))
            sharedData.homePage.clickOnDlButton();
        else
            sharedData.homePage.clickOnDnaButton();
        sharedData.homePage.setNameField(map.get("user.lastname") + " " + map.get("user.firstname"));
        sharedData.homePage.setNickNameField(map.get("user.nickname"));
        sharedData.homePage.setFixField(map.get("user.phone"));
        selectedOption = sharedData.homePage.selectDropdownOption(4);
        sharedData.homePage.saveChanges();
    }

    @Then("I check that data was populated correctly")
    public void thenICheckThatDataWasPopulatedCorrectly() {
        assertTrue(sharedData.homePage.isDnaButtonPressed(),"dna button not pressed");
        assertTrue(sharedData.homePage.isNameFieldCompleted(),"name field not completed");
        assertTrue(sharedData.homePage.isNickNameFieldCompleted(), "nickname not completed");
        assertTrue(sharedData.homePage.isFixFieldCompleted(), "fix phone not completed");
        assertTrue(sharedData.homePage.isDropdownOptionSelected(selectedOption), "Bad dropdown option");
    }
}
