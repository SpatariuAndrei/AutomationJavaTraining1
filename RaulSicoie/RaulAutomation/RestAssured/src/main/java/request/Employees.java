package request;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadEnvProperties;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class Employees {

    static final Logger LOGGER = LoggerFactory.getLogger(Employees.class);
    private static Response res;
    private static ReadEnvProperties envProperties = new ReadEnvProperties();

    public static void createUser(String employee) {

        res = given().
                contentType(ContentType.JSON).with().body(processData(employee)).
                when().post(envProperties.getEnvProperty("employee.create")).
                then().assertThat().statusCode(200).and().extract().response();

        LOGGER.info("Created: " + processData(employee).toString());
    }

    private static Map<String, String> processData(String employee) {
        HashMap<String, String> map = new HashMap<>();

        String name = employee.substring(8, 16);
        String salary = employee.substring(26, 29);
        String age = employee.substring(38, 41);

        map.put("name", name);
        map.put("salary", salary);
        map.put("age", age);

        LOGGER.info("Processed data: " + name + " " + salary + " " + age);
        return map;
    }

    public static int getResponseCode() {
        return res.getStatusCode();
    }

}
