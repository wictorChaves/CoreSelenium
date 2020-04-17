package selenium.drives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements DriverManager {

    private static String _url                 = "";
    private static String _driveExecutablePath = "C:\\Users\\wicto\\OneDrive\\Documentos\\Wictor\\Bin\\selenium-driver\\Firefox\\geckodriver-64.exe";

    public WebDriver GetDriver(String url) {
        _url = url;
        return _config();
    }

    private WebDriver _config() {
        return _config(false);
    }

    private static WebDriver _config(boolean headless) {
        System.setProperty("webdriver.gecko.driver", _driveExecutablePath);
        /*ProfilesIni    profileIni = new ProfilesIni();
        FirefoxProfile profile    = profileIni.getProfile("default");
        FirefoxOptions options    = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        options.setProfile(profile);
        options.addArguments("-headless");
        WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver(options);
        driver.manage().window().maximize();*/

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        options.setLogLevel(FirefoxDriverLogLevel.TRACE);
        WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver(options);
        driver.get(_url);
        return driver;
    }

}
