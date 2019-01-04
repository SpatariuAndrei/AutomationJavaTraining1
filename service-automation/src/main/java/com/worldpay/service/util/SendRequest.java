package com.worldpay.service.util;

import static com.worldpay.service.constants.HttpConstants.RequestMethods.DELETE;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.GET;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.HEAD;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.OPTIONS;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.POST;
import static com.worldpay.service.constants.HttpConstants.RequestMethods.PUT;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.fail;

import com.worldpay.service.entities.SharedData;

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
            String response = share.getResponse().getBody().prettyPrint();
            //LOGGER.info(RESPONSE, response);
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
    

}
