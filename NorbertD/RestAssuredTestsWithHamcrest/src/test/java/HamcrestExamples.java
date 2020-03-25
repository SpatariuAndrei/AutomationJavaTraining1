import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HamcrestExamples {

    @Test
    public void TestGetBookByPauloCoelhoWithHamcrest(){
        given().
            param("q","paulo+coelho").
        when().
            get("https://www.googleapis.com/books/v1/volumes").
        then().
            assertThat().statusCode(200).body("totalItems",greaterThan(0));
    }

    @Test
    public void TestGetHarryPotterBooksWithHamcrest(){
        given().
            param("q","potter").
        when().
            get("https://www.googleapis.com/books/v1/volumes").
        then().
            assertThat().statusCode(200).body("items", hasSize(10));
    }

    @Test
    public void TestGetBooksByDanBrownWithHamcrest(){
        given().
            param("q","dan+brown").param("maxResults","25").
        when().
            get("https://www.googleapis.com/books/v1/volumes").
        then().
            assertThat().statusCode(200).body("items", hasSize(25));
    }

    @Test
    public void TestGetWithEmptyQueryParamsWithHamcrest(){
        given().
            param("q","").
        when().
            get("https://www.googleapis.com/books/v1/volumes").
        then().
            assertThat().statusCode(400).body("error.message", equalTo("Missing query.")).body("error.errors[0].location",equalTo("q"));
    }

    @Test
    public void TestGetWithInvalidQueryParamsWithHamcrest(){
        given().
            param("q","potter").param("maxResults","50").
        when().
            get("https://www.googleapis.com/books/v1/volumes").
        then().
            assertThat().statusCode(400).body("error.message", containsString("Values must be within the range: [0, 40]"),"error.errors[0].location",equalTo("maxResults"));
    }
}
