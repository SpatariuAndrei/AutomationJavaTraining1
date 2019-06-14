package com.worldpay.service.entities;

import org.apache.commons.configuration.CompositeConfiguration;

import io.restassured.response.Response;

public class SharedData {

    private CompositeConfiguration testData;
    private CompositeConfiguration requestData;
    private Response response;

    public CompositeConfiguration getTestData() {
        return testData;
    }

    public CompositeConfiguration getRequestData() {
        return requestData;
    }

    public void setTestData(CompositeConfiguration testData) {
        this.testData = testData;
    }

    public void setRequestData(CompositeConfiguration requestData) {this.requestData = requestData; }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
