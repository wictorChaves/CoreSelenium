package selenium.drives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements DriverManager {

    private static String url                 = "";
    private static String driveExecutablePath = "C:\\Users\\wicto\\OneDrive\\Documentos\\Wictor\\Bin\\selenium-driver\\Firefox\\geckodriver-64.exe";

    public WebDriver getDriver(String url) {
        this.url = url;
        return config();
    }

    private WebDriver config() {
        return config(false);
    }

    private static WebDriver config(boolean headless) {
        System.setProperty("webdriver.gecko.driver", driveExecutablePath);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        options.setLogLevel(FirefoxDriverLogLevel.TRACE);
        WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver(options);
        driver.get(url);
        return driver;
    }

}
