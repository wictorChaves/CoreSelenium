package selenium.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectCustom extends Select {

    WebElement self;

    public SelectCustom(WebElement element) {
        super(element);
        self = element;
    }

    public void setOptionByText(String text) {
        List<WebElement> allOptions = this.getOptions();

        for (WebElement e : allOptions) {
            String optionText    = e.getText().trim().toLowerCase();
            String textFormatted = text.trim().toLowerCase();
            if (optionText.equals(textFormatted)) {
                self.click();
                {
                    e.click();
                }
                return;
            }
        }
    }

    public void setOptionByValue(String value) {
        List<WebElement> allOptions = this.getOptions();

        for (WebElement e : allOptions) {
            String optionValue    = e.getAttribute("value");
            String valueFormatted = value.trim().toLowerCase();
            if (optionValue.equals(valueFormatted)) {
                self.click();
                {
                    e.click();
                }
                return;
            }
        }
    }

}
