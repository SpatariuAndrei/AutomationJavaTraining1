package com.worldpay.service.rest;

import static com.worldpay.service.constants.TestDataConstants.Json.JSON_REQUEST;
import static com.worldpay.service.constants.TestDataConstants.Json.JSON_REQUEST_PATH;
import static com.worldpay.service.constants.TestDataConstants.Json.JSON_SCHEMA;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_CUSTOM_PATH;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.worldpay.service.entities.SharedData;
import com.worldpay.service.util.EndpointGenerator;
import com.worldpay.service.util.FileUtil;
import com.worldpay.service.util.SendRequest;
import com.worldpay.service.util.TestDataUtil;

import io.restassured.specification.RequestSpecification;

public class RestSubmissionSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestSubmissionSteps.class);
    private static final String REQUEST = "Request: \n{}";
    private static final String RESPONSE = "Response: \n{}";
    private RequestSpecification requestSpecification;
    private String jSonRequest;
    private TestDataUtil testDataUtil;
    private SharedData share;
    private EndpointGenerator endpointGenerator;
    private SendRequest sendRequest;

    public RestSubmissionSteps(SharedData share) {
        this.share = share;
    }

    @Before
    @BeforeScenario
    public void setUp() {
        endpointGenerator = new EndpointGenerator(share);
        sendRequest = new SendRequest(share, requestSpecification);
        testDataUtil = new TestDataUtil(share);
    }

    @When("I create JSON request")
    public void createJsonRequest() {
        jSonRequest = testDataUtil.createJsonFromTestData(share.getRequestData());
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
        sendRequest.setRequestSpecificationForServer(jSonRequest);
    }

    @When("I $requestMethod the JSon request")
    public void sendRequest(String requestMethod) {
        String url = endpointGenerator.generateEndpoint(endpointGenerator.generatePath());
        LOGGER.info("Service URL:" + url);
        sendRequest.sendHttpRequest(requestMethod, url);
    }

    @When("I $requestMethod the JSon request with custom parameters")
    public void sendRequestWithParameters(String requestMethod) {
        sendRequest.sendHttpRequest(requestMethod, endpointGenerator.generateEndpoint(share.getTestData().getString(SERVER_CUSTOM_PATH)));
    }

    @Then("I can validate the response")
    public void validateResponse() {
        share.getResponse().then().assertThat().body("merchantId", equalTo(share.getTestData().getString("merchantId")));
    }

    @Then("I can validate the response against the json schema")
    public void validateResponseAgainstSchema() {
        share.getResponse().then().assertThat().body(matchesJsonSchemaInClasspath(share.getTestData().getString(JSON_SCHEMA)));
    }

}
