package selenium.drives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements DriverManager {

    private static String _url                 = "";
    private static String _driveExecutablePath = "C:\\Users\\wicto\\OneDrive\\Documentos\\Wictor\\Bin\\selenium-driver\\Chrome\\80.0.3987.16.exe";

    public WebDriver GetDriver(String url) {
        _url = url;
        return _config();
    }

    private WebDriver _config() {
        return _config(false);
    }

    private static WebDriver _config(boolean headless) {
        System.setProperty("webdriver.chrome.driver", _driveExecutablePath);
        ChromeOptions options = new ChromeOptions();
        if (headless)
            options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--auto-open-devtools-for-tabs");

        options.setBinary("C:\\Users\\wicto\\OneDrive\\Documentos\\Wictor\\Bin\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe");
        options.addArguments("chrome.switches", "--disable-extensions");
        options.addArguments("--user-data-dir=C:\\Users\\wicto\\OneDrive\\Documentos\\Wictor\\Bin\\GoogleChromePortable\\Data\\profile");
        options.addArguments("--profile-directory=Profile 1");

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        driver.get(_url);
        return driver;
    }

}
