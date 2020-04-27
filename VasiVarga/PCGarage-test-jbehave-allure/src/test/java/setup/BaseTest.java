package setup;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    @BeforeClass
    public static void setUp(){
        //getDriver().get("https://pcgarage.ro");
        //driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        //getDriver().close();
    }

}
