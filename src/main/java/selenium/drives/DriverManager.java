package selenium.drives;

import org.openqa.selenium.WebDriver;

public interface DriverManager {
    public WebDriver getDriver(String url);
}
