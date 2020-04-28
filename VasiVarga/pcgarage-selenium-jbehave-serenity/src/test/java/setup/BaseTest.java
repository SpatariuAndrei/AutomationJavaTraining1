package setup;


import org.junit.AfterClass;
import org.junit.BeforeClass;

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
