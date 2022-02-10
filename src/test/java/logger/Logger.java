package logger;

import org.slf4j.LoggerFactory;

public class Logger {

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger("MyLogger");

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void error(String message) {
        LOGGER.error(message);
    }
}
