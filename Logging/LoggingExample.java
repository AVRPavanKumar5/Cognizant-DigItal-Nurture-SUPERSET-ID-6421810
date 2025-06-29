package Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        String username = "john_doe";
        logger.info("User '{}' attempted to log in.", username);
        boolean loginSuccess = false;
        if (!loginSuccess) {
            logger.error("Login failed for user '{}'.", username);
        }
    }
}
