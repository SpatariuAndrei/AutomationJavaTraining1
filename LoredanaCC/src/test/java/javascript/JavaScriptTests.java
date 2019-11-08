package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        homePage.navigateToHomePage();
        homePage.clickLargeAndDeepDom().scrollTable();
    }

    @Test
    public void testScrollToFifthParagraph() {
        homePage.navigateToHomePage();
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }

    @Test
    public void testDropdownOptions() {
        homePage.navigateToHomePage();
        List<String> optionsToSelect = new ArrayList<>();
        optionsToSelect.add("Option 1");
        optionsToSelect.add("Option 2");
        DropdownPage dropdownPage = homePage.clickDropDown();
        dropdownPage.addMultipleOption();
        for (String option :
                optionsToSelect) {
            dropdownPage.selectFromDropdown(option);
        }
        var selectedOptions = dropdownPage.getSelectedOption();
        assertEquals(selectedOptions.size(), selectedOptions.size(), "All option not selected");

    }
}
