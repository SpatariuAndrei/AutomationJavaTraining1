package frame;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testEditor() {
        EditorPage editorPage = homePage.clickEditorPage();
        editorPage.ClearTextArea();
        String text1 = "Salve ";
        String text2 = "there!";
        editorPage.setTextArea(text1);
        editorPage.DecreaseIndentation();
        editorPage.setTextArea(text2);
        assertEquals(editorPage.getTextFromEditor(), text1 + text2, "Text from editor is incorrect");
    }
}
