package communicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Talk {
    private static final Logger LOGGER = LoggerFactory.getLogger(Talk.class);

    public void printingHello(int nr) {
        for (int i = 0; i < nr; i++) {
            LOGGER.info("Hello from RestAssured...");
        }
    }
}
