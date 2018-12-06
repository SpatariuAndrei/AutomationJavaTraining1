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
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.lang.reflect.Type;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.worldpay.service.entities.SharedData;
import com.worldpay.service.environment.Environment;
import com.worldpay.service.util.FileUtil;
import com.worldpay.service.util.MapSerializer;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestSubmissionSteps {
   
    private static final Logger LOGGER = LoggerFactory.getLogger(RestSubmissionSteps.class);
    private static final String REQUEST = "Request: \n{}";
    private static final String RESPONSE = "Response: \n{}";
    private static final String API_VALUE = "api";
    public static final String ACTION = "action";
    public static final String UPDATE_ACTION = "updateAction";
    public static final String QUERY_ID = "queryId";
    private static final String SLASH = "/";
    private String version;
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
        share.getTestData().setProperty("json.request", jSonRequest);
        LOGGER.info(REQUEST, jSonRequest);
    }

    @Given("I read JSON request from file")
    public void readJsonRequest() throws IOException, ParseException {
        String filePath = FileUtil.buildResourcesPath(share.getTestData().getString("json.request.path"));
        jSonRequest = FileUtil.readJsonFromFile(filePath);
        LOGGER.info(REQUEST, jSonRequest);
        share.getTestData().setProperty("json.request", jSonRequest);
    }
    
    @When("I set request specification for server")
    public void requestSpecificationServer() {
        setRequestSpecificationForServer();
    }

    @When("I $requestMethod the JSon request")
    public void sendRequest(String requestMethod) {
        sendHttpRequest(requestMethod, buildUrl(generatePath(requestMethod)));
    }

    @When("I $requestMethod the JSon request with custom parameters")
    public void sendRequestWithParameters(String requestMethod) {
        sendHttpRequest(requestMethod, buildUrl(share.getTestData().getString(API_VALUE)));
    }

    @Then("I can validate the response")
    public void validateResponse() {
        share.getResponse().then().assertThat().body("merchantId", equalTo(share.getTestData().getString("merchantId")));
    }

    @Then("I can validate the response against the json schema")
    public void validateResponseAgainstSchema() {
        share.getResponse().then().assertThat().body(matchesJsonSchemaInClasspath(share.getTestData().getString("json.schema")));
    }

    private String buildUrl(String api) {
        String protocol = share.getTestData().getString("server.protocol", Environment.ENVIRONMENT.get().getServerProtocol());
        String host = share.getTestData().getString("server.host", Environment.ENVIRONMENT.get().getServerHost());
        String port =  share.getTestData().getString("server.port",Environment.ENVIRONMENT.get().getServerPort());
        version =  share.getTestData().getString("server.version", Environment.ENVIRONMENT.get().getServerVersion());
        if (!port.isEmpty())
            return protocol + "://" + host + ":" + port + api;
        else
            return protocol + "://" + host + api;
    }

    /**
     * Builds the path of the api that will be called based on the operation: if no operation is provided, POST will be used by default, the
     * other possible operation is PUT. Adds the api, version and createAction to POST and also the queryId and updateAction to PUT. If
     * createAction has the value "empty" it will not be appended (used for Refund). Also adds "/" as a separator between parameters
     * 
     * @param operation
     * @return stringBuilder - the url after the protocol, host and port (e.g. /merchantHosted/v1.0/capture/201801092037030000000/cancel)
     */
    private String generatePath(String operation) {
        version =  share.getTestData().getString("server.version", Environment.ENVIRONMENT.get().getServerVersion());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SLASH).append(share.getTestData().getString(API_VALUE)).append(SLASH).append(version).append(SLASH);
        if (!StringUtils.EMPTY.equals(share.getTestData().getString(ACTION))) {
            stringBuilder.append(share.getTestData().getString(ACTION)).append(SLASH);
        }
        if (PUT.equals(operation)) {
            stringBuilder.append(share.getTestData().getString(QUERY_ID)).append(SLASH).append(share.getTestData().getString(UPDATE_ACTION));
        }
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
        final Type mapType = new TypeToken<Map<String, String>>() {
        }.getType();

        final String jsonTestData = new GsonBuilder().registerTypeAdapter(mapType, new MapSerializer()).create().toJson(testDataMap, mapType);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonTestData);
        return gson.toJson(je);
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

}
