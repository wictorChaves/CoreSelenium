package selenium.drives;

import selenium.enums.Driver;
import org.openqa.selenium.WebDriver;

public class DriverManagerSelect {

    public WebDriver getDriver(Driver driver, String url) {
        switch (driver) {
            case CHROME:
                return new ChromeDriverManager().getDriver(url);
            case FIREFOX:
                return new FirefoxDriverManager().getDriver(url);
            default:
                throw new UnsupportedOperationException("Drive não implementado!");
        }
    }

}
