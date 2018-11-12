package com.worldpay.service.util;


import static com.worldpay.service.util.FileUtil.readProp;

/**
 * Utility class used for environment related operations.
 */
public class EnvironmentUtil {

    private static final String ENV = "environment";
    public static final String GENERAL_PROPERTIES_PATH = "/general.properties";
    private static final String DEFAULT_ENV = "env";
    private static final String SERVICE_VERSION = "service.version";

    private EnvironmentUtil() {
        throw new IllegalAccessError("Utility class");
    }

    public static Environment getEnvironment() {
        String environment = System.getProperty(ENV, DEFAULT_ENV);
        if (DEFAULT_ENV.equals(environment)) {
            environment = FileUtil.readProp(GENERAL_PROPERTIES_PATH, ENV);
        }
        return Environment.getEnvironmentByName(environment);
    }

    /**
     * 
     * @return serviceVersion - the version of the service by reading either from system properties or "general.properties" file
     * 
     */

    public static String getServiceVersion() {
        String serviceVersion = System.getProperty(SERVICE_VERSION);
        if (serviceVersion == null) {
            serviceVersion = readProp(EnvironmentUtil.GENERAL_PROPERTIES_PATH, SERVICE_VERSION);
        }
        return serviceVersion;
    }

}
