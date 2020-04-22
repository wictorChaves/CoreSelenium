package selenium.drives;

import helper.AppConfigHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements DriverManager {

    private static String _url = "";

    public WebDriver GetDriver(String url) {
        _url = url;
        return _config();
    }

    private WebDriver _config() {
        return _config(false);
    }

    private static WebDriver _config(boolean headless) {

        System.setProperty("webdriver.chrome.driver", AppConfigHelper.GetProp("drive_executable_path"));
        ChromeOptions options = new ChromeOptions();

        if (Boolean.parseBoolean(AppConfigHelper.GetProp("headless")))
            options.addArguments("--headless");

        if (Boolean.parseBoolean(AppConfigHelper.GetProp("start_maximized")))
            options.addArguments("--start-maximized");

        if (Boolean.parseBoolean(AppConfigHelper.GetProp("auto_open_devtools_for_tabs")))
            options.addArguments("--auto-open-devtools-for-tabs");

        String binary = AppConfigHelper.GetProp("binary");
        if (!binary.equals(""))
            options.setBinary(binary);

        if (Boolean.parseBoolean(AppConfigHelper.GetProp("disable_extensions")))
            options.addArguments("chrome.switches", "--disable-extensions");

        String user_data_dir = AppConfigHelper.GetProp("user_data_dir");
        if (!user_data_dir.equals(""))
            options.setBinary("--user-data-dir=" + user_data_dir);

        String profile_directory = AppConfigHelper.GetProp("profile_directory");
        if (!profile_directory.equals(""))
            options.setBinary("--profile-directory=" + profile_directory);

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        driver.get(_url);
        return driver;
    }

}
