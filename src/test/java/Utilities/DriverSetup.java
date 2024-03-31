package Utilities;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import Utilities.TestReporter;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utilities.Utility;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverSetup {
    public static WebDriver driver;

    public static synchronized WebDriver initializeDriver(ExtentTest logTest, String browser) {
        try {
            Utility.log4j.info("createInstance method - Starts");
            TestReporter.logInfo(logTest, "createInstance method - Starts");

            switch (browser) {
                case "chrome":
                    ChromeOptions ChOptions = new ChromeOptions();
                    ChOptions.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ChOptions);
                    break;
                case "firefox":
                    FirefoxOptions FFOptions = new FirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(FFOptions);
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            return driver;
        } catch (Exception e) {
            Utility.log4j.error("createInstance method - ERROR: ", e);
            TestReporter.logException(logTest, "createInstance method - ERROR: ", e);
        }
        return null;
    }
}
