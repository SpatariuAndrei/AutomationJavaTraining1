package request;

import com.jayway.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadEnvProperties;

import static com.jayway.restassured.RestAssured.given;

public class EmployeesNames {

    static final Logger LOGGER = LoggerFactory.getLogger(EmployeesNames.class);
    private static Response res;
    private static ReadEnvProperties envProperties = new ReadEnvProperties();

    public static void getUsers() {
        res = given().
                when().get(envProperties.getEnvProperty("employee.get")).
                then().assertThat().statusCode(200).and().
                extract().response();

        LOGGER.info("GET request");
    }

    public static String getName() {
        JsonPath jsonPath = new JsonPath(res.asString());
        String name = jsonPath.getString("employee_name");

        LOGGER.info("Return the employee name:" + name);
        return name;
    }
}
