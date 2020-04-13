package pageTests;

import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.StaticDragAndDropPage;
import setUpTest.SetUp;

public class TestStaticDragAndDrop extends SetUp {

    @Test
    public void testStaticDragAndDrop(){
        driver.get("http://demo.automationtesting.in/Static.html");

        StaticDragAndDropPage page = new StaticDragAndDropPage(driver);

        page.dragAndDrop("mongo");  //

    }
}
