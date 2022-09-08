package runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testcase.addressbook.v4_0.AddAddressBook;

import java.nio.file.Paths;

public class Executor {

    private static final Logger logger = LoggerFactory.getLogger(Executor.class);

    public static final String driverPath = Paths.get("resources", "browser", "geckodriver.exe").toString();

    public static final String driverProperty = Paths.get("webdriver.gecko.driver").toString();

    static {
//        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        System.setProperty(driverProperty, driverPath);
    }

    public static void run(Class<?> testcase) {
        long startTime = System.currentTimeMillis();
        Result result = JUnitCore.runClasses(testcase);
        if (!result.wasSuccessful()) {
            logger.warn("Test failed");
            for (Failure failure : result.getFailures()) {
                logger.warn(failure.toString());
            }
        } else {
            logger.info("Tet passed");
        }
        long elapsed = System.currentTimeMillis() - startTime;
        logger.info("Time spent: " + elapsed);
    }

    public static void main(String[] args) {
        run(AddAddressBook.class);
    }

}
