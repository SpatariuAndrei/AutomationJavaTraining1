package com.worldpay.service.environment;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;

public enum Environment {

    ENVIRONMENT;

    protected EnvironmentBean env;

    public EnvironmentBean get() {
        return env;
    }

    /**
     * No-arg constructor (takes no arguments).
     */
    Environment() {
        env = new EnvironmentBean();
        readConfigurationData();
        populate();
    }

    private void readConfigurationData() {

        String environment = System.getProperty("env", null);

        // Use specified environment data when provided otherwise use default properties file.
        try {
            if (environment != null) {
                env.envData.addConfiguration(new PropertiesConfiguration(EnvironmentBean.class.getResource("/environment/" + environment + ".properties")));
            } else {
                File testProperties = new File(System.getProperty("user.home") + "/qa-localhost.properties");

                if (!testProperties.exists()) {
                    throw new FileNotFoundException("Default Test properties file not found (~/qa-localhost.properties)");
                }
                env.envData.addConfiguration(new PropertiesConfiguration(testProperties));

            }
        } catch (Exception e) {
            throw new IllegalStateException("Invalid environment test configuration parameters", e);
        }
    }

    private void populate() {
        env.setServerProtocol(env.envData.getString("server.protocol"));
        env.setServerHost(env.envData.getString("server.host"));
        env.setServerPort(env.envData.getString("server.port"));
        env.setServerVersion(env.envData.getString("server.version"));
        env.setHttpConnectionTimeout(env.envData.getString("http.connection.timeout"));
        env.setHttpSocketTimeout(env.envData.getString("http.socket.timeout"));
        env.setSimulatorCertificate(env.envData.getString("simulator.certificate"));
        env.setSimulatorCertPass(env.envData.getString("simulator.cert.pass"));
    }

    public class EnvironmentBean implements java.io.Serializable {
        
        private static final long serialVersionUID = 1L;

        private CompositeConfiguration envData = new CompositeConfiguration();

        private String serverProtocol;
        private String serverHost;
        private String serverPort;
        private String serverVersion;
        private String httpConnectionTimeout;
        private String httpSocketTimeout;
        private String simulatorCertificate;
        private String simulatorCertPass;
        
        public String getServerProtocol() {
            return serverProtocol;
        }
        
        public void setServerProtocol(String serverProtocol) {
            this.serverProtocol = serverProtocol;
        }
        
        public String getServerHost() {
            return serverHost;
        }
        
        public void setServerHost(String serverHost) {
            this.serverHost = serverHost;
        }
        
        public String getServerPort() {
            return serverPort;
        }
        
        public void setServerPort(String serverPort) {
            this.serverPort = serverPort;
        }
        
        public String getServerVersion() {
            return serverVersion;
        }
        
        public void setServerVersion(String serverVersion) {
            this.serverVersion = serverVersion;
        }

        public String getHttpConnectionTimeout() {
            return httpConnectionTimeout;
        }

        public void setHttpConnectionTimeout(String httpConnectionTimeout) {
            this.httpConnectionTimeout = httpConnectionTimeout;
        }

        public String getHttpSocketTimeout() {
            return httpSocketTimeout;
        }

        public void setHttpSocketTimeout(String httpSocketTimeout) {
            this.httpSocketTimeout = httpSocketTimeout;
        }

        public String getSimulatorCertificate() {
            return simulatorCertificate;
        }

        public void setSimulatorCertificate(String simulatorCertificate) {
            this.simulatorCertificate = simulatorCertificate;
        }

        public String getSimulatorCertPass() {
            return simulatorCertPass;
        }

        public void setSimulatorCertPass(String simulatorCertPass) {
            this.simulatorCertPass = simulatorCertPass;
        }
        
    }
}
