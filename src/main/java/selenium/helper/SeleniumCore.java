package selenium.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class SeleniumCore {

    protected WebDriver     driver;
    private   WebDriverWait wait;
    private   Long          timeoutTime = 100L;

    public SeleniumCore(WebDriver driver) {
        this.driver = driver;
        wait        = new WebDriverWait(this.driver, timeoutTime);
    }

    protected WebElement getElementWaitLoad(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement getElementWaitLoad(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void clickOut() {
        driver.findElement(By.xpath("/html/body")).click();
    }

    protected void fieldWithJavascript(By by, String value) throws InterruptedException {
        driver.findElement(by).sendKeys("");
        Thread.sleep(1000L);
        driver.findElement(by).sendKeys(value);
    }

    protected void waitLoad(By selector) {
        final By selectorInput = selector;
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement button = driver.findElement(selectorInput);
                return (!button.isDisplayed());
            }
        });
    }

    protected List<WebElement> getElementsWaitLoad(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public boolean checkElement(By by) {
        if (tryFindElement(by)) {
            return isElementVisible(driver.findElement(by));
        }
        return false;
    }

    public boolean tryFindElement(By by) {
        try {
            driver.findElement(by);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean isElementVisible(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    public boolean checkMessage(String message, By by) {
        WebElement element = null;
        element = getElementWaitLoad(by);
        return element.getText().contains(message);
    }

    protected void waitUtilClassRemove(String classe, By selector) {
        final String classInput    = classe;
        final By     selectorInput = selector;
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement button  = driver.findElement(selectorInput);
                String     classes = button.getAttribute("class");
                return (!classes.contains(classInput));
            }
        });
    }

    public void waitLoadElement(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutTime);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

}
