package selenium.elements;

import org.openqa.selenium.*;

public class InputTextCustom extends ElementMain {

    public InputTextCustom(WebElement element) {
        super(element);
    }

    public void SetValue(String value) {
        self.clear();
        self.sendKeys(value);
    }

    public void Clean() {
        SetValue(" ");
        self.sendKeys(Keys.BACK_SPACE);
    }

    public String GetValue() {
        String text  = self.getText();
        String value = self.getAttribute("value");
        return (text.length() > value.length()) ? text : value;
    }


}
