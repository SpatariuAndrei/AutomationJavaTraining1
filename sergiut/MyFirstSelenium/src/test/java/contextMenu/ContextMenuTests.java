package contextMenu;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void test1() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenuPage();
        contextMenuPage.rightClickArea();
        String text = contextMenuPage.alert_getText();
        contextMenuPage.alert_clickToAccept();
        assertEquals(text, "You selected a context menu", "Wrong Alert");
    }
}
