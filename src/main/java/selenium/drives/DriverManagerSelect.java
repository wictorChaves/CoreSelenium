package selenium.drives;

import selenium.enums.Driver;
import org.openqa.selenium.WebDriver;

public class DriverManagerSelect {

    public WebDriver GetDriver(Driver driver, String url) {
        switch (driver) {
            case CHROME:
                return new ChromeDriverManager().GetDriver(url);
            case FIREFOX:
                return new FirefoxDriverManager().GetDriver(url);
            default:
                throw new UnsupportedOperationException("Drive não implementado!");
        }
    }

}
