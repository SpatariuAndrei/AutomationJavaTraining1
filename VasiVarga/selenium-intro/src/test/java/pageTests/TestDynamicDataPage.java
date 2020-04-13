package pageTests;

import org.testng.annotations.Test;
import pages.DynamicDataPage;
import setUpTest.SetUp;

import java.io.IOException;

public class TestDynamicDataPage extends SetUp{

    @Test
    public void runDynamicPage() throws IOException {

        driver.navigate().to("http://demo.automationtesting.in/DynamicData.html");

        DynamicDataPage ddp = new DynamicDataPage(driver);

        ddp.generateUser();

    }

}
