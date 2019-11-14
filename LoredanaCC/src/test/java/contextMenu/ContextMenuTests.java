package contextMenu;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertTrue;

public class ContextMenuTests extends BaseTests {

    @Test
    public void contextMenuTest() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.clickOnBox();
        String text = "You selected a context menu";
        assertTrue(contextMenuPage.verifyModalText(text), text);
    }
}

