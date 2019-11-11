package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.InfiniteScrollPage;
import pages.LargeAndDeepDomPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        homePage.navigateToHomePage();
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollTable();
        String actualValue = largeAndDeepDomPage.getFirstElementFromTable();
        assertEquals(actualValue, "1", "First element from table is incorrect");
    }

    @Test
    public void testScrollToFifthParagraph() {
        homePage.navigateToHomePage();
        int index = 2;
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(index);
        boolean actualValue = infiniteScrollPage.checkIfParagraphContainsWord(index, "a");
        assertEquals(actualValue, true, "word doesn't exist");
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
