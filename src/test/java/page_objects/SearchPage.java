package page_objects;

import logger.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.helpers.PageActions;

public class SearchPage {

    protected WebDriver driver;

    @FindBy(how = How.ID, using = "SearchInput")
    private static WebElement searchInput;

    @FindBy(how = How.CSS, using = "#MainContent > div > div > div > div > form > div > span > button")
    private static WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"MainContent\"]/div[2]/a/div[2]/div")
    private static WebElement result;

    @FindBy(how = How.XPATH, using = "//*[@id=\"MainContent\"]/div[1]/div/p")
    private static WebElement message;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public static void assertSearchInputAvailable() {
        PageActions.assertElementPresent(searchInput);
        PageActions.assertElementPresent(submitButton);
    }

    public static void searchProduct(String productName) {
        PageActions.type(searchInput, productName);
        PageActions.click(submitButton);
    }

    public static void verifySearchResults(String productName) {
        PageActions.assertElementText(result, productName);
    }

    public static void verifyMessage(String messageText) {
       PageActions.assertElementText(message, messageText);
    }
}
