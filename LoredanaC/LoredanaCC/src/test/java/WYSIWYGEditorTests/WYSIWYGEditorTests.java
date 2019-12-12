package WYSIWYGEditorTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.WYSIWYGEditorPage;

import static org.testng.Assert.assertEquals;

public class WYSIWYGEditorTests extends BaseTests {

    @Test
    public void enterTextInWYSIWYGEditor() {
        WYSIWYGEditorPage wysiwygEditorPage = homePage.clickWYSIWYGEditor();
        wysiwygEditorPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "World";

        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.decreaseIndention();
        wysiwygEditorPage.setTextArea(text2);
        assertEquals(wysiwygEditorPage.getTextFromArea(), text1 + text2, "Incorrect text");
    }
}
