package com.worldpay.service.rest;

import static com.worldpay.service.constants.HttpConstants.Config.HTTP_CONNECTION_TIMEOUT_PARAM;
import static com.worldpay.service.constants.HttpConstants.Config.HTTP_SOCKET_TIMEOUT_PARAM;
import static com.worldpay.service.constants.HttpConstants.Headers.HEADER_NAME;
import static com.worldpay.service.constants.HttpConstants.Headers.HEADER_VALUE;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.DELETE;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.GET;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.HEAD;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.OPTIONS;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.POST;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.PUT;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.CUSTOM_SERVER_HOST;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.CUSTOM_SERVER_PORT;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.CUSTOM_SERVER_PROTOCOL;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.CUSTOM_SERVER_VERSION;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_CUSTOM_PATH;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_HOST;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_PATH_PART_1;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_PATH_PART_2;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_PORT;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_PROTOCOL;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_VERSION;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SLASH;
import static com.worldpay.service.constants.TestDataConstants.Json.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.worldpay.service.entities.SharedData;
import com.worldpay.service.environment.Environment;
import com.worldpay.service.util.FileUtil;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.jalokim.propertiestojson.util.PropertiesToJsonConverter;

public class RestSubmissionSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestSubmissionSteps.class);
    private static final String REQUEST = "Request: \n{}";
    private static final String RESPONSE = "Response: \n{}";
    private String httpConnectionTimeout;
    private String httpSocketTimeout;
    private RequestSpecification requestSpecification;
    private String jSonRequest;
    private SharedData share;

    public RestSubmissionSteps(SharedData share) {
        this.share = share;
    }

    @Before
    @BeforeScenario
    public void setUp() {
        httpConnectionTimeout = Environment.ENVIRONMENT.get().getHttpConnectionTimeout();
        httpSocketTimeout = Environment.ENVIRONMENT.get().getHttpSocketTimeout();
    }

    @When("I create JSON request")
    public void createJsonRequest() {
        jSonRequest = createJsonFromTestData(share.getTestData());
        share.getTestData().setProperty(JSON_REQUEST, jSonRequest);
        LOGGER.info(REQUEST, jSonRequest);
    }

    @Given("I read JSON request from file")
    public void readJsonRequest() throws IOException, ParseException {
        String filePath = FileUtil.buildResourcesPath(share.getTestData().getString(JSON_REQUEST_PATH));
        jSonRequest = FileUtil.readJsonFromFile(filePath);
        LOGGER.info(REQUEST, jSonRequest);
        share.getTestData().setProperty(JSON_REQUEST, jSonRequest);
    }

    @When("I set request specification for server")
    public void requestSpecificationServer() {
        setRequestSpecificationForServer();
    }

    @When("I $requestMethod the JSon request")
    public void sendRequest(String requestMethod) {
        sendHttpRequest(requestMethod, buildUrl(generatePath()));
    }

    @When("I $requestMethod the JSon request with custom parameters")
    public void sendRequestWithParameters(String requestMethod) {
        sendHttpRequest(requestMethod, buildUrl(share.getTestData().getString(SERVER_CUSTOM_PATH)));
    }

    @Then("I can validate the response")
    public void validateResponse() {
        share.getResponse().then().assertThat().body("merchantId", equalTo(share.getTestData().getString("merchantId")));
    }

    @Then("I can validate the response against the json schema")
    public void validateResponseAgainstSchema() {
        share.getResponse().then().assertThat().body(matchesJsonSchemaInClasspath(share.getTestData().getString(JSON_SCHEMA)));
    }

    private String buildUrl(String api) {

        String protocol = getProtocol();
        String host = getHost();
        String port = getPort();
        if (!port.isEmpty())
            return protocol + "://" + host + ":" + port + api;
        else
            return protocol + "://" + host + api;
        
    }

    /**
     * Generates the path needed by each API to contain the version set in the property files
     * 
     * @return stringBuilder - the url after the protocol, host and port (e.g. /merchantHosted/v1.0/capture/201801092037030000000/cancel)
     */
    private String generatePath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SLASH).append(share.getTestData().getString(SERVER_PATH_PART_1)).append(SLASH).append(getServiceVersion()).append(SLASH)
                .append(share.getTestData().getString(SERVER_PATH_PART_2));
        return stringBuilder.toString();
    }

    /**
     * Sends a request with a specific requestMethod to a given url and sets the response on an object, in case of exception calls fail()
     * method
     * 
     * @param requestMethod
     *            indicates the desired action to be performed for a given resource
     * @param url
     *            reference to a web resource that specifies its location on a computer network and a mechanism for retrieving it
     *
     */
    private void sendHttpRequest(String requestMethod, String url) {

        try {
            share.setResponse(chooseMethodAndSendRequest(requestMethod, url));
            String response = share.getResponse().getBody().prettyPrint();
            LOGGER.info(RESPONSE, response);
        } catch (Exception e) {
            fail(String.format("Failed to connect to %s %n %s", url, e));
        }
    }

    /**
     * Sends a request with a specific requestMethod to a given url
     * 
     * @param requestMethod
     *            indicates the desired action to be performed for a given resource
     * @param url
     *            reference to a web resource that specifies its location on a computer network and a mechanism for retrieving it
     * @return response for a http request
     */
    private Response chooseMethodAndSendRequest(String requestMethod, String url) {
        Response response;
        switch (requestMethod) {
        case DELETE:
            response = requestSpecification.when().delete(url);
            break;
        case GET:
            response = (requestSpecification == null) ? given().get(url) : requestSpecification.when().get(url);
            break;
        case HEAD:
            response = requestSpecification.when().head(url);
            break;
        case OPTIONS:
            response = requestSpecification.when().options(url);
            break;
        case POST:
            response = requestSpecification.when().post(url);
            break;
        case PUT:
            response = requestSpecification.when().put(url);
            break;
        default:
            throw new IllegalArgumentException("Choose one of the following: delete, get, head, options, post, put as request type");
        }
        return response;
    }

    private void setRequestSpecificationForServer() {
        Map<String, String> headersMap = parseHeaderInfo();

        requestSpecification = given().config(configHttpClient());
        String serviceCertificate = Environment.ENVIRONMENT.get().getServerCertificate();
        String serviceCertPassword = Environment.ENVIRONMENT.get().getServerCertPass();
        if (StringUtils.isNotBlank(serviceCertificate) && serviceCertPassword != null) {
            requestSpecification = requestSpecification.trustStore(serviceCertificate, serviceCertPassword);
        }
        requestSpecification.headers(headersMap).body(jSonRequest);
    }

    /**
     * Gets header info from test data and sets it into a map to have a flexible way of setting one or more headers on a requestSpecificaton
     * 
     * @return headersMap - header info specified as a as map
     */
    private Map<String, String> parseHeaderInfo() {

        Map<String, String> headersMap = new HashMap<>();
        String[] headerNames = share.getTestData().getString(HEADER_NAME).split(";");
        String[] headerValues = share.getTestData().getString(HEADER_VALUE).split(";");

        for (int i = 0; i < headerNames.length; i++) {
            headersMap.put(headerNames[i], headerValues[i]);
        }
        return headersMap;

    }

    /**
     * Sets configurations params for http client used to make service calls
     * 
     * @return a configuration of http client containing with values set for "http.connection.timeout" and "http.socket.timeout"
     * 
     */
    private RestAssuredConfig configHttpClient() {

        return RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig().setParam(HTTP_CONNECTION_TIMEOUT_PARAM, Integer.parseInt(httpConnectionTimeout))
                        .setParam(HTTP_SOCKET_TIMEOUT_PARAM, Integer.parseInt(httpSocketTimeout)));

    }

    /**
     * Builds the JSON request from the testData
     * 
     * @param testData
     * @return
     */
    private String createJsonFromTestData(CompositeConfiguration testData) {
        final Map<String, String> testDataMap = testDataToMap(testData);
        return new PropertiesToJsonConverter().convertToJson(testDataMap);
    }

    /**
     * Converts a CompositeConfiguration object to a Map, so that it can be transformed afterwards in a JSON request
     * 
     * @param testData
     * @return
     */
    private Map<String, String> testDataToMap(CompositeConfiguration testData) {
        final ListOrderedMap<String, String> testDataMap = new ListOrderedMap<>();
        for (final Iterator<String> it = testData.getKeys(); it.hasNext();) {
            final String key = it.next();
            testDataMap.put(testDataMap.size(), key, testData.getString(key));
        }
        return testDataMap;
    }

    /**
     * @return the service version as String 
     * the service version is specified by default 
     * in property file but can be overwritten
     * with a custom value 
     * from story file(or table file)
     */
    private String getServiceVersion() {
        String customServerVersion = share.getTestData().getString(CUSTOM_SERVER_VERSION);
        return (customServerVersion != null ? share.getTestData().getString(SERVER_VERSION, customServerVersion)
                : share.getTestData().getString(SERVER_VERSION, Environment.ENVIRONMENT.get().getServerVersion()));
    }

    /**
     * @return port as String 
     * the port is specified by default 
     * in property file but can be overwritten
     * with a custom value 
     * from story file(or table file)
     */
    private String getPort() {
        String customServerPort = share.getTestData().getString(CUSTOM_SERVER_PORT);
        return (customServerPort != null ? share.getTestData().getString(SERVER_PORT, customServerPort)
                : share.getTestData().getString(SERVER_PORT, Environment.ENVIRONMENT.get().getServerPort()));
    }

    /**
     * @return host name as String 
     * the host name is specified by default 
     * in property file but can be overwritten
     * with a custom value 
     * from story file(or table file)
     */
    private String getHost() {
        String customServerPort = share.getTestData().getString(CUSTOM_SERVER_HOST);
        return (customServerPort != null ? share.getTestData().getString(SERVER_HOST, customServerPort)
                : share.getTestData().getString(SERVER_HOST, Environment.ENVIRONMENT.get().getServerHost()));
    }

    /**
     * @return protocol as String 
     * the protocol is specified by default 
     * in property file but can be overwritten
     * with a custom value 
     * from story file(or table file)
     */
    private String getProtocol() {
        String customServerProtocol = share.getTestData().getString(CUSTOM_SERVER_PROTOCOL);
        return (customServerProtocol != null ? share.getTestData().getString(SERVER_PROTOCOL, customServerProtocol)
                : share.getTestData().getString(SERVER_PROTOCOL, Environment.ENVIRONMENT.get().getServerProtocol()));
    }

}
