package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Enumeration;
import java.util.Properties;

public abstract class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait5;
    private WebDriverWait wait10;
    private static Properties properties = new Properties();


    @BeforeSuite
    protected void initProperties() {
        boolean isServerRun = System.getenv("CI_RUN") != null;
        if (isServerRun) {
//            System.setProperty("JUICE_SHOP_EMAIL", System.getenv("JUICE_SHOP_EMAIL"));
//            System.setProperty("JUICE_SHOP_PASSWORD", System.getenv("JUICE_SHOP_PASSWORD"));
        } else {
            try {
                InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("local.properties");
                if (inputStream == null) {
                    System.out.println("ERROR: The \u001B[31mlocal.properties\u001B[0m file not found in src/test/resources/ directory.");
                    System.out.println("You need to create it from local.properties.TEMPLATE file.");
                    System.exit(1);
                }
                properties.load(inputStream);
            } catch (IOException ignore) {
            }

            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                String value = properties.getProperty(key);
                System.setProperty(key, value);
            }
        }
    }

    @BeforeMethod
    protected void beforeMethod() {
        startDriver();
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            Utils.takeScreenshot(getDriver(), method.getName(), this.getClass().getName());
        }
        stopDriver();
        Utils.logf("Execution time is %o sec\n\n", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000);
    }

    protected void startDriver() {
        Utils.log("Browser open");
        driver = Utils.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getWeb();
    }

    protected void stopDriver() {
        closeDriver();
        nullWait5();
        nullWait10();
    }

    protected void closeDriver() {
        Utils.log("Browser closed");
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }

    protected void getWeb() {
        Utils.log("Get web page");
    }

    protected void nullWait5() {
        if (wait5 == null) {
            return;
        }
        wait5 = null;
    }

    protected void nullWait10() {
        if (wait10 == null) {
            return;
        }
        wait10 = null;
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
