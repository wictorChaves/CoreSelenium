package selenium.helper;

import org.openqa.selenium.*;

public abstract class SeleniumMain extends SeleniumCore {

    public SeleniumMain(WebDriver driver) {
        super(driver);
    }

    public abstract void execute() throws InterruptedException;

}
