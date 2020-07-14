package selenium.elements;

import org.openqa.selenium.*;

public class InputTextCustom extends ElementMain {

    public InputTextCustom(WebElement element) {
        super(element);
    }

    public void setValue(String value) {
        self.clear();
        self.sendKeys(value);
    }

    public void clean() {
        setValue(" ");
        self.sendKeys(Keys.BACK_SPACE);
    }

    public String getValue() {
        String text  = self.getText();
        String value = self.getAttribute("value");
        return (text.length() > value.length()) ? text : value;
    }


}
