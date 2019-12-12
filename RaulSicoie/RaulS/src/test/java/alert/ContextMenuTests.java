package alert;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testPopUpText() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickInBox();
        String actualMessage = contextMenuPage.getPopUpText();
        contextMenuPage.acceptPopUp();
        assertEquals(actualMessage, "You selected a context menu", "Pop up text is wrong");
    }
}
