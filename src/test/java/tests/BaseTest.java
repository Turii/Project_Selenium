package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Utils;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait5;
    private WebDriverWait wait10;

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
