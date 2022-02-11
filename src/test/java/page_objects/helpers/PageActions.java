package page_objects.helpers;

import logger.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class PageActions {

    public static void click(WebElement element) {
        element.click();
    }

    public static void type(WebElement element, String input) {
        element.click();
        element.sendKeys(input);
    }

    public static void assertElementPresent(WebElement element) {
        Assertions.assertTrue(element.isDisplayed());
    }

    public static void assertElementText(WebElement element, String expectedText) {
        Logger.info("html element: " + element.getText());
        Logger.info("reference text: " + expectedText);
        Assertions.assertTrue(element.getText().equalsIgnoreCase(expectedText));
    }

    public static void assertElementValue(WebElement element, String expectedValue) {
        Assertions.assertTrue(element.getAttribute("value").equalsIgnoreCase(expectedValue));
    }
}
