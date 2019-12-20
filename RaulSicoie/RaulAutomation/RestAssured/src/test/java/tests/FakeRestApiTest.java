package tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ReadEnvProperties;

import java.util.HashMap;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FakeRestApiTest {

    static final Logger logger = LoggerFactory.getLogger(FakeRestApiTest.class);

    @BeforeTest
    public void setUp() {
        ReadEnvProperties envProperties = new ReadEnvProperties();
        RestAssured.baseURI = envProperties.getEnvProperty("host.url.fakerestapi");

        logger.info("Got the base url: " + RestAssured.baseURI);
    }

    @Test
    public void getActivities() {

        Response res = given().
                when().get("/Activities").
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                extract().response();

        JsonPath jsonPath = new JsonPath(res.asString());
        List<String> list = jsonPath.getList("Title");
        for (String s : list) {
            logger.info("Activity title: " + s);
        }

    }

    @Test
    public void postActivities() {

        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("ID", "31");
        postContent.put("Title", "WPG");
        postContent.put("DueDate", "");
        postContent.put("Completed", "true");

        given().
                contentType(ContentType.JSON).with().body(postContent).
                when().post("/Activities").
                then().assertThat().statusCode(200).and().body("Title", equalTo("WPG"));
    }

    @Test
    public void deleteActivities() {

        given().
                param("id", "2").
                when().get("/Activities").
                then().assertThat().statusCode(200).and().
                cookie("ARRAffinity", "854802364786e0e9dece0f12b922c9d9bf9d2b1bd7a60ce6cf026350306af032");
    }

    @Test
    public void putActivities() {

        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("ID", "2");
        postContent.put("Title", "WPG");
        postContent.put("Completed", "true");

        given().param("id", postContent.get("ID")).
                contentType(ContentType.JSON).body(postContent).
                when().put("/Activities").
                then().assertThat().statusCode(200);
    }
}
