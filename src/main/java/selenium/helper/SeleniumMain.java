package selenium.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class SeleniumMain {

    protected WebDriver     _driver;
    private   WebDriverWait _wait;

    public SeleniumMain(WebDriver driver) {
        _driver = driver;
        _wait   = new WebDriverWait(_driver, 100L);
    }

    protected void _fieldWithJavascript(By by, String value) throws InterruptedException {
        _driver.findElement(by).sendKeys("");
        Thread.sleep(1000L);
        _driver.findElement(by).sendKeys(value);
    }

    protected WebElement _getElementWaitLoad(By by) {
        return _wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement _getElementWaitLoad(By by, long time) {
        WebDriverWait wait = new WebDriverWait(_driver, time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void _waitLoad(By selector) {
        final By selectorInput = selector;
        _wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement button = driver.findElement(selectorInput);
                return (!button.isDisplayed());
            }
        });
    }

    protected List<WebElement> _getElementsWaitLoad(By by) {
        return _wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void _clickOut() {
        _driver.findElement(By.xpath("/html/body")).click();
    }

    public boolean CheckElement(By by) {
        if (TryFindElement(by)) {
            return IsElementVisible(_driver.findElement(by));
        }
        return false;
    }

    public boolean TryFindElement(By by) {
        try {
            _driver.findElement(by);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean IsElementVisible(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    public boolean CheckMessage(String message, By by) {
        WebElement element = null;
        element = _getElementWaitLoad(by);
        return element.getText().contains(message);
    }

    protected void _waitUtilClassRemove(String classe, By selector) {
        final String classInput    = classe;
        final By     selectorInput = selector;
        _wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement button  = driver.findElement(selectorInput);
                String     classes = button.getAttribute("class");
                return (!classes.contains(classInput));
            }
        });
    }

    public abstract void Execute() throws InterruptedException;

}
