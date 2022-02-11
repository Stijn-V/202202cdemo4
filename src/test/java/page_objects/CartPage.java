package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.helpers.PageActions;

public class CartPage {

    protected WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shopify-section-cart-template\"]/div/div/h1")
    private static WebElement pageTitle;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shopify-section-cart-template\"]/div/div/p")
    private static WebElement emptyCartMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shopify-section-cart-template\"]/div/div/a")
    private static WebElement continueShoppingButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/main/div/div/form/table/tbody/tr/td[4]/div/input")
    private static WebElement productCounter;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public static void verifyCartPageIsVisible() {
        PageActions.assertElementPresent(pageTitle);
        PageActions.assertElementText(pageTitle, "Your cart");
    }

    public static void verifyEmptyCartMessage(String messageText) {
        PageActions.assertElementText(emptyCartMessage, messageText);
    }

    public static void clickContinueShopping() {
        PageActions.click(continueShoppingButton);
    }

    public static void checkCounterValue(int expectedCounterValue) {
        PageActions.assertElementValue(productCounter, Integer.toString(expectedCounterValue));
    }
}
