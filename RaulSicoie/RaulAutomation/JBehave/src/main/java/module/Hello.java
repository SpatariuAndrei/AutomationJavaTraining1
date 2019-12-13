package module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {

    static final Logger logger = LoggerFactory.getLogger(Hello.class);

    public Hello() {
        logger.info("Hello from JBehave module...");
    }
}
