package request.base;

import com.jayway.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadEnvProperties;

public class BaseUrl {

    static final Logger LOGGER = LoggerFactory.getLogger(BaseUrl.class);


    public static void setUpFakeRestApi() {
        ReadEnvProperties envProperties = new ReadEnvProperties();
        RestAssured.baseURI = envProperties.getEnvProperty("host.url.fakerestapi");

        LOGGER.info("Got the base url: " + RestAssured.baseURI);
    }

    public static void setUpDummyRestApi() {
        ReadEnvProperties envProperties = new ReadEnvProperties();
        RestAssured.baseURI = envProperties.getEnvProperty("host.url.dummy");

        LOGGER.info("Got the base url: " + RestAssured.baseURI);
    }
}
