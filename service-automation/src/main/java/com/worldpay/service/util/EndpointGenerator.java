package com.worldpay.service.util;

import static com.worldpay.service.constants.TestDataConstants.ServerDetails.CUSTOM_SERVER_HOST;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.CUSTOM_SERVER_PORT;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.CUSTOM_SERVER_PROTOCOL;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.CUSTOM_SERVER_VERSION;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_BASEPATH;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_ENDPOINT;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_HOST;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_PORT;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_PROTOCOL;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_SUBJECT;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SERVER_VERSION;
import static com.worldpay.service.constants.TestDataConstants.ServerDetails.SLASH;

import com.worldpay.service.constants.TestDataConstants;
import com.worldpay.service.entities.SharedData;
import com.worldpay.service.environment.Environment;

public class EndpointGenerator {
    
    SharedData share;
    
    public EndpointGenerator(SharedData share) {
        this.share = share;
    }
        
    public String generateEndpoint(String path) {

        String protocol = getProtocol();
        String host = getHost();
        String port = getPort();
        String basePath = getBasePath();
        if (!port.isEmpty())
            return protocol + "://" + host + ":" + port + basePath + path;
        else
            return protocol + "://" + host + basePath + path;

    }
    
    /**
     * Generates the path needed by each API to contain the version set in the property files
     * 
     * @return stringBuilder - the url after the protocol, host and port (e.g. /merchantHosted/v1.0/capture/201801092037030000000/cancel)
     */
    public String generatePath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(share.getTestData().getString(SERVER_SUBJECT)).append(SLASH).append(getServiceVersion())
                .append(share.getTestData().getString(SERVER_ENDPOINT));
        return stringBuilder.toString();
    }
    
    /**
     * @return the service version as String the service version is specified by default in property file but can be overwritten with a
     *         custom value from story file(or table file)
     */
    public String getServiceVersion() {
        String customServerVersion = share.getTestData().getString(CUSTOM_SERVER_VERSION);
        return (customServerVersion != null ? share.getTestData().getString(SERVER_VERSION, customServerVersion)
                : share.getTestData().getString(SERVER_VERSION, Environment.ENVIRONMENT.get().getServerVersion()));
    }

    /**
     * @return port as String the port is specified by default in property file but can be overwritten with a custom value from story
     *         file(or table file)
     */
    private String getPort() {
        String customServerPort = share.getTestData().getString(CUSTOM_SERVER_PORT);
        return (customServerPort != null ? share.getTestData().getString(SERVER_PORT, customServerPort)
                : share.getTestData().getString(SERVER_PORT, Environment.ENVIRONMENT.get().getServerPort()));
    }

    /**
     * @return host name as String the host name is specified by default in property file but can be overwritten with a custom value from
     *         story file(or table file)
     */
    private String getHost() {
        String customServerPort = share.getTestData().getString(CUSTOM_SERVER_HOST);
        return (customServerPort != null ? share.getTestData().getString(SERVER_HOST, customServerPort)
                : share.getTestData().getString(SERVER_HOST, Environment.ENVIRONMENT.get().getServerHost()));
    }

    /**
     * @return protocol as String the protocol is specified by default in property file but can be overwritten with a custom value from
     *         story file(or table file)
     */
    private String getProtocol() {
        String customServerProtocol = share.getTestData().getString(CUSTOM_SERVER_PROTOCOL);
        return (customServerProtocol != null ? share.getTestData().getString(SERVER_PROTOCOL, customServerProtocol)
                : share.getTestData().getString(SERVER_PROTOCOL, Environment.ENVIRONMENT.get().getServerProtocol()));
    }

    /**
     * @return basePath as String the basePath is specified by default in property file but can be overwritten with a custom value from
     *         story file(or table file)
     */
    public String getBasePath() {
        String customServerBasePath = share.getTestData().getString(TestDataConstants.ServerDetails.CUSTOM_SERVER_BASEPATH);
        return (customServerBasePath != null ? share.getTestData().getString(SERVER_BASEPATH, customServerBasePath)
                : share.getTestData().getString(SERVER_BASEPATH, Environment.ENVIRONMENT.get().getServerBasePath()));
    }
    
}
