package page;

import org.openqa.selenium.WebElement;
import util.TestUtils;

public abstract class GeneralPage {

    protected void fillField(WebElement element, String field) {
        element.clear();
        element.sendKeys(field);
        TestUtils.pauseTest();
    }

    protected void clickElement(WebElement element){
        element.click();
        TestUtils.pauseTest();
    }
}
