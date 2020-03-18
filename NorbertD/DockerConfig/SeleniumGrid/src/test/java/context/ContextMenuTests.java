package context;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testRightClickAndGetTextFromAlert(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnRectangle();
        String alertText = contextMenuPage.alert_getText();
        contextMenuPage.alert_clickToAccept();
        assertEquals(alertText, "You selected a context menu");
    }
}
