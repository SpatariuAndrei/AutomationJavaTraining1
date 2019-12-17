package request.base;

import com.jayway.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadEnvProperties;

public class BaseUrl {

    static final Logger LOGGER = LoggerFactory.getLogger(BaseUrl.class);


    public static void setUp() {
        ReadEnvProperties envProperties = new ReadEnvProperties();
        RestAssured.baseURI = envProperties.getEnvProperty("host.url");

        LOGGER.info("Got the base url: " + RestAssured.baseURI);
    }
}
