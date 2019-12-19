package request;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadEnvProperties;

import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class Users {

    static final Logger LOGGER = LoggerFactory.getLogger(Users.class);
    private static Response res;
    private static ReadEnvProperties envProperties = new ReadEnvProperties();

    public static void getUsers(int id) {
        res = given().
                pathParam("id", id).
                when().get(envProperties.getEnvProperty("get.user.by.id")).
                then().assertThat().statusCode(200).and().
                extract().response();

        JsonPath jsonPath = new JsonPath(res.asString());
        String userName = jsonPath.getString("UserName");

        LOGGER.info("Found user with name: " + userName);
    }

    public static void addUser(int id, String userName, String password) {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("ID", String.valueOf(id));
        userMap.put("UserName", userName);
        userMap.put("Password", password);

        res = given().
                contentType(ContentType.JSON).body(userMap).
                when().post(envProperties.getEnvProperty("post.user")).
                then().assertThat().statusCode(200).extract().response();

        LOGGER.info("Added user with: " + res.asString());
    }

    public static void deleteUser(int id) {
        res = given().
                pathParam("id", id).
                when().delete(envProperties.getEnvProperty("delete.user")).
                then().assertThat().statusCode(200).extract().response();

        LOGGER.info("Deleted user with id: " + id);
    }

    public static int getResponse() {
        LOGGER.info("Response is: " + res.getStatusCode());
        return res.getStatusCode();
    }
}
