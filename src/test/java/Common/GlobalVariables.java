package Common;

import java.time.Duration;

public class GlobalVariables {
    public static final String HEROKU_URL = " https://the-internet.herokuapp.com/";
    public static String PROJECT_PATH = System.getProperty("user.dir");
    public static String OUTPUT_PATH = PROJECT_PATH + "/resources/output/";
    public static String JSON_FILE_PATH = PROJECT_PATH + "/src/test/java/";
    public static final Duration WAIT_TIME_60 = Duration.ofSeconds(60);
    public static int TOTAL_TESTCASES = 0;
    public static int TOTAL_EXECUTED = 0;
    public static int TOTAL_PASSED = 0;
    public static int TOTAL_FAILED = 0;
    public static int TOTAL_SKIPPED = 0;

}
