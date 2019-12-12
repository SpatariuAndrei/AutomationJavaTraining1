package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;

import static org.testng.Assert.assertEquals;

public class WysiwygFrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditor();
        wysiwygEditorPage.clearTextArea();
        String text1 = "hello";
        String text2 = "world";
        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.decreaseIndentation();
        wysiwygEditorPage.setTextArea(text2);
        assertEquals(wysiwygEditorPage.getTextFromEditor(), text1 + text2, "Text from editor is incorrect");
    }
}
