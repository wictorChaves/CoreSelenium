package selenium.elements;

import org.openqa.selenium.*;

import java.util.List;

public class ElementMain implements WebElement {

    WebElement self;

    ElementMain(WebElement element) {
        self = element;
    }

    @Override
    public void click() {
        self.click();
    }

    @Override
    public void submit() {
        self.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        self.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        self.clear();
    }

    @Override
    public String getTagName() {
        return self.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return self.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return self.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return self.isEnabled();
    }

    @Override
    public String getText() {
        return self.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return self.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return self.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return self.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return self.getLocation();
    }

    @Override
    public Dimension getSize() {
        return self.getSize();
    }

    @Override
    public Rectangle getRect() {
        return self.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return self.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return self.getScreenshotAs(outputType);
    }

}
