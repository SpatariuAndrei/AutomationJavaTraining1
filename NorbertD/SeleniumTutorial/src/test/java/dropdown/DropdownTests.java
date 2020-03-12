package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option Not Selected");
    }

    @Test
    public void testMultipleSelectElementsWithJavaScript(){
        var dropDownPage = homePage.clickDropdown();
        dropDownPage.setDropdownToMultipleSelect();
        List<String> options = Arrays.asList("Option 1","Option 2");
        dropDownPage.selectMultipleFromDropdown(options);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),2, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(options.get(0)), "Option 1 Not Selected");
        assertTrue(selectedOptions.contains(options.get(1)), "Option 2 Not Selected");
    }
}
