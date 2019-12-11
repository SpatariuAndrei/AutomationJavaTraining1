package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        DropdownPage dropdownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        List<String> selectedOption = dropdownPage.getSelectedOption();
        assertEquals(selectedOption.size(), 1, "Incorect number of selections");
        assertTrue(selectedOption.contains(option), "Option not selected");
    }

    @Test
    public void testSelectBothOptions() {
        DropdownPage dropdownPage = homePage.clickDropdown();
        dropdownPage.selectMoreOptions();

        List<String> optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectFromDropdown);

        List<String> selectedOptions = dropdownPage.getSelectedOption();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
    }
}
