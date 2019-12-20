package request;

import com.jayway.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class Authors {

    static final Logger LOGGER = LoggerFactory.getLogger(Authors.class);
    private static String param;
    private static Response res;

    public static void setParam(String param) {
        Authors.param = param;
    }

    public static String getParameters() {
        return "/" + param;
    }

    public static void getAuthors() {
        res = given().
                when().get(getParameters()).
                then().assertThat().statusCode(200).and().
                extract().response();

        LOGGER.info("Extracted the response...");
    }

    public static void runTests() {
        JsonPath jsonPath = new JsonPath(res.asString());

        List<Object> idList = jsonPath.getList("ID");
        List<String> idBookList = jsonPath.getList("IDBook");
        List<String> FirsNameList = jsonPath.getList("FirstName");
        List<String> LastNameList = jsonPath.getList("LastName");

        for (int i = 0; i < idList.size(); i++) {
            assertEquals(FirsNameList.get(i).substring(11), idList.get(i).toString());
            assertEquals(LastNameList.get(i).substring(10), idList.get(i).toString());
            assertNotEquals(idBookList.get(i), idList.get(i).toString());
        }

        LOGGER.info("Run the tests...");
    }


}
