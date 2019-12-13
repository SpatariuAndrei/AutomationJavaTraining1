import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jayway.restassured.RestAssured.given;


public class Basics {

    static final Logger logger = LoggerFactory.getLogger(Basics.class);

    /**
     * body are commented because my Google Account does not have an billing account
     */
    @Test
    public void testAss() {

        //BaseURL
        RestAssured.baseURI = "https://maps.googleapis.com";

        Response res = given().
                queryParam("location", "-33.8670522,151.1957362").
                queryParam("radius", "1500").
                queryParam("type", "restaurant").
                queryParam("keyword", "cruise").
                queryParam("key", "AIzaSyDCGv93hOXhV0oq6rlN_Dh1OQndC-NbFW8").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                //body("results[0].name", equalTo("Cruise Bar")).
                // body("results[0].place_id",equalTo("ChIJi6C1MxquEmsR9-c-3O48ykI")).
                //  body("status", equalTo("OVER_QUERY_LIMIT")).
                        header("Server", "scaffolding on HTTPServer2").
                        extract().response();

        logger.debug(res.asString());

    }



}
