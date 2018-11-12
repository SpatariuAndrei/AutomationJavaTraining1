package com.worldpay.service.rest;

//import static com.worldpay.singleclick.constants.TestDataConstants.CREATE_ACTION;
//import static com.worldpay.singleclick.constants.TestDataConstants.QUERY_ID;
//import static com.worldpay.singleclick.constants.TestDataConstants.REQUEST;
//import static com.worldpay.singleclick.constants.TestDataConstants.TAG;
//import static com.worldpay.singleclick.constants.TestDataConstants.UPDATE_ACTION;
import static com.worldpay.service.util.FileUtil.readProp;
import static io.restassured.RestAssured.given;
import static org.apache.commons.lang.StringUtils.isNotBlank;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.worldpay.service.entities.SharedData;
import com.worldpay.service.util.EnvironmentUtil;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestSubmissionSteps {

    private static final String HEADER_NAME = "headerName";
    private static final String HEADER_VALUE = "headerValue";
    private static final String API_VALUE = "api";
    // private static final String LOG_URL = "URL: {}";
    // private static final String REQUEST_URL = "Request: {}";
    private static final String SERVER_PROTOCOL = "server.protocol";
    private static final String SERVER_HOST = "server.host";
    private static final String SERVER_PORT = "server.port";
    private static final String SERVICE_CERTIFICATE = "service.certificate";
    private static final String SERVICE_CERT_PASS = "service.cert.pass";

    // private static final String SLASH = "/";
    private static final String DELETE = "delete";
    private static final String GET = "get";
    private static final String HEAD = "head";
    private static final String OPTIONS = "options";
    private static final String PUT = "put";
    private static final String POST = "post";
    private static final String PROPERTIES_PATH = EnvironmentUtil.getEnvironment().getPropertiesPath();
    private static final String HTTP_CONNECTION_TIMEOUT = "http.connection.timeout";
    private static final String HTTP_SOCKET_TIMEOUT = "http.socket.timeout";

    private RequestSpecification requestSpecification;
    private String jSonRequest;
    private SharedData share;

    public RestSubmissionSteps(SharedData share) {
        this.share = share;
    }

    @Given("JSon request")
    public void givenJsonRequest() {

        // share.getTestData().setProperty(REQUEST, jSonRequest);
        jSonRequest = "{ \"merchant\": { \"id\": \"000000\", \"registrationInfo\": { \"address\": { \"addressLine1\": \"string\", \"countryCode\": \"GBR\", \"postCode\": \"string\" }, \"categoryCode\": \"1\", \"commonName\": \"string\", \"creditAccount\": { \"accountNumber\": \"string\", \"rollNumber\": \"string\", \"sortCode\": \"814940\" }, \"groupId\": \"string\", \"keyId\": \"string\", \"logoUrl\": \"string\", \"name\": \"string\" } } }";
        setRequestSpecificationForServer();
    }

    @When("I $requestMethod the JSon request")
    public void whenPostJsonRequest(@Named("requestMethod") String requestMethod) {
        sendHttpRequest(requestMethod, buildUrl(SERVER_PROTOCOL, SERVER_HOST, SERVER_PORT, "/payByBankApp/v1.0/merchant/registration"));
    }

    @When("I $requestMethod the JSon request with custom parameters")
    public void whenSubmitJsonRequest(@Named("requestMethod") String requestMethod) {
        sendHttpRequest(requestMethod, buildUrl(SERVER_PROTOCOL, SERVER_HOST, SERVER_PORT, share.getTestData().getString(API_VALUE)));
    }

    @Then("I can see the reponse")
    public void checkResponse() {
        System.out.println(" response: " + share.getResponse().asString());
        share.getResponse().then().assertThat().body("merchantId", equalTo(share.getTestData().getString("merchantId")));
    }

    private String buildUrl(String protocol, String host, String port, String api) {

        return readProp(PROPERTIES_PATH, protocol) + "://" + readProp(PROPERTIES_PATH, host) + ":" + readProp(PROPERTIES_PATH, port) + api;

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
            response = requestSpecification.when().get(url);
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
        String serviceCertificate = readProp(PROPERTIES_PATH, SERVICE_CERTIFICATE);
        String serviceCertPassword = readProp(PROPERTIES_PATH, SERVICE_CERT_PASS);
        if (isNotBlank(serviceCertificate) && serviceCertPassword != null) {
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
        // String[] headerNames = share.getTestData().getString(HEADER_NAME).split(";");
        // String[] headerValues = share.getTestData().getString(HEADER_VALUE).split(";");
        String[] headerNames = "Content-Type;X-WP-Diagnostic-CorrelationId".split(";");
        String[] headerValues = "application/json;Db4JU93EYMIgHG1P".split(";");

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
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(HTTP_CONNECTION_TIMEOUT, Integer.parseInt(readProp(EnvironmentUtil.GENERAL_PROPERTIES_PATH, HTTP_CONNECTION_TIMEOUT)))
                        .setParam(HTTP_SOCKET_TIMEOUT, Integer.parseInt(readProp(EnvironmentUtil.GENERAL_PROPERTIES_PATH, HTTP_SOCKET_TIMEOUT))));

    }

}
