package com.worldpay.service.util;

/**
 * Contains environment specific details.
 */
public enum Environment {
    LOCAL_ENV("localEnv", "/local.properties", "Profile for local server", "/u01/app/springboot/"), TEST_DEV_ENV("testDevEnv", "/testDev.properties",
            "Profile for remote server", "/u01/app/springboot/");

    private String name;
    private String propertiesPath;
    private String profilesDescription;
    private String logsRootPath;

    Environment(String name, String propertiesPath, String profilesDescription, String logsRootPath) {
        this.name = name;
        this.propertiesPath = propertiesPath;
        this.profilesDescription = profilesDescription;
        this.logsRootPath = logsRootPath;
    }

    public String getName() {
        return name;
    }

    public String getPropertiesPath() {
        return propertiesPath;
    }

    public String getProfilesDescription() {
        return profilesDescription;
    }

    public String getLogsRootPath() {
        return logsRootPath;
    }

    public static Environment getEnvironmentByName(String name) {

        for (Environment environment : Environment.values()) {
            if (environment.name.equals(name)) {
                return environment;
            }
        }
        return null;
    }
}
