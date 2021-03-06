package selenium.drives;

import helper.AppConfigHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements DriverManager {

    private static String url = "";

    public WebDriver getDriver(String url) {
        ChromeDriverManager.url = url;
        return config();
    }

    private WebDriver config() {
        return config(false);
    }

    private static WebDriver config(boolean headless) {

        System.setProperty("webdriver.chrome.driver", AppConfigHelper.getProp("drive_executable_path"));
        ChromeOptions options = new ChromeOptions();

        if (Boolean.parseBoolean(AppConfigHelper.getProp("headless"))) {
            options.addArguments("--headless");
        }

        if (Boolean.parseBoolean(AppConfigHelper.getProp("start_maximized"))) {
            options.addArguments("--start-maximized");
        }

        if (Boolean.parseBoolean(AppConfigHelper.getProp("auto_open_devtools_for_tabs"))) {
            options.addArguments("--auto-open-devtools-for-tabs");
        }

        String binary = AppConfigHelper.getProp("binary");
        if (!binary.equals("")) {
            options.setBinary(binary);
        }

        if (Boolean.parseBoolean(AppConfigHelper.getProp("disable_extensions"))) {
            options.addArguments("chrome.switches", "--disable-extensions");
        }

        String user_data_dir = AppConfigHelper.getProp("user_data_dir");
        if (!user_data_dir.equals("")) {
            options.setBinary("--user-data-dir=" + user_data_dir);
        }

        String profile_directory = AppConfigHelper.getProp("profile_directory");
        if (!profile_directory.equals("")) {
            options.setBinary("--profile-directory=" + profile_directory);
        }

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        driver.get(url);
        return driver;
    }

}
