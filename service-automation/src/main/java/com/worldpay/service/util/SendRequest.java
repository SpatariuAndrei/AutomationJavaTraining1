package com.worldpay.service.util;

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
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.worldpay.service.entities.SharedData;
import com.worldpay.service.environment.Environment;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendRequest {
    
    SharedData share;
    RequestSpecification requestSpecification;
    
    public SendRequest(SharedData share, RequestSpecification requestSpecification) {
        this.share = share;
        this.requestSpecification = requestSpecification;
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
    public void sendHttpRequest(String requestMethod, String url) {

        try {
            share.setResponse(chooseMethodAndSendRequest(requestMethod, url));
            share.getResponse().getBody().prettyPrint();
        } catch (Exception e) {
            fail(String.format("Failed to connect to %s %n %s", url, e));
        }
    }
     
    public RequestSpecification setRequestSpecificationForServer(String jSonRequest) {
        
        Map<String, String> headersMap = parseHeaderInfo();
        requestSpecification = given().config(configHttpClient()).relaxedHTTPSValidation();
        String serviceCertificate = Environment.ENVIRONMENT.get().getServerCertificate();
        String serviceCertPassword = Environment.ENVIRONMENT.get().getServerCertPass();
        if (StringUtils.isNotBlank(serviceCertificate) && serviceCertPassword != null) {
            requestSpecification = requestSpecification.trustStore(serviceCertificate, serviceCertPassword);
        }
        requestSpecification.headers(headersMap).body(jSonRequest);
        return requestSpecification;
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
                .httpClient(HttpClientConfig.httpClientConfig().setParam(HTTP_CONNECTION_TIMEOUT_PARAM, Integer.parseInt(Environment.ENVIRONMENT.get().getHttpConnectionTimeout()))
                        .setParam(HTTP_SOCKET_TIMEOUT_PARAM, Integer.parseInt(Environment.ENVIRONMENT.get().getHttpSocketTimeout())));

    }

}
