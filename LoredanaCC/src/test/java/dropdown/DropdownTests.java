package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        DropdownPage dropDownPage = homePage.clickDropDown();
        dropDownPage.selectFromDropdown("Option 1");
        var selectedOptions = dropDownPage.getSelectedOption();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains("Option 1"), "Option not selected!");
    }
}
