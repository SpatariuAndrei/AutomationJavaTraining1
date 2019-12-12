import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.given;

public class Basics {

    public static void main(String[] args) {

        //BaseURL
        RestAssured.baseURI = "https://maps.googleapis.com";

        given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "500").
                param("key", "AIzaSyDCGv93hOXhV0oq6rlN_Dh1OQndC-NbFW8").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200);

    }

}
